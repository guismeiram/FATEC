"Jwt": {
  "Key": "chave-super-secreta-para-aula",
  "Issuer": "AulaApi",
  "Audience": "AulaBlazor",
  "ExpireMinutes": 10
}

_

using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;

namespace Aula11.Api.Services
{
    public class TokenService
    {
        private readonly IConfiguration _config;

        public TokenService(IConfiguration config)
        {
            _config = config;
        }

        public string GerarToken(string email)
        {
            var claims = new[]
            {
                new Claim(ClaimTypes.Name, email),
                new Claim(ClaimTypes.Role, "Usuario")
            };

            var key = new SymmetricSecurityKey(
                Encoding.UTF8.GetBytes(_config["Jwt:Key"]));

            var creds = new SigningCredentials(key, SecurityAlgorithms.HmacSha256);

            var token = new JwtSecurityToken(
                issuer: _config["Jwt:Issuer"],
                audience: _config["Jwt:Audience"],
                claims: claims,
                expires: DateTime.UtcNow.AddMinutes(
                    int.Parse(_config["Jwt:ExpireMinutes"])),
                signingCredentials: creds);

            return new JwtSecurityTokenHandler().WriteToken(token);
        }
    }
}

_

using Aula11.Api.Services;
using Microsoft.AspNetCore.Mvc;

namespace Aula11.Api.Controllers
{
    [ApiController]
    [Route("api/auth")]
    public class AuthController : ControllerBase
    {
        private readonly TokenService _tokenService;

        public AuthController(TokenService tokenService)
        {
            _tokenService = tokenService;
        }

        [HttpPost("login")]
        public IActionResult Login(LoginDto dto)
        {
            // Simulação de login
            if (dto.Email == "admin@teste.com" && dto.Password == "123456")
            {
                var token = _tokenService.GerarToken(dto.Email);
                return Ok(new { accessToken = token });
            }

            return Unauthorized();
        }
    }
}

_

public record LoginDto(string Email, string Password);

_

builder.Services.AddAuthentication("Bearer")
    .AddJwtBearer("Bearer", options =>
    {
        options.TokenValidationParameters = new()
        {
            ValidateIssuer = true,
            ValidateAudience = true,
            ValidateLifetime = true,
            ValidateIssuerSigningKey = true,
            ValidIssuer = builder.Configuration["Jwt:Issuer"],
            ValidAudience = builder.Configuration["Jwt:Audience"],
            IssuerSigningKey = new SymmetricSecurityKey(
                Encoding.UTF8.GetBytes(builder.Configuration["Jwt:Key"]))
        };
    });

app.UseAuthentication();
app.UseAuthorization();

_

[Authorize]
[HttpGet("seguro")]
public IActionResult Seguro()
{
    return Ok("Acesso autorizado");
}

_

using Microsoft.AspNetCore.Components.Server.ProtectedBrowserStorage;

public class AuthService
{
    private readonly HttpClient _http;
    private readonly ProtectedLocalStorage _storage;

    public AuthService(HttpClient http, ProtectedLocalStorage storage)
    {
        _http = http;
        _storage = storage;
    }

    public async Task<bool> LoginAsync(string email, string senha)
    {
        var response = await _http.PostAsJsonAsync(
            "api/auth/login",
            new { Email = email, Password = senha });

        if (!response.IsSuccessStatusCode)
            return false;

        var result = await response.Content.ReadFromJsonAsync<TokenResponse>();
        await _storage.SetAsync("token", result.AccessToken);

        return true;
    }

    public async Task<string?> GetTokenAsync()
    {
        var token = await _storage.GetAsync<string>("token");
        return token.Success ? token.Value : null;
    }

    public async Task LogoutAsync()
    {
        await _storage.DeleteAsync("token");
    }
}

public record TokenResponse(string AccessToken);

_

using System.Net.Http.Headers;

public class JwtHandler : DelegatingHandler
{
    private readonly AuthService _authService;

    public JwtHandler(AuthService authService)
    {
        _authService = authService;
    }

    protected override async Task<HttpResponseMessage> SendAsync(
        HttpRequestMessage request,
        CancellationToken cancellationToken)
    {
        var token = await _authService.GetTokenAsync();

        if (!string.IsNullOrEmpty(token))
        {
            request.Headers.Authorization =
                new AuthenticationHeaderValue("Bearer", token);
        }

        return await base.SendAsync(request, cancellationToken);
    }
}

_

builder.Services.AddTransient<JwtHandler>();

builder.Services.AddHttpClient("Api")
    .AddHttpMessageHandler<JwtHandler>();

_

<CascadingAuthenticationState>
    <Router AppAssembly="@typeof(App).Assembly">
        <Found Context="routeData">
            <AuthorizeRouteView RouteData="@routeData"
                                DefaultLayout="@typeof(MainLayout)">
                <NotAuthorized>
                    <p>Acesso negado.</p>
                </NotAuthorized>
            </AuthorizeRouteView>
        </Found>
    </Router>
</CascadingAuthenticationState>

_

@page "/admin"
@attribute [Authorize]

<h3>Área Administrativa</h3>

_

401 Unauthorized
→ Cliente chama /refresh
→ Novo Access Token
→ Retry request original

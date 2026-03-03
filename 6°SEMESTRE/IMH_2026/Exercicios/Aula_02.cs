namespace Aula01.Web.Models
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public bool Ativo { get; set; }
    }
}

_

namespace Aula01.Web.DTOs
{
    // DTO imutável usando record
    public record UsuarioDto(int Id, string Nome);
}

_

using Aula01.Web.DTOs;

namespace Aula01.Web.Services.Interfaces
{
    public interface IUsuarioService
    {
        Task<List<UsuarioDto>> ObterUsuariosAtivosAsync();
    }
}

_

using Aula01.Web.DTOs;
using Aula01.Web.Models;
using Aula01.Web.Services.Interfaces;

namespace Aula01.Web.Services
{
    public class UsuarioService : IUsuarioService
    {
        // Simulando base de dados em memória
        private readonly List<Usuario> _usuarios = new()
        {
            new Usuario { Id = 1, Nome = "Ana", Ativo = true },
            new Usuario { Id = 2, Nome = "Bruno", Ativo = false },
            new Usuario { Id = 3, Nome = "Carlos", Ativo = true }
        };

        public async Task<List<UsuarioDto>> ObterUsuariosAtivosAsync()
        {
            // Simula operação I/O
            await Task.Delay(300);

            // LINQ avançado + projeção para DTO
            return _usuarios
                .Where(u => u.Ativo)
                .OrderBy(u => u.Nome)
                .Select(u => new UsuarioDto(u.Id, u.Nome))
                .ToList();
        }
    }
}

_

builder.Services.AddScoped<IUsuarioService, UsuarioService>();

_

using Aula01.Web.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace Aula01.Web.Controllers
{
    public class HomeController : Controller
    {
        private readonly IUsuarioService _usuarioService;
        private readonly ILogger<HomeController> _logger;

        public HomeController(
            IUsuarioService usuarioService,
            ILogger<HomeController> logger)
        {
            _usuarioService = usuarioService;
            _logger = logger;
        }

        public async Task<IActionResult> Index()
        {
            _logger.LogInformation("Carregando usuários ativos");

            var usuarios = await _usuarioService.ObterUsuariosAtivosAsync();

            return View(usuarios);
        }
    }
}

_

@model List<Aula01.Web.DTOs.UsuarioDto>

<h2>Usuários Ativos</h2>

<ul>
@foreach (var usuario in Model)
{
    <li>@usuario.Nome</li>
}
</ul>

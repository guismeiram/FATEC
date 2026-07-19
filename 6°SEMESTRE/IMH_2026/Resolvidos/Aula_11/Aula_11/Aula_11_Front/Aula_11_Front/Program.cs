using Aula_11_Front.Components;
using Aula_11_Front.Services;

var builder = WebApplication.CreateBuilder(args);

// Componentes Razor / Blazor
builder.Services.AddRazorComponents()
    .AddInteractiveServerComponents();

// HttpClient apontando para a API
builder.Services.AddScoped(sp => new HttpClient
{
    BaseAddress = new Uri("http://localhost:5076/")
});

// Services da aplicação
builder.Services.AddScoped<ProdutoService>();

var app = builder.Build();

// Pipeline HTTP
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Error");
    app.UseHsts();
}

// Se estiver usando HTTP na API, pode deixar comentado durante os testes
// app.UseHttpsRedirection();

app.UseStaticFiles();

app.UseAntiforgery();

app.MapRazorComponents<App>()
    .AddInteractiveServerRenderMode();

app.Run();
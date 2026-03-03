var builder = WebApplication.CreateBuilder(args);

// Adiciona serviços ao container de injeção de dependência
builder.Services.AddControllersWithViews();

var app = builder.Build();

// Configuração do pipeline HTTP
if (!app.Environment.IsDevelopment())
{
    // Página de erro padrão em produção
    app.UseExceptionHandler("/Home/Error");
}

// Serve arquivos estáticos (CSS, JS, imagens)
app.UseStaticFiles();

app.UseRouting();

// Autorização (usado futuramente)
app.UseAuthorization();

// Configuração de rotas MVC
app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();

_

using Microsoft.AspNetCore.Mvc;

namespace Aula01.Web.Controllers
{
    public class HomeController : Controller
    {
        // Action padrão
        public IActionResult Index()
        {
            // Envia dados para a View
            ViewBag.Mensagem = "Primeira aplicação ASP.NET Core";

            return View();
        }
    }
}

_

@{
    ViewData["Title"] = "Home";
}

<h1>@ViewBag.Mensagem</h1>

<p>
    Aplicação ASP.NET Core rodando com sucesso!
</p>


_

namespace Aula01.Web.Services
{
    public class MensagemService
    {
        public string ObterMensagem()
        {
            return "Mensagem vinda da camada de serviço";
        }
    }
}

_

builder.Services.AddScoped<MensagemService>();



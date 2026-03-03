using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using Aula_02.Models;
using Aula_02.Interface;

namespace Aula_02.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;
    private readonly IUsuarioService _usuarioService;

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

    public IActionResult Privacy()
    {
        return View();
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }

   
}

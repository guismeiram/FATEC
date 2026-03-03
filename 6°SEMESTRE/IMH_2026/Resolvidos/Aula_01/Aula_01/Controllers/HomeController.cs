using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using Aula_01.Models;
using Aula_01.Service;

namespace Aula_01.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;

    private readonly MensagemService _msaService;
    private readonly SobreService _obreService;

    public HomeController(ILogger<HomeController> logger, MensagemService msaService, SobreService obreService)
    {
        _logger = logger;
        _msaService = msaService;
        _obreService = obreService;
    }

    public IActionResult Index()
    {
        return View();
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

    /*public String Mensagem()
    {
        return _msaService.ObterMensagem();
    }*/

    

    public IActionResult Mensagem()
    {
        ViewBag.Mensagem = _msaService.ObterMensagem();
        return View();
    }

    public IActionResult Sobre()
    {
        ViewBag.LinhasSobre = _obreService.ObterLinhasSobre();
        return View();
    }
}

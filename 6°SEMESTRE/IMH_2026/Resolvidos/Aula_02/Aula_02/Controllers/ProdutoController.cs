using Aula_02.Interface;
using Aula_02.Services;
using Microsoft.AspNetCore.Mvc;

namespace Aula_02.Controllers
{
    public class ProdutoController : Controller
    {
        private readonly ILogger<ProdutoController> _logger;
        private readonly IProdutoService _produtoService;

        public ProdutoController(
           IProdutoService produtoService,
           ILogger<ProdutoController> logger)
        {
            _produtoService = produtoService;
            _logger = logger;
        }
        public async Task<IActionResult> GetProdutos()
        {
            _logger.LogInformation("Carregando produtos ativos");

            var produto = await _produtoService.ObterProdutoAtivosAsync();

            return View(produto);
        }
    }
}

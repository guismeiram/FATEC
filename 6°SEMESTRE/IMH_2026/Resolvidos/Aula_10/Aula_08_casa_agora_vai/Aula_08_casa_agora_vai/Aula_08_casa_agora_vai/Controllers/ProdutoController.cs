using Aula_08_casa_agora_vai.Models;
using Aula_08_casa_agora_vai.Services;
using Microsoft.AspNetCore.Mvc;

namespace Aula_08_casa_agora_vai.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ProdutoController : ControllerBase
    {
        private readonly IProdutoService _productService;

        public ProdutoController(IProdutoService productService)
        {
            _productService = productService;
        }

        [HttpGet]
        public async Task<List<Produto>> GetProduto()
        {
            return await _productService.GetProduto();
        }

        [HttpGet("{id}")]
        public async Task<Produto?> GetProdutoById(int id)
        {
            return await _productService.GetProdutoById(id);
        }

        [HttpPost]
        public async Task<Produto?> CreateProduto(Produto produto)
        {
            return await _productService.CreateProduto(produto);
        }

        [HttpPut("{id}")]
        public async Task<Produto?> UpdateProduto(int id, Produto produto)
        {
            return await _productService.UpdateProduto(id, produto);
        }

        [HttpDelete("{id}")]
        public async Task<bool> DeleteProduto(int id)
        {
            return await _productService.DeleteProduto(id);
        }
    }
}
    

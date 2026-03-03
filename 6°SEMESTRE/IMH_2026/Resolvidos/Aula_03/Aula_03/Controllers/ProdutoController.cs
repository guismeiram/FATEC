using Aula_03.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Aula_03.Controllers
{
    public class ProdutoController : Controller
    {
        private static List<Produto> _produtos = new();
        private static int _id = 1;

        // LISTAR
        public IActionResult Index()
        {
            return View(_produtos);
        }

        // FORMULÁRIO CRIAÇÃO
        public IActionResult Create()
        {
            return View();
        }

        // SALVAR
        [HttpPost]
        public IActionResult Create(Produto produto)
        {
            if (!ModelState.IsValid)
                return View(produto);

            produto.Id = _id++;
            _produtos.Add(produto);

            return RedirectToAction(nameof(Index));
        }

        // FORMULÁRIO EDIÇÃO
        public IActionResult Edit(int id)
        {
            var produto = _produtos.FirstOrDefault(p => p.Id == id);
            if (produto == null) return NotFound();

            return View(produto);
        }

        // ATUALIZAR
        [HttpPost]
        public IActionResult Edit(Produto produto)
        {
            if (!ModelState.IsValid)
                return View(produto);

            var existente = _produtos.First(p => p.Id == produto.Id);
            existente.Nome = produto.Nome;
            existente.Preco = produto.Preco;
            existente.Ativo = produto.Ativo;
            existente.Categoria = produto.Categoria;

            return RedirectToAction(nameof(Index));
        }

        // EXCLUIR
        public IActionResult Delete(int id)
        {
            var produto = _produtos.FirstOrDefault(p => p.Id == id);
            if (produto != null)
                _produtos.Remove(produto);

            return RedirectToAction(nameof(Index));
        }
    }
}

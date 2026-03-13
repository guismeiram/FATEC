using Aula_03.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;
using System.Diagnostics;

namespace Aula_03.Controllers
{
    public class ProdutoController : Controller, IActionFilter
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
            Startwatch();
            if (!ModelState.IsValid)
                return View(produto);

            produto.Id = _id++;
            _produtos.Add(produto);
            Stopwatch();
            return RedirectToAction(nameof(Index));
        }

        // FORMULÁRIO EDIÇÃO
        public IActionResult Edit(int id)
        {
            Startwatch();

            var produto = _produtos.FirstOrDefault(p => p.Id == id);
            if (produto == null) return NotFound();
            Stopwatch();

            return View(produto);
        }

        // ATUALIZAR
        [HttpPost]
        public IActionResult Edit(Produto produto)
        {   
            Startwatch();
            if (!ModelState.IsValid)
                return View(produto);

            var existente = _produtos.First(p => p.Id == produto.Id);
            existente.Nome = produto.Nome;
            existente.Preco = produto.Preco;
            existente.Ativo = produto.Ativo;
            existente.Categoria = produto.Categoria;
            Stopwatch();
            return RedirectToAction(nameof(Index));
        }

        // EXCLUIR
        public IActionResult Delete(int id)
        {
            Startwatch();

            var produto = _produtos.FirstOrDefault(p => p.Id == id);
            if (produto != null)
                _produtos.Remove(produto);
            Stopwatch();

            return RedirectToAction(nameof(Index));
        }

        public static void Startwatch()
        {
            var stopwatch = new Stopwatch();
            stopwatch.Start();
        }

        public static void Stopwatch()
        {
            var stopwatch = new Stopwatch();
            stopwatch.Stop();
            Console.WriteLine($"Tempo de execução: {stopwatch.ElapsedMilliseconds} ms");
        }
    }
}

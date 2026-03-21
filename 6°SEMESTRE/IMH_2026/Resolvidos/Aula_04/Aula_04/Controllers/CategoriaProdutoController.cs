using Aula_04.Data;
using Aula_04.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;

namespace Aula_04.Controllers
{
    public class CategoriaProdutoController : Controller
    {
        private readonly AppDbContext _context;

        public CategoriaProdutoController(AppDbContext context)
        {
            _context = context;
        }

        public async Task<IActionResult> Index()
        {
            var lista = await _context.CategoriaProdutos
                .Include(x => x.Categorias)
                .Include(x => x.Produtos)
                .ToListAsync();

            return View(lista);
        }

        public IActionResult Create()
        {
            ViewBag.Categoria_Id = new SelectList(_context.Categorias, "Id", "NomeCategoria");
            ViewBag.Produto_Id = new SelectList(_context.Produtos, "Id", "NomeProduto");
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Create(CategoriaProduto categoriaProduto)
        {
            if (!ModelState.IsValid)
            {
                return View(categoriaProduto);
            }

            _context.CategoriaProdutos.Add(categoriaProduto);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }
    }
}

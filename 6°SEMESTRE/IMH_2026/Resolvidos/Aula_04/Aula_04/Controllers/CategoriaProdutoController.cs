using Aula_04.Data;
using Aula_04.Models;
using Microsoft.AspNetCore.Mvc;
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
            List<Categoria> categorias = await _context.Categorias
                .Include(c => c.CategoriaProdutos)   
                .AsNoTracking()
                .ToListAsync();

            return View(categorias);
        }

        public IActionResult Create()
        {
            ViewBag.CategoriaProduto = _context.CategoriaProdutos.ToList();
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Create(CategoriaProduto categoriaProduto)
        {
            if (!ModelState.IsValid)
                return View(categoriaProduto);

            _context.CategoriaProdutos.Add(categoriaProduto);
            await _context.SaveChangesAsync();

            return RedirectToAction(nameof(Index));
        }
    }
}

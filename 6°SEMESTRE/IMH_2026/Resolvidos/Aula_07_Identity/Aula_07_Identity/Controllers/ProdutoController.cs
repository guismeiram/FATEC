using Aula_07_Identity.Data;
using Aula_07_Identity.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace Aula_07_Identity.Controllers
{
    [Authorize]
    public class ProdutoController : Controller
    {
        private readonly ApplicationDbContext _context;

        public ProdutoController(ApplicationDbContext context)
        {
            _context = context;
        }

        public async Task<IActionResult> Index()
        {
            var produtos = await _context.Produtos
                .AsNoTracking()
                .ToListAsync();

            return View(produtos);
        }

        public IActionResult Create()
        {
            var produto = new Produto();
            return View(produto);
        }

        [HttpPost]
        public async Task<IActionResult> Create(Produto produto)
        {
            

            _context.Produtos.Add(produto);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }


    }
}

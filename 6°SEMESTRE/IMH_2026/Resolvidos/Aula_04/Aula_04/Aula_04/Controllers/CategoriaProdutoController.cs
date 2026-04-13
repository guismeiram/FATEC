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
            var lista = await _context.PedidoProdutos
                .Include(x => x.Pedido)
                .Include(x => x.Produtos)
                .ToListAsync();

            return View(lista);
        }

        public IActionResult Create()
        {
            ViewBag.Pedido_Id = new SelectList(_context.Pedidos, "Id", "NomePedido");
            ViewBag.Produto_Id = new SelectList(_context.Produtos, "Id", "NomeProduto");
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Create(PedidoProduto pedidoProduto)
        {
            if (!ModelState.IsValid)
            {
                return View(pedidoProduto);
            }

            _context.PedidoProdutos.Add(pedidoProduto);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }
    }
}

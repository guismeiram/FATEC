using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using treino_arthur.Data;
using treino_arthur.Models;

namespace treino_arthur.Controllers
{
    public class CategoriaController : Controller
    {
        private readonly AppDbContext _context;

        public CategoriaController(AppDbContext context)
        {
            _context = context;
        }

        public async Task<IActionResult> Index()
        {
            var categoria = await _context.Categorias
                .Include(p => p.Produtos)
                .AsNoTracking()
                .ToListAsync();

            return View(categoria);
        }

       public IActionResult Create()
        {
            var categoria = new Categoria();
            categoria.Produtos.Add(new Produto()); // Adiciona um produto vazio
            return View(categoria);
        }

        [HttpPost]
        public async Task<IActionResult> Create(Categoria categoria)
        {
            

            _context.Categorias.Add(categoria);
            await _context.SaveChangesAsync();

            // Os produtos já foram adicionados via relacionamento, se o EF Core estiver configurado para cascata
            // O código abaixo é redundante se a configuração estiver correta, mas mantê-lo não causa problemas
            //if (categoria.Produtos != null && categoria.Produtos.Any())
            //{
                foreach (var item in categoria.Produtos)
                {
                    item.CategoriaId = categoria.Id; // Garante a FK
                                                     // _context.Produtos.Add(item); // Não necessário se o EF já rastreia
                }
                await _context.SaveChangesAsync();
            //}

            return RedirectToAction(nameof(Index));
        }
    }
}

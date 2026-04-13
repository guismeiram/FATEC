using Aula_05.Data;
using Aula_05.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
#nullable enable

namespace Aula_05.Controllers
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



            // Os produtos já foram adicionados via relacionamento, se o EF Core estiver configurado para cascata
            // O código abaixo é redundante se a configuração estiver correta, mas mantê-lo não causa problemas
            //if (categoria.Produtos != null && categoria.Produtos.Any())
            //{
            foreach (var item in categoria.Produtos)
            {
                item.CategoriaId = categoria.Id; // Garante a FK
                                                 // _context.Produtos.Add(item); // Não necessário se o EF já rastreia
            }
            _context.Categorias.Add(categoria);

            await _context.SaveChangesAsync();
            //}

            return RedirectToAction(nameof(Index));
        }

        public IActionResult Edit(Guid id)
        {
            

            var categoria = _context.Categorias
                .Include(c => c.Produtos)
                .FirstOrDefault(c => c.Id == id);

            if (categoria == null)
            {
                return NotFound();
            }

            if (categoria.Produtos == null)
            {
                categoria.Produtos = new List<Produto>();
            }

            return View(categoria);
        }



        [HttpPost]
        public IActionResult Edit(Guid id, Categoria categoria)
        {
            if (id != categoria.Id)
                return BadRequest();

            if (!ModelState.IsValid)
                return View(categoria);

            // 1. Buscamos a categoria incluindo os produtos
            var categoriaExistente = _context.Categorias
                .Include(c => c.Produtos)
                .FirstOrDefault(c => c.Id == id);

            if (categoriaExistente == null)
                return NotFound();

            // 2. Atualiza dados básicos da categoria
            categoriaExistente.Nome = categoria.Nome;
            // Adicione outros campos de Categoria aqui, se houver

            var produtoExistente = _context.Produtos.FirstOrDefault(c => c.Id == id);
            Produto produto = new Produto();
            
            if(produtoExistente != null)
            {

                produtoExistente.Nome = produto.Nome;
                produtoExistente.Preco = produto.Preco;
                produtoExistente.Ativo = produto.Ativo;
            }

            _context.SaveChanges();

            return RedirectToAction(nameof(Index));
        }


        public IActionResult Delete(Guid id)
        {
            var categoria = _context.Categorias
              .Include(p => p.Produtos)
              .FirstOrDefault(c => c.Id == id);
            if (categoria == null)
            {
                return NotFound();
            }
            return View(categoria);
        }

        [HttpPost]
        public IActionResult DeleteConfirmed(Guid id)
        {
            var categoria = _context.Categorias
              .Include(p => p.Produtos)
              .FirstOrDefault(c => c.Id == id);

            if (categoria == null)
            {
                return NotFound();
            }

            _context.Categorias.Remove(categoria);
            _context.SaveChanges();
            return RedirectToAction(nameof(Index));
        }
    }
}

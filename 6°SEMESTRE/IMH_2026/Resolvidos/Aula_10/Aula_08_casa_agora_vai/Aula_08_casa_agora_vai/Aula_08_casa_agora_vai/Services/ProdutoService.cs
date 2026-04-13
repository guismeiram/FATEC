using Aula_08_casa_agora_vai.Data;
using Aula_08_casa_agora_vai.Models;
using Microsoft.EntityFrameworkCore;

namespace Aula_08_casa_agora_vai.Services
{
    public class ProductService : IProdutoService
    {
        private readonly ApplicationDbContext _context;

        public ProductService(ApplicationDbContext context)
        {
            _context = context;
        }

        public async Task<Produto> CreateProduto(Produto produto)
        {
            _context.Add(produto);
            await _context.SaveChangesAsync();
            return produto;
        }

        public async Task<bool> DeleteProduto(int Id)
        {
            var dbProduto = await _context.Produtos.FindAsync(Id);
            if (dbProduto == null)
            {
                return false;
            }

            _context.Remove(dbProduto);
            await _context.SaveChangesAsync();

            return true;
        }

        public async Task<Produto?> GetProdutoById(int Id)
        {
            var dbProduto = await _context.Produtos.FindAsync(Id);
            return dbProduto;
        }

        public async Task<List<Produto>> GetProduto()
        {
            return await _context.Produtos.ToListAsync();
        }

        public async Task<Produto?> UpdateProduto(int Id, Produto produto)
        {
            var dbProduto = await _context.Produtos.FindAsync(Id);
            if (dbProduto != null)
            {
                dbProduto.Nome = produto.Nome;
                dbProduto.Preco = produto.Preco;
               

                await _context.SaveChangesAsync();
            }

            return dbProduto;
        }

      
    }
}

using Aula_02.DTOs;
using Aula_02.Interface;
using Aula_02.Models;

namespace Aula_02.Services
{
    public class ProdutoService : IProdutoService
    {
        // Simulando base de dados em memória
        private readonly List<Produto> _produtos = new()
        {
            new Produto { Id = 1, Nome = "Maça", Ativo = true },
            new Produto { Id = 2, Nome = "Feijão", Ativo = false },
            new Produto { Id = 3, Nome = "Abobora", Ativo = true }
        };

        public async Task<List<ProdutoDto>> ObterProdutoAtivosAsync()
        {
            // Simula operação I/O
            await Task.Delay(300);

            // LINQ avançado + projeção para DTO
            return _produtos
                .Where(u => u.Ativo)
                .OrderBy(u => u.Nome)
                .Select(u => new ProdutoDto(u.Id, u.Nome))
                .ToList();
        }

        
    }
}


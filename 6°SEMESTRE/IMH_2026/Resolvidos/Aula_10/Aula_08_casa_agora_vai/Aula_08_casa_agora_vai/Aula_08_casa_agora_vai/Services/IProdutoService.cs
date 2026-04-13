using Aula_08_casa_agora_vai.Models;

namespace Aula_08_casa_agora_vai.Services
{
    public interface IProdutoService
    {
        Task<List<Produto>> GetProduto();
        Task<Produto?> GetProdutoById(int Id);
        Task<Produto> CreateProduto(Produto produto);
        Task<Produto?> UpdateProduto(int Id, Produto produto);
        Task<bool> DeleteProduto(int produto);
    }
}

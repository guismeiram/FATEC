using Shared;

namespace Aula_08_casa_agora_vai.Client.Services
{
    public interface IProdutoService
    {
        List<Produto> Produtos { get; set; }
        Task GetProdutos();
        Task<Produto?> GetProdutoById(int id);
        Task CreateProduto(Produto produto);
        Task UpdateProduto(int id, Produto produto);
        Task DeleteProduto(int id);
    }
}

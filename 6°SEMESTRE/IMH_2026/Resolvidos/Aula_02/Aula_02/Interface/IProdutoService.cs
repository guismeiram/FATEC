using Aula_02.DTOs;

namespace Aula_02.Interface
{
    public interface IProdutoService
    {
        Task<List<ProdutoDto>> ObterProdutoAtivosAsync();

    }
}

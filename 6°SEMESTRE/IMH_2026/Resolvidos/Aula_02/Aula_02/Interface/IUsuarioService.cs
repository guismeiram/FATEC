using Aula_02.DTOs;

namespace Aula_02.Interface
{
    public interface IUsuarioService
    {
        Task<List<UsuarioDto>> ObterUsuariosAtivosAsync();
    }
}

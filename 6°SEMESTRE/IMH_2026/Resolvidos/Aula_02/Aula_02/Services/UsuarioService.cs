using Aula_02.DTOs;
using Aula_02.Interface;
using Aula_02.Models;

namespace Aula_02.Services
{
    public class UsuarioService : IUsuarioService
    {
        // Simulando base de dados em memória
        private readonly List<Usuario> _usuarios = new()
        {
            new Usuario { Id = 1, Nome = "Ana", Ativo = true },
            new Usuario { Id = 2, Nome = "Bruno", Ativo = false },
            new Usuario { Id = 3, Nome = "Carlos", Ativo = true }
        };

        public async Task<List<UsuarioDto>> ObterUsuariosAtivosAsync()
        {
            // Simula operação I/O
            await Task.Delay(300);

            // LINQ avançado + projeção para DTO
            return _usuarios
                .Where(u => u.Ativo)
                .OrderBy(u => u.Nome)
                .Select(u => new UsuarioDto(u.Id, u.Nome))
                .ToList();
        }
    }
}

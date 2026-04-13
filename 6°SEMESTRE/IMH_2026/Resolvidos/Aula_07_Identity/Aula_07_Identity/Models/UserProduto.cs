using Aula_07_Identity.Entitys;

namespace Aula_07_Identity.Models
{
    public class UserProduto : Entity
    {
        public Guid UsuarioId { get; set; }
        public Guid ProdutoId { get; set; }

        public AppUser User { get; set; }
        public Produto Produto { get; set; }
    }
}

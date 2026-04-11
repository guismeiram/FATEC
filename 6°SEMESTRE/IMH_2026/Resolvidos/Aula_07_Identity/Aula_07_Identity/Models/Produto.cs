using Aula_07_Identity.Entitys;

namespace Aula_07_Identity.Models
{
    public class Produto : Entity
    {
        public string? Nome { get; set; }

        public double Preco { get; set; }
        public bool Ativo { get; set; }

        public IEnumerable<UserProduto> UserProdutos { get; set; }

    }
}

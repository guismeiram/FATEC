using Aula_04.Entitys;
using System.ComponentModel.DataAnnotations;

namespace Aula_04.Models
{
    public class Produto : Entity
    {
        [Required]
        public string NomeProduto { get; set; }

        public decimal Preco { get; set; }
        public bool Ativo { get; set; }

        public IEnumerable<PedidoProduto> PedidoProdutos { get; set; }

        public string Categoria_Id { get; set; }
        public Categoria Categoria { get; set; }

    }
}

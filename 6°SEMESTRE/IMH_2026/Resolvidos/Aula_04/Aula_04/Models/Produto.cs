using Aula_04.Entitys;
using System.ComponentModel.DataAnnotations;

namespace Aula_04.Models
{
    public class Produto : Entity
    {
        [Required]
        public string Nome { get; set; }

        public decimal Preco { get; set; }
        public bool Ativo { get; set; }

        public IEnumerable<CategoriaProduto> CategoriaProdutos { get; set; }

        public string Fornecedor_Id { get; set; }
        public Fornecedor Fornecedores { get; set; }

    }
}

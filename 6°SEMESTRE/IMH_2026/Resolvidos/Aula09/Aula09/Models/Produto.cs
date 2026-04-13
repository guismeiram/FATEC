using System.ComponentModel.DataAnnotations;

namespace Aula09.Models
{
    public class Produto
    {
        public int Id { get; set; }

        [Required]
        [MinLength(3)]
        public string Nome { get; set; }

        [Range(0.01, 99999)]
        public decimal Preco { get; set; }

        public int Estoque { get; set; }
    }
}

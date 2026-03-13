using System.ComponentModel.DataAnnotations;

namespace Aula_03.Models
{
    public class Produto
    {
        public int Id { get; set; }

        [Required(ErrorMessage = "O nome é obrigatório")]
        [StringLength(100, MinimumLength = 3)]
        public string Nome { get; set; }

        [Required]
        [Range(0.01, 99999)]
        public decimal Preco { get; set; }
        public bool Ativo { get; set; }

        [Required(ErrorMessage = "O nome é obrigatório")]
        [StringLength(100, MinimumLength = 3)]
        public string Categoria { get; set; }
    }
}

using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace Aula_06.ViewModels
{
    public class ProdutoViewModel
    {
        [Key]
        public Guid Id { get; set; }

        [Required(ErrorMessage = "O campo {0} é obrigatório")]
        [StringLength(200, ErrorMessage = "O campo {0} precisa ter entre {2} e {1} caracteres", MinimumLength = 2)]
        public string Nome { get; set; }

        [Required]
        public IFormFile ImagemUpload { get; set; }

        public double Preco { get; set; }

        public string Imagem { get; set; }

        [DisplayName("Ativo?")]
        public bool Ativo { get; set; }
    }
}

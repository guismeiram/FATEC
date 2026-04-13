using Aula_06.Entitys;
using System.ComponentModel.DataAnnotations;

namespace Aula_06.Models
{
    public class Produto : Entity
    {
        public string? Imagem { get; set; }
        [Required]
        public string ?Nome { get; set; }

        public double Preco { get; set; }
        public bool Ativo { get; set; }

    }
}

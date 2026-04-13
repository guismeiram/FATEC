using Aula_05.Entitys;
using System.ComponentModel.DataAnnotations;

namespace Aula_05.Models
{
    public class Produto : Entity
    {


        [Required]
        public string ?Nome { get; set; }

        public double ?Preco { get; set; }
        public bool Ativo { get; set; }

        // FK
        public Guid CategoriaId { get; set; }
        public Categoria ?Categoria { get; set; }
    }
}

using System.ComponentModel.DataAnnotations;

namespace treino_arthur.Models
{
    public class Produto
    {
        public int Id { get; set; }

        [Required]
        public string Nome { get; set; }

        public decimal Preco { get; set; }
        public bool Ativo { get; set; }

        // FK
        public int CategoriaId { get; set; }
        public Categoria Categoria { get; set; }
    }
}

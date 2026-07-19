namespace Aula_11_Front.Models
{
    public class Produto
    {
        public Guid Id { get; set; }
        public string Nome { get; set; } = string.Empty;

        public decimal Preco { get; set; }
    }
}

namespace treino_arthur.Models
{
    public class Categoria
    {
        public int Id { get; set; }
        public string Nome { get; set; }

        // Navegação
        public List<Produto> Produtos { get; set; } = new List<Produto>();
    }
}

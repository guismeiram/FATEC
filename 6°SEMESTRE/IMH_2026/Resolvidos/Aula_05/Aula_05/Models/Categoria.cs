using Aula_05.Entitys;

namespace Aula_05.Models
{
    public class Categoria : Entity
    {
        public Categoria()
        {
            Produtos = new List<Produto>();
        }
        public List<Produto> Produtos { get; set; } = new List<Produto>();

        public string ?Nome { get; set; }

       


    }
}

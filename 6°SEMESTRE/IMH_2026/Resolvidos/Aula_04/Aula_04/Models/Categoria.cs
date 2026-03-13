using Aula_04.Entitys;

namespace Aula_04.Models
{
    public class Categoria : Entity
    {
        public string Nome { get; set; }

        public IEnumerable<CategoriaProduto> CategoriaProdutos { get; set; }
    }
}

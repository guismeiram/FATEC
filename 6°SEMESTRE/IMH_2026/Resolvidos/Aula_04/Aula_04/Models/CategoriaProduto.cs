using Aula_04.Entitys;

namespace Aula_04.Models
{
    public class CategoriaProduto : Entity
    {
        public string Categoria_Id {  get; set; }
        public Categoria Categorias { get; set; }
        public string Produto_Id {  get; set; }
        public Produto Produtos { get; set; }
    }
}

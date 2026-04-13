using Aula_04.Entitys;

namespace Aula_04.Models
{
    public class PedidoProduto : Entity
    {
        public string Pedido_Id {  get; set; }
        public Pedido Pedido { get; set; }
        public string Produto_Id {  get; set; }
        public Produto Produtos { get; set; }
        
    }
}

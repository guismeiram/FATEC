using Aula_04.Entitys;

namespace Aula_04.Models
{
    public class Pedido : Entity
    {
        public string NomeCategoria { get; set; }

        public IEnumerable<PedidoProduto> PedidoProdutos { get; set; }
    }
}

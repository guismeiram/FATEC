using Aula_04.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Aula_04.Mapping
{
    public class PedidoProdutoConfig : IEntityTypeConfiguration<PedidoProduto>
    {
        public void Configure(EntityTypeBuilder<PedidoProduto> builder)
        {
            builder.HasOne(x => x.Produtos)
                .WithMany(x => x.PedidoProdutos)
                .HasForeignKey(x =>x.Produto_Id);

            builder.HasOne(x => x.Pedido)
                    .WithMany(x => x.PedidoProdutos)
                    .HasForeignKey(x => x.Pedido_Id);

        }
    }
}

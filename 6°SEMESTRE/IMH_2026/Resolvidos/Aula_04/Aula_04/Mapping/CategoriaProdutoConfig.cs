using Aula_04.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Aula_04.Mapping
{
    public class CategoriaProdutoConfig : IEntityTypeConfiguration<CategoriaProduto>
    {
        public void Configure(EntityTypeBuilder<CategoriaProduto> builder)
        {
            builder.HasOne(x => x.Produtos)
                .WithMany(x => x.CategoriaProdutos)
                .HasForeignKey(x =>x.Produto_Id);

            builder.HasOne(x => x.Categorias)
                    .WithMany(x => x.CategoriaProdutos)
                    .HasForeignKey(x => x.Categoria_Id);

           


        }
    }
}

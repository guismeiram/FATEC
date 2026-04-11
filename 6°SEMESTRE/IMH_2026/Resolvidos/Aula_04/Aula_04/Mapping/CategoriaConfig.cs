using Aula_04.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Aula_04.Mapping
{
    public class CategoriaConfig : IEntityTypeConfiguration<Categoria>
    {
        public void Configure(EntityTypeBuilder<Categoria> builder)
        {
            // 1 : N => Fornecedor : Produtos
            builder.HasMany(x => x.Produtos)
                .WithOne(p => p.Categoria)
                .HasForeignKey(p => p.Categoria_Id);
        }
    }
}

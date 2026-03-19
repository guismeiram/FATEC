using Aula_04.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Aula_04.Mapping
{
    public class FornecedorConfig : IEntityTypeConfiguration<Fornecedor>
    {
        public void Configure(EntityTypeBuilder<Fornecedor> builder)
        {
            // 1 : N => Fornecedor : Produtos
            builder.HasMany(x => x.Produtos)
                .WithOne(p => p.Fornecedores)
                .HasForeignKey(p => p.Fornecedor_Id);
        }
    }
}

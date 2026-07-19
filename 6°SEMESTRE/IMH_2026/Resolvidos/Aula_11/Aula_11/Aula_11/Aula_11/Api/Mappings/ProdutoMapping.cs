using Api.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Api.Mappings
{
    public class ProdutoMapping : IEntityTypeConfiguration<Produto>
    {
        public void Configure(EntityTypeBuilder<Produto> builder)
        {
            builder.HasKey(p => p.Id);
            builder.Property(p => p.Nome)
                .IsRequired()
                .HasMaxLength(100);
            builder.Property(p => p.Preco)
                .IsRequired()
                .HasColumnType("decimal(18,2)");
            builder.Property(p => p.Ativo)
                .IsRequired();

        }
    }
}

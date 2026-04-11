using Aula_05.Models;
using Microsoft.EntityFrameworkCore;

namespace Aula_05.Data
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options)
             : base(options)
        {
        }

        public DbSet<Produto> Produtos { get; set; }
        public DbSet<Categoria> Categorias { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // Configuração de relacionamento 1:N
            modelBuilder.Entity<Categoria>()
                .HasMany(c => c.Produtos)
                .WithOne(p => p.Categoria)
                .HasForeignKey(p => p.CategoriaId);

            base.OnModelCreating(modelBuilder);
        }
    }
}

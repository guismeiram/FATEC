using Microsoft.EntityFrameworkCore;

namespace Aula_08_Dia_10.Data
{
    public class AppDbContext: DbContext
    {
        public AppDbContext(DbContextOptions options) : base(options)
        {
            
        }

        public DbSet<Models.Produto> Produtos { get; set; }
    }
}

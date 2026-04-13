using Aula_06.Models;
using Microsoft.EntityFrameworkCore;

namespace Aula_06.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
           : base(options)
        {
        }

        public DbSet<Produto> Produtos { get; set; }
    }
}

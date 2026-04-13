using Aula_08_casa_agora_vai.Models;
using Microsoft.EntityFrameworkCore;

namespace Aula_08_casa_agora_vai.Data
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

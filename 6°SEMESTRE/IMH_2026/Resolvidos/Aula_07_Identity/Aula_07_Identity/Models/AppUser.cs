using Microsoft.AspNetCore.Identity;

namespace Aula_07_Identity.Models
{
    public class AppUser : IdentityUser
    {

        public IEnumerable<UserProduto> UserProdutos { get; set; }

    }
}

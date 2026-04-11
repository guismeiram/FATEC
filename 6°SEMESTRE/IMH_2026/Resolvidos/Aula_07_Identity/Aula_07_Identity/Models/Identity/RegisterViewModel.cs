using System.ComponentModel.DataAnnotations;

namespace Aula_07_Identity.Models.Identity
{
    public class RegisterViewModel
    {
        [EmailAddress]
        public string Email { get; set; }

        public string Password { get; set; }
    }
}

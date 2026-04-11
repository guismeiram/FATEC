using System.ComponentModel.DataAnnotations;

namespace Aula_07_Identity.Models.Identity
{
    public class LoginViewModel
    {
        [EmailAddress]
        public string Email { get; set; }

        public string Password { get; set; }
        public bool Remember { get; set; }

    }
}

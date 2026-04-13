using System.ComponentModel.DataAnnotations;

namespace Aula_07_Identity.Models.Identity
{
    public class AuthUserViewModel
    {
        [Required]
        public string UserName { get; set; }

        [Required]
        [DataType(DataType.Password)]
        public string Password { get; set; }
    }
}

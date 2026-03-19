using Aula_04.Data;
using Microsoft.AspNetCore.Mvc;

namespace Aula_04.Controllers
{
    public class FornecedorController : Controller
    {
        private readonly AppDbContext _context;


        public FornecedorController(AppDbContext context)
        {
            _context = context;
        }

        public IActionResult Index()
        {
            return View();
        }

        


    }
}

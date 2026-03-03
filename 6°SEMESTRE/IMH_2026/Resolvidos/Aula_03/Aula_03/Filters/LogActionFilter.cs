using Microsoft.AspNetCore.Mvc.Filters;

namespace Aula_03.Filters
{
    public class LogActionFilter : IActionFilter
    {
        public void OnActionExecuting(ActionExecutingContext context)
        {
            Console.WriteLine("Executando Action...");
        }

        public void OnActionExecuted(ActionExecutedContext context)
        {
            Console.WriteLine("Action finalizada.");
        }
    }
}

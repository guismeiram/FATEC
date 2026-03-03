using Microsoft.AspNetCore.Mvc.Formatters;

namespace Aula_01.Service
{
    public class SobreService
    {
        public List<string> ObterLinhasSobre()
        {
            return new List<string>
            {
                "Fatec Adib Moises",
                "Curso: Informatica para negocios.",
                "Disciplina: Markenting e Multimidia.",
                "Prof° Douglas",
                "Aluno responsavel: Guilherme Mendes"
            };
        }
    }
}

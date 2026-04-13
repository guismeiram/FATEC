using Aula_04.Entitys;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace Aula_04.Models
{
    public class Categoria: Entity
    {

        public string Nome { get; set; }

        public string Documento { get; set; }

        public bool Ativo { get; set; }

        public IEnumerable<Produto> Produtos { get; set; }
    }
}

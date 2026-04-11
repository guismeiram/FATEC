using Aula_06.Models;
using Aula_06.ViewModels;
using AutoMapper;

namespace Aula_06.AutoMapper
{
    public class AutoMapperConfig : Profile
    {
        
        public AutoMapperConfig()
        {
            CreateMap<Produto, ProdutoViewModel>();
            CreateMap<ProdutoViewModel, Produto>();
        }

    }
}

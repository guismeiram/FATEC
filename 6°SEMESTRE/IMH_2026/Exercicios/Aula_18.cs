namespace Domain.Entities
{
    public class Produto
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public bool Ativo { get; set; }
    }
}

_

namespace Application.DTOs
{
    public record ProdutoDto(int Id, string Nome, decimal Preco);
}

_

using Domain.Entities;

namespace Application.Interfaces
{
    public interface IProdutoRepository
    {
        Task<List<Produto>> GetAllAsync();
        Task AddAsync(Produto produto);
    }
}

_

using Application.Interfaces;
using Domain.Entities;

namespace Infrastructure.Repositories
{
    public class ProdutoRepository : IProdutoRepository
    {
        private readonly AppDbContext _context;

        public ProdutoRepository(AppDbContext context)
        {
            _context = context;
        }

        public async Task<List<Produto>> GetAllAsync()
        {
            return await _context.Produtos.ToListAsync();
        }

        public async Task AddAsync(Produto produto)
        {
            _context.Produtos.Add(produto);
            await _context.SaveChangesAsync();
        }
    }
}

_

using Application.DTOs;
using Application.Interfaces;
using Domain.Entities;

namespace Application.Services
{
    public class ProdutoService
    {
        private readonly IProdutoRepository _repo;
        private readonly ILogger<ProdutoService> _logger;

        public ProdutoService(
            IProdutoRepository repo,
            ILogger<ProdutoService> logger)
        {
            _repo = repo;
            _logger = logger;
        }

        public async Task<List<ProdutoDto>> ListarAsync()
        {
            _logger.LogInformation("Listando produtos");

            var produtos = await _repo.GetAllAsync();

            return produtos.Select(p =>
                new ProdutoDto(p.Id, p.Nome, p.Preco)).ToList();
        }

        public async Task CriarAsync(ProdutoDto dto)
        {
            _logger.LogInformation("Criando produto {@Produto}", dto);

            var produto = new Produto
            {
                Nome = dto.Nome,
                Preco = dto.Preco,
                Ativo = true
            };

            await _repo.AddAsync(produto);
        }
    }
}

_

using Application.DTOs;
using Application.Services;
using Microsoft.AspNetCore.Mvc;

namespace Api.Controllers
{
    [ApiController]
    [Route("api/produtos")]
    public class ProdutosController : ControllerBase
    {
        private readonly ProdutoService _service;

        public ProdutosController(ProdutoService service)
        {
            _service = service;
        }

        [HttpGet]
        public async Task<IActionResult> Get()
        {
            return Ok(await _service.ListarAsync());
        }

        [HttpPost]
        public async Task<IActionResult> Post(ProdutoDto dto)
        {
            await _service.CriarAsync(dto);
            return Created("", dto);
        }
    }
}

_


dotnet add package Microsoft.Extensions.Diagnostics.HealthChecks

_

builder.Services.AddHealthChecks()
    .AddDbContextCheck<AppDbContext>();

app.MapHealthChecks("/health");

_

/health

_

_logger.LogInformation(
    "Produto criado: {@Produto}",
    produtoDto);

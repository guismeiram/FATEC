using Api.Context;
using Api.Dtos;
using Api.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Linq;

namespace Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ProdutosController : ControllerBase
    {
        private ApplicationDbContext _context;
        public ProdutosController(ApplicationDbContext context) { 
            _context = context;
        }

        [HttpGet]
        public async Task<ActionResult<PagedResult<ProdutoDto>>> GetProdutos(
         int page = 1,
         int pageSize = 10)
        {
            var query = _context.Produtos.AsQueryable();

            var total = await query.CountAsync();

            var items = await query
                .Skip((page - 1) * pageSize)
                .Take(pageSize)
                .Select(p => new ProdutoDto(p.Id, p.Nome, p.Preco, p.Ativo))
                .ToListAsync();

            var result = new PagedResult<ProdutoDto>
            {
                Page = page,
                PageSize = pageSize,
                TotalItems = total,
                Items = items
            };

            return Ok(result);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<ProdutoDto>> GetProdutoPorId(Guid id)
        {
            var produto = await _context.Produtos
                .Where(p => p.Id == id)
                .Select(p => new ProdutoDto(
                    p.Id,
                    p.Nome,
                    p.Preco,
                    p.Ativo
                ))
                .FirstOrDefaultAsync();

            if (produto == null)
            {
                return NotFound("Produto não encontrado.");
            }

            return Ok(produto);
        }

        [HttpPost]
        public async Task<ActionResult<ProdutoDto>> CreateProduto([FromBody] ProdutoDto dto)
        {
            if (dto == null)
            {
                return BadRequest("Dados do produto não informados.");
            }

            if (string.IsNullOrWhiteSpace(dto.Nome))
            {
                return BadRequest("O nome do produto é obrigatório.");
            }

            if (dto.Preco <= 0)
            {
                return BadRequest("O preço deve ser maior que zero.");
            }

            var produto = new Produto
            {
                Nome = dto.Nome,
                Preco = dto.Preco,
                Ativo = dto.Ativo
            };

            _context.Produtos.Add(produto);
            await _context.SaveChangesAsync();

            var produtoDto = new ProdutoDto(
                produto.Id,
                produto.Nome,
                produto.Preco,
                produto.Ativo
            );

            return CreatedAtAction(
                nameof(GetProdutoPorId),
                new { id = produto.Id },
                produtoDto
            );
        }


    }
}

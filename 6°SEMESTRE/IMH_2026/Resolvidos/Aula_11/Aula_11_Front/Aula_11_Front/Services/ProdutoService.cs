namespace Aula_11_Front.Services
{
    using Aula_11_Front.Models;
    using System.Net.Http.Json;

    public class ProdutoService
    {
        private readonly HttpClient _http;
        private readonly ILogger<ProdutoService> _logger;

        // Inject ILogger alongside HttpClient
        public ProdutoService(HttpClient http, ILogger<ProdutoService> logger)
        {
            _http = http;
            _logger = logger;
        }

        public async Task<List<Produto>> ListarProdutos()
        {
            try
            {
                var result = await _http.GetFromJsonAsync<PagedResult<Produto>>("api/produtos");
                return result?.Items ?? new List<Produto>();
            }
            catch (HttpRequestException ex)
            {
                // Catch network errors (API down) and HTTP error codes (500, 404, etc.)
                _logger.LogError(ex, "Erro de rede ou servidor ao buscar produtos.");
                throw new Exception("Não foi possível conectar ao servidor.");
            }
            catch (Exception ex)
            {
                // Catch JSON parsing errors or other unexpected issues
                _logger.LogError(ex, "Erro inesperado ao processar os produtos.");
                throw new Exception("Ocorreu um erro ao processar os dados.");
            }
        }
    

        public async Task<bool> CadastrarProduto(Produto produto)
        {
            var response = await _http.PostAsJsonAsync("api/produtos", produto);
            return response.IsSuccessStatusCode;
        }

        public async Task<Produto?> BuscarPorId(int id)
        {
            return await _http.GetFromJsonAsync<Produto>($"api/produtos/{id}");
        }

       
    }
}

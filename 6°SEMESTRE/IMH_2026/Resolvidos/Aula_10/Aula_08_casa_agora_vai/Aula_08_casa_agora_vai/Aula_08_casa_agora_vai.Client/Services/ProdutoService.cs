using Microsoft.AspNetCore.Components;
using Shared;
using System.Net;
using System.Net.Http.Json;

namespace Aula_08_casa_agora_vai.Client.Services
{
    public class ProdutoService : IProdutoService
    {
        private readonly HttpClient _http;
        private readonly NavigationManager _navigationManger;

        public ProdutoService(HttpClient http, NavigationManager navigationManger)
        {
            _http = http;
            _navigationManger = navigationManger;
        }

        public List<Produto> Produtos { get; set; } = new List<Produto>();

        public async Task CreateProduto(Produto produto)
        {
            await _http.PostAsJsonAsync("api/produto", produto);
            _navigationManger.NavigateTo("produtos");
        }

        public async Task DeleteProduto(int id)
        {
            var result = await _http.DeleteAsync($"api/produto/{id}");
            _navigationManger.NavigateTo("produtos");
        }

        public async Task<Produto?> GetProdutoById(int id)
        {
            var result = await _http.GetAsync($"api/produto/{id}");
            if (result.StatusCode == HttpStatusCode.OK)
            {
                return await result.Content.ReadFromJsonAsync<Produto>();
            }
            return null;
        }

        public async Task GetProdutos()
        {
            var result = await _http.GetFromJsonAsync<List<Produto>>("api/produto");
            if (result is not null)
                Produtos = result;
        }

        public async Task UpdateProduto(int id, Produto produto)
        {
            await _http.PutAsJsonAsync($"api/produto/{id}", produto);
            _navigationManger.NavigateTo("produtos");
        }

     
    }
}

builder.Services.AddCors(options =>
{
    options.AddPolicy("ReactPolicy", policy =>
    {
        policy
            .WithOrigins("http://localhost:5173")
            .AllowAnyHeader()
            .AllowAnyMethod();
    });
});

app.UseCors("ReactPolicy");

_

[HttpPost]
public IActionResult Post(ProdutoDto dto)
{
    var novo = new Produto
    {
        Id = _produtos.Max(p => p.Id) + 1,
        Nome = dto.Nome,
        Preco = dto.Preco,
        Ativo = true
    };

    _produtos.Add(novo);

    return CreatedAtAction(nameof(Get), new { id = novo.Id }, dto);
}

[HttpPut("{id}")]
public IActionResult Put(int id, ProdutoDto dto)
{
    var produto = _produtos.FirstOrDefault(p => p.Id == id);
    if (produto == null) return NotFound();

    produto.Nome = dto.Nome;
    produto.Preco = dto.Preco;

    return NoContent();
}

_

npm install axios

_

import axios from "axios";

const api = axios.create({
  baseURL: "https://localhost:5001/api/v1"
});

export default api;

_

import api from "./api";

export function listarProdutos() {
  return api.get("/produtos");
}

export function criarProduto(produto) {
  return api.post("/produtos", produto);
}

export function atualizarProduto(id, produto) {
  return api.put(`/produtos/${id}`, produto);
}

_

import { useEffect, useState } from "react";
import { listarProdutos } from "../services/produtoService";
import ProdutoForm from "./ProdutoForm";

function Produtos() {
  const [produtos, setProdutos] = useState([]);
  const [editando, setEditando] = useState(null);

  useEffect(() => {
    carregar();
  }, []);

  async function carregar() {
    const response = await listarProdutos();
    setProdutos(response.data.items ?? response.data);
  }

  return (
    <div>
      <ProdutoForm
        produto={editando}
        onSalvo={carregar}
        onCancel={() => setEditando(null)}
      />

      <ul>
        {produtos.map(p => (
          <li key={p.id}>
            {p.nome} - R$ {p.preco}
            <button onClick={() => setEditando(p)}>Editar</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Produtos;

_

import { useEffect, useState } from "react";
import { criarProduto, atualizarProduto } from "../services/produtoService";

function ProdutoForm({ produto, onSalvo, onCancel }) {
  const [form, setForm] = useState({ nome: "", preco: "" });

  useEffect(() => {
    if (produto) setForm(produto);
  }, [produto]);

  function handleChange(e) {
    setForm({ ...form, [e.target.name]: e.target.value });
  }

  async function submit(e) {
    e.preventDefault();

    if (form.id) {
      await atualizarProduto(form.id, form);
    } else {
      await criarProduto(form);
    }

    setForm({ nome: "", preco: "" });
    onSalvo();
  }

  return (
    <form onSubmit={submit}>
      <input
        name="nome"
        placeholder="Nome"
        value={form.nome}
        onChange={handleChange}
      />

      <input
        name="preco"
        placeholder="Preço"
        value={form.preco}
        onChange={handleChange}
      />

      <button type="submit">
        {form.id ? "Atualizar" : "Cadastrar"}
      </button>

      {form.id && <button onClick={onCancel}>Cancelar</button>}
    </form>
  );
}

export default ProdutoForm;

_

try {
  await criarProduto(form);
} catch (error) {
  alert("Erro ao salvar produto");
}

_


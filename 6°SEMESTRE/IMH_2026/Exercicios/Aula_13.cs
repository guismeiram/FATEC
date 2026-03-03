npm create vite@latest aula13-react -- --template react
cd aula13-react
npm install
npm run dev

_

import Produtos from "./components/Produtos";

function App() {
  return (
    <div>
      <h1>React + .NET</h1>
      <Produtos />
    </div>
  );
}

export default App;

_

import { useState } from "react";
import ProdutoForm from "./ProdutoForm";
import ProdutoList from "./ProdutoList";

function Produtos() {
  // Estado principal da aplicação (mockado)
  const [produtos, setProdutos] = useState([
    { id: 1, nome: "Notebook", preco: 4500 },
    { id: 2, nome: "Mouse", preco: 150 }
  ]);

  function adicionarProduto(produto) {
    setProdutos([...produtos, produto]);
  }

  function removerProduto(id) {
    setProdutos(produtos.filter(p => p.id !== id));
  }

  return (
    <div>
      <ProdutoForm onAdicionar={adicionarProduto} />
      <ProdutoList produtos={produtos} onRemover={removerProduto} />
    </div>
  );
}

export default Produtos;

_

import { useState } from "react";

function ProdutoForm({ onAdicionar }) {
  const [nome, setNome] = useState("");
  const [preco, setPreco] = useState("");

  function submit(e) {
    e.preventDefault();

    const novoProduto = {
      id: Date.now(),
      nome,
      preco
    };

    onAdicionar(novoProduto);

    setNome("");
    setPreco("");
  }

  return (
    <form onSubmit={submit}>
      <input
        placeholder="Nome"
        value={nome}
        onChange={e => setNome(e.target.value)}
      />

      <input
        placeholder="Preço"
        value={preco}
        onChange={e => setPreco(e.target.value)}
      />

      <button type="submit">Adicionar</button>
    </form>
  );
}

export default ProdutoForm;

_

function ProdutoList({ produtos, onRemover }) {
  return (
    <ul>
      {produtos.map(produto => (
        <li key={produto.id}>
          {produto.nome} - R$ {produto.preco}
          <button onClick={() => onRemover(produto.id)}>
            Remover
          </button>
        </li>
      ))}
    </ul>
  );
}

export default ProdutoList;

_


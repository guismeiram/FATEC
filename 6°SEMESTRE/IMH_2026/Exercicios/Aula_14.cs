import { createContext, useState } from "react";

export const AppContext = createContext();

export function AppProvider({ children }) {
  const [produtos, setProdutos] = useState([]);

  function adicionar(produto) {
    setProdutos(prev => [...prev, produto]);
  }

  function remover(id) {
    setProdutos(prev => prev.filter(p => p.id !== id));
  }

  function atualizar(produto) {
    setProdutos(prev =>
      prev.map(p => (p.id === produto.id ? produto : p))
    );
  }

  return (
    <AppContext.Provider
      value={{ produtos, adicionar, remover, atualizar }}
    >
      {children}
    </AppContext.Provider>
  );
}

_

import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import { AppProvider } from "./context/AppContext";

ReactDOM.createRoot(document.getElementById("root")).render(
  <AppProvider>
    <App />
  </AppProvider>
);

_

import { useContext } from "react";
import { AppContext } from "../context/AppContext";
import ProdutoForm from "./ProdutoForm";
import ProdutoList from "./ProdutoList";

function Produtos() {
  const { produtos } = useContext(AppContext);

  return (
    <div>
      <ProdutoForm />
      <ProdutoList produtos={produtos} />
    </div>
  );
}

export default Produtos;

_

import { useState, useContext } from "react";
import { AppContext } from "../context/AppContext";

function ProdutoForm() {
  const { adicionar, atualizar } = useContext(AppContext);

  const [form, setForm] = useState({
    id: null,
    nome: "",
    preco: ""
  });

  function handleChange(e) {
    setForm({ ...form, [e.target.name]: e.target.value });
  }

  function submit(e) {
    e.preventDefault();

    if (!form.nome) return;

    if (form.id) {
      atualizar(form);
    } else {
      adicionar({ ...form, id: Date.now() });
    }

    setForm({ id: null, nome: "", preco: "" });
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
        {form.id ? "Atualizar" : "Adicionar"}
      </button>
    </form>
  );
}

export default ProdutoForm;

_

import { useContext } from "react";
import { AppContext } from "../context/AppContext";

function ProdutoList({ produtos }) {
  const { remover } = useContext(AppContext);

  return (
    <ul>
      {produtos.map(p => (
        <li key={p.id}>
          {p.nome} - R$ {p.preco}
          <button onClick={() => remover(p.id)}>Excluir</button>
        </li>
      ))}
    </ul>
  );
}

export default ProdutoList;

_

useEffect(() => {
  // simula carga inicial
  adicionar({ id: 1, nome: "Produto Inicial", preco: 100 });
}, []);

_

import { useContext, useMemo } from "react";
import { AppContext } from "../context/AppContext";

function Resumo() {
  const { produtos } = useContext(AppContext);

  const total = useMemo(
    () => produtos.reduce((acc, p) => acc + Number(p.preco || 0), 0),
    [produtos]
  );

  return <h3>Total: R$ {total}</h3>;
}

export default Resumo;

_


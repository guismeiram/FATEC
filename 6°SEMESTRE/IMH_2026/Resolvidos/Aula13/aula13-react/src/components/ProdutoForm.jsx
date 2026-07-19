import { useState } from "react";

function ProdutoForm({ onAdicionar }) {
    const [nome, setNome] = useState("");
    const [preco, setPreco] = useState("");

    function submit(e) {
        e.preventDefault();

        if (!nome || !preco) return; // Evita adicionar produtos vazios

        const novoProduto = {
            id: Date.now(),
            nome,
            preco: Number(preco) // Garante que o preço seja número
        };

        onAdicionar(novoProduto);

        setNome("");
        setPreco("");
    }

    return (
        <form className="produto-form" onSubmit={submit}>
            <input
                className="input-field"
                placeholder="Nome do Produto"
                value={nome}
                onChange={e => setNome(e.target.value)}
            />

            <input
                className="input-field"
                type="number"
                placeholder="Preço (R$)"
                value={preco}
                onChange={e => setPreco(e.target.value)}
            />

            <button className="btn-adicionar" type="submit">Adicionar</button>
        </form>
    );
}

export default ProdutoForm;
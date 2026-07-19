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

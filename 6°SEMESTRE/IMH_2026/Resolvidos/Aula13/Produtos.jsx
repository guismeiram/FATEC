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

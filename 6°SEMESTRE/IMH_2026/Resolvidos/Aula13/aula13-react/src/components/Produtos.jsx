import { useState } from "react";
import ProdutoForm from "./ProdutoForm";
import ProdutoList from "./ProdutoList";
import "./Produtos.css"; // Importação do arquivo de estilos

function Produtos() {
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
        <div className="produtos-container">
            <h2 className="titulo">Gerenciador de Produtos</h2>
            <ProdutoForm onAdicionar={adicionarProduto} />
            <ProdutoList produtos={produtos} onRemover={removerProduto} />
        </div>
    );
}

export default Produtos;

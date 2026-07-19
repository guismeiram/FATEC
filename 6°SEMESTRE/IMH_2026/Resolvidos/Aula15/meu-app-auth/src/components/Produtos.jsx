import { useState } from "react";
import { useProdutos } from "../hooks/useProdutos";
import ProdutoForm from "./ProdutoForm";

// 1. IMPORTANDO O CSS AQUI! 👇
import "./Produtos.css";

function Produtos() {
    const {
        produtos,
        loading,
        erro,
        salvarProduto,
        excluirProduto
    } = useProdutos();

    const [editando, setEditando] = useState(null);

    async function salvar(form) {
        await salvarProduto(form);
        setEditando(null);
    }

    return (
        <div className="produtos-container">
            <h2>Gerenciamento de Produtos</h2>

            <ProdutoForm
                produto={editando}
                onSalvar={salvar}
                onCancelar={() => setEditando(null)}
            />

            {loading && <p>Carregando...</p>}
            {erro && <p style={{ color: "red" }}>{erro}</p>}

            <ul className="produtos-lista">
                {produtos.map(p => (
                    <li className="produto-item" key={p.id}>
                        <div className="produto-info">
                            <span className="produto-nome">{p.nome}</span>
                            <span className="produto-preco">R$ {p.preco}</span>
                        </div>

                        <div className="produto-acoes">
                            <button className="btn-edit" onClick={() => setEditando(p)}>
                                Editar
                            </button>

                            <button className="btn-danger" onClick={() => excluirProduto(p.id)}>
                                Excluir
                            </button>
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default Produtos;
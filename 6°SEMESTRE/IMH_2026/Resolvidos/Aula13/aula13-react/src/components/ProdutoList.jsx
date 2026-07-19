function ProdutoList({ produtos, onRemover }) {
    return (
        <ul className="produto-list">
            {produtos.map(produto => (
                <li className="produto-item" key={produto.id}>
                    <span>
                        <strong>{produto.nome}</strong> - R$ {Number(produto.preco).toFixed(2)}
                    </span>
                    <button className="btn-remover" onClick={() => onRemover(produto.id)}>
                        Remover
                    </button>
                </li>
            ))}
        </ul>
    );
}

export default ProdutoList;
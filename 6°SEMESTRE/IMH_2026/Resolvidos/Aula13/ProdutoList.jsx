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
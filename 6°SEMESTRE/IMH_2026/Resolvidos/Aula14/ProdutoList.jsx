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
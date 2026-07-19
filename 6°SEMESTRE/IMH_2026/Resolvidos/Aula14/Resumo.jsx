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

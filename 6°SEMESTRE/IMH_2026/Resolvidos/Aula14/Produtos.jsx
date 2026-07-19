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

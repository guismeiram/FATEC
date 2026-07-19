import { useState, useContext } from "react";
import { AppContext } from "../context/AppContext";

function ProdutoForm() {
    const { adicionar, atualizar } = useContext(AppContext);

    const [form, setForm] = useState({
        id: null,
        nome: "",
        preco: ""
    });

    function handleChange(e) {
        setForm({ ...form, [e.target.name]: e.target.value });
    }

    function submit(e) {
        e.preventDefault();

        if (!form.nome) return;

        if (form.id) {
            atualizar(form);
        } else {
            adicionar({ ...form, id: Date.now() });
        }

        setForm({ id: null, nome: "", preco: "" });
    }

    return (
        <form onSubmit={submit}>
            <input
                name="nome"
                placeholder="Nome"
                value={form.nome}
                onChange={handleChange}
            />

            <input
                name="preco"
                placeholder="Preço"
                value={form.preco}
                onChange={handleChange}
            />

            <button type="submit">
                {form.id ? "Atualizar" : "Adicionar"}
            </button>
        </form>
    );
}

export default ProdutoForm;

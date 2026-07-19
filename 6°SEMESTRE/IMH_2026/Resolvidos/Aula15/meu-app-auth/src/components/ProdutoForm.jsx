import { useEffect, useState } from "react";

function ProdutoForm({ produto, onSalvar, onCancelar }) {
    const [form, setForm] = useState({
        id: null,
        nome: "",
        preco: "",
        ativo: true
    });

    useEffect(() => {
        if (produto) {
            setForm({
                id: produto.id,
                nome: produto.nome,
                preco: produto.preco,
                ativo: true
            });
        } else {
            setForm({
                id: null,
                nome: "",
                preco: "",
                ativo: true
            });
        }
    }, [produto]);

    function handleChange(e) {
        setForm({
            ...form,
            [e.target.name]: e.target.value
        });
    }

    function submit(e) {
        e.preventDefault();
        onSalvar(form);
    }

    return (
        <form className="produto-form-card" onSubmit={submit}>
            <input
                className="produto-input"
                name="nome"
                placeholder="Nome do produto"
                value={form.nome}
                onChange={handleChange}
            />

            <input
                className="produto-input"
                name="preco"
                placeholder="Preço (Ex: 150.00)"
                value={form.preco}
                onChange={handleChange}
            />

            <button className="btn-primary" type="submit">
                {form.id ? "Atualizar" : "Cadastrar"}
            </button>

            {form.id && (
                <button className="btn-secondary" type="button" onClick={onCancelar}>
                    Cancelar
                </button>
            )}
        </form>
    );
}

export default ProdutoForm;
import { useEffect, useState } from "react";
import {
    listarProdutos,
    criarProduto,
    atualizarProduto,
    deletarProduto
} from "../services/produtoService";

export function useProdutos() {
    const [produtos, setProdutos] = useState([]);
    const [loading, setLoading] = useState(false);
    const [erro, setErro] = useState("");

    async function carregarProdutos() {
        setLoading(true);
        setErro("");

        try {
            const response = await listarProdutos();

            const lista = response.data.items ?? response.data;

            if (Array.isArray(lista)) {
                setProdutos(lista);
            } else {
                setProdutos([]);
            }
        } catch {
            setErro("Erro ao carregar produtos.");
            setProdutos([]);
        } finally {
            setLoading(false);
        }
    }

    async function salvarProduto(produto) {
        setLoading(true);
        setErro("");

        try {
            if (produto.id) {
                await atualizarProduto(produto.id, produto);
            } else {
                await criarProduto(produto);
            }

            await carregarProdutos();
        } catch (error) {
            if (error.response?.status === 400) {
                setErro("Erro 400.");
            } else if (error.response?.status === 500) {
                setErro("Erro 500.");
            } else {
                setErro("Erro ao salvar.");
            }
        } finally {
            setLoading(false);
        }
    }

    async function excluirProduto(id) {
        setLoading(true);
        setErro("");

        try {
            await deletarProduto(id);
            await carregarProdutos();
        } catch {
            setErro("Erro ao excluir.");
        } finally {
            setLoading(false);
        }
    }

    useEffect(() => {
        carregarProdutos();
    }, []);

    return {
        produtos,
        loading,
        erro,
        salvarProduto,
        excluirProduto
    };
}
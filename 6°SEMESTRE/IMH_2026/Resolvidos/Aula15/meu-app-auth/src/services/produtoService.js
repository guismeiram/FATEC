import api from "./api";

export function listarProdutos() {
    return api.get("/produtos");
}

export function criarProduto(produto) {
    return api.post("/produtos", produto);
}

export function atualizarProduto(id, produto) {
    return api.put(`/produtos/${id}`, produto);
}

export function deletarProduto(id) {
    return api.delete(`/produtos/${id}`);
}
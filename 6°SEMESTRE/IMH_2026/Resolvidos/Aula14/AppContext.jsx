import { createContext, useState } from "react";

export const AppContext = createContext();

export function AppProvider({ children }) {
    const [produtos, setProdutos] = useState([]);

    function adicionar(produto) {
        setProdutos(prev => [...prev, produto]);
    }

    function remover(id) {
        setProdutos(prev => prev.filter(p => p.id !== id));
    }

    function atualizar(produto) {
        setProdutos(prev =>
            prev.map(p => (p.id === produto.id ? produto : p))
        );
    }

    return (
        <AppContext.Provider
            value={{ produtos, adicionar, remover, atualizar }}
        >
            {children}
        </AppContext.Provider>
    );
} 
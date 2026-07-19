import { createContext, useState, useEffect } from "react";
import api from "../services/api";
import { setAuthToken, clearAuthToken } from "../services/tokenStore";

export const AuthContext = createContext();

export function AuthProvider({ children }) {
  const [token, setToken] = useState(null);
  const [usuario, setUsuario] = useState(null);

  async function login(email, password) {
    // 1. Continuamos enviando email e password, que agora coincidem com o DTO do C#
    const response = await api.post("/auth/login", {
      email,
      password
    });

    // 2. CORREÇÃO DE BUG: Mude .accessToken para .token para corresponder à resposta do C#
    const accessToken = response.data.token;

    setToken(accessToken);
    setAuthToken(accessToken);
    setUsuario({ email });
  }

  function logout() {
    setToken(null);
    clearAuthToken(); // Limpa token da memória
    setUsuario(null);
  }

  return (
    <AuthContext.Provider
      value={{ token, usuario, login, logout, isAuth: !!token }}
    >
      {children}
    </AuthContext.Provider>
  );
}
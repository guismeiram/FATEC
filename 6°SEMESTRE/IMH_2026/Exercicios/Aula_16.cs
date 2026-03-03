import { createContext, useState, useEffect } from "react";
import api from "../services/api";

export const AuthContext = createContext();

export function AuthProvider({ children }) {
  const [token, setToken] = useState(null);
  const [usuario, setUsuario] = useState(null);

  async function login(email, password) {
    const response = await api.post("/auth/login", {
      email,
      password
    });

    const accessToken = response.data.accessToken;

    setToken(accessToken);
    setUsuario({ email });
  }

  function logout() {
    setToken(null);
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

_

import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import { AuthProvider } from "./context/AuthContext";

ReactDOM.createRoot(document.getElementById("root")).render(
  <AuthProvider>
    <App />
  </AuthProvider>
);

_

import axios from "axios";
import { getAuthToken } from "./tokenStore";

const api = axios.create({
  baseURL: "https://localhost:5001/api/v1"
});

api.interceptors.request.use(config => {
  const token = getAuthToken();
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default api;

_


let token = null;

export function setAuthToken(t) {
  token = t;
}

export function getAuthToken() {
  return token;
}

export function clearAuthToken() {
  token = null;
}

_

setAuthToken(accessToken);

_

import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

function Login() {
  const { login } = useContext(AuthContext);
  const navigate = useNavigate();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  async function submit(e) {
    e.preventDefault();
    await login(email, password);
    navigate("/produtos");
  }

  return (
    <form onSubmit={submit}>
      <input
        placeholder="Email"
        value={email}
        onChange={e => setEmail(e.target.value)}
      />

      <input
        type="password"
        placeholder="Senha"
        value={password}
        onChange={e => setPassword(e.target.value)}
      />

      <button type="submit">Entrar</button>
    </form>
  );
}

export default Login;

_

import { useContext } from "react";
import { Navigate } from "react-router-dom";
import { AuthContext } from "../context/AuthContext";

function PrivateRoute({ children }) {
  const { isAuth } = useContext(AuthContext);

  return isAuth ? children : <Navigate to="/login" />;
}

export default PrivateRoute;

_

import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/Login";
import Produtos from "./components/Produtos";
import PrivateRoute from "./components/PrivateRoute";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login />} />

        <Route
          path="/produtos"
          element={
            <PrivateRoute>
              <Produtos />
            </PrivateRoute>
          }
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;

_

import { useContext } from "react";
import { AuthContext } from "../context/AuthContext";

function Header() {
  const { logout } = useContext(AuthContext);

  return (
    <button onClick={logout}>
      Sair
    </button>
  );
}

export default Header;

_


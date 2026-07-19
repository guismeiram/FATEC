import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

// 1. IMPORTANDO O CSS AQUI! 👇
import "./Login.css";

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
        // 2. ADICIONANDO AS CLASSES (className) AQUI! 👇
        <div className="login-container">
            <form className="login-form" onSubmit={submit}>
                <h2>Bem-vindo</h2>

                <input
                    className="login-input"
                    placeholder="Email"
                    value={email}
                    onChange={e => setEmail(e.target.value)}
                />

                <input
                    className="login-input"
                    type="password"
                    placeholder="Senha"
                    value={password}
                    onChange={e => setPassword(e.target.value)}
                />

                <button className="login-button" type="submit">
                    Entrar
                </button>
            </form>
        </div>
    );
}

export default Login;
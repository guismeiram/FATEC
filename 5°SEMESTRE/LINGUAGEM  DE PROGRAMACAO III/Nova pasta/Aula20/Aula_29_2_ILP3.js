import axios from 'axios';
import { ref } from 'vue';

const API_URL = 'http://localhost:8080/api/auth';
const token = ref(localStorage.getItem('token'));

export function useAuth() {
    const login = async (username, password) => {
        try {
            const response = await axios.post(`${API_URL}/login`, { username, password });
            token.value = response.data.token;
            localStorage.setItem('token', token.value);
            return true;
        } catch (error) {
            console.error("Login failed:", error);
            return false;
        }
    };

    return { token, login };
}
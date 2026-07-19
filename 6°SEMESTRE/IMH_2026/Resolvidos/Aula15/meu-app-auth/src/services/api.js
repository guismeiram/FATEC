import axios from "axios";
import { getAuthToken } from "./tokenStore";

const api = axios.create({
  baseURL: "http://localhost:5144/api/v1"
});

api.interceptors.request.use(config => {
  const token = getAuthToken();
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default api;
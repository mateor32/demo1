import axios from "axios"

const api = axios.create({
  // CAMBIO PARA VERCEL: la URL del backend viene de la variable VITE_API_URL
  // (la URL de Render, sin barra final). En local sigue usando http://localhost:8080.
  baseURL: import.meta.env.VITE_API_URL || "http://localhost:8080",
  headers: { "Content-Type": "application/json" },
})

export default api

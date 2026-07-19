import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/Login";
import Produtos from "./components/Produtos"; // Crie este componente depois
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
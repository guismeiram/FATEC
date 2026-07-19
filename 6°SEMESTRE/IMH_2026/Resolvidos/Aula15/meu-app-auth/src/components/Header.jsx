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
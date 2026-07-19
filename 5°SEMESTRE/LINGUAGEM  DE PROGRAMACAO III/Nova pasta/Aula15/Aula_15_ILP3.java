/* Flexbox */
.container {
  display: flex;
  justify-content: center; /* Alinhamento horizontal */
  align-items: center;     /* Alinhamento vertical */
  flex-wrap: wrap;         /* Quebra de linha */
}

/* Grid */
.container {
  display: grid;
  grid-template-columns: 1fr 2fr 1fr; /* Colunas */
  grid-gap: 10px;                     /* Espaçamento */
}

_______________________________________________________________

/* Mobile */
@media (max-width: 600px) { /* Estilos */ }

/* Tablet */
@media (min-width: 601px) and (max-width: 1024px) { /* Estilos */ }

/* Desktop */
@media (min-width: 1025px) { /* Estilos */ }


_______________________________________________________________

<div class="dashboard">
  <header>Meu Dashboard</header>
  <nav>Menu</nav>
  <main>Conteúdo Principal</main>
  <aside>Sidebar</aside>
  <footer>Rodapé</footer>
</div>

_______________________________________________________________

.dashboard {
  min-height: 100vh;
  display: grid;
  grid-template-areas:
    "header header"
    "nav main"
    "footer footer";
}

_______________________________________________________________

header {
  grid-area: header;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
}

_______________________________________________________________

nav {
  grid-area: nav;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

_______________________________________________________________

main {
  grid-area: main;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(2
  50px, 1fr));
  gap: 15px;
  padding: 15px;
}


_______________________________________________________________

.card {
  display: flex;
  flex-direction: column;
  border: 1px solid #ddd;
  border-radius: 8px;
}

_______________________________________________________________

@media (max-width: 600px) {
  .dashboard {
    grid-template-areas:
      "header"
      "nav"
      "main"
      "footer";
  }
  nav { flex-direction: row; }
}

_______________________________________________________________

@media (min-width: 601px) and (max-width: 900px) {
  main { grid-template-columns: 1fr 1fr; }
}

_______________________________________________________________


  
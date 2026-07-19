<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

_____________________________________________________________________

npm install -D tailwindcss
npx tailwindcss init

_____________________________________________________________________

/* styles.css */
@tailwind base;
@tailwind components;
@tailwind utilities;

_____________________________________________________________________

<nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Meu Site</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link active" href="#">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Produtos</a></li>
      </ul>
    </div>
  </div>
</nav>

_____________________________________________________________________


<div class="max-w-sm rounded overflow-hidden shadow-lg mx-auto my-4">
  <img class="w-full" src="https://via.placeholder.com/300" alt="Produto">
  <div class="px-6 py-4">
    <div class="font-bold text-xl mb-2">Notebook Gamer</div>
    <p class="text-gray-700 text-base">R$ 4500,00</p>
  </div>
  <div class="px-6 pt-4 pb-2">
    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
      Comprar
    </button>
  </div>
</div>

_____________________________________________________________________

<div class="container">
  <div class="row">
    <div class="col-md-4">Item 1</div>
    <div class="col-md-4">Item 2</div>
    <div class="col-md-4">Item 3</div>
  </div>
</div>

_____________________________________________________________________

<div class="grid grid-cols-1 md:grid-cols-3 gap-4">
  <div>Item 1</div>
  <div>Item 2</div>
  <div>Item 3</div>
</div>

_____________________________________________________________________

$primary: #ff5722; // Laranja personalizado
@import "bootstrap/scss/bootstrap";


_____________________________________________________________________

module.exports = {
  theme: {
    extend: {
      colors: {
        primary: '#ff5722'
      }
    }
  }
}

_____________________________________________________________________




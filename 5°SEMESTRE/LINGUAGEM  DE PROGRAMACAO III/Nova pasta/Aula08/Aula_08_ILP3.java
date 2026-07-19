# Comandos para criar e configurar um projeto Vue.js com Vite
npm create vite@latest task-app-vue --template vue  # Cria novo projeto Vue com template padrão
cd task-app-vue  # Entra na pasta do projeto
npm install axios vue-router pinia  # Instala dependências essenciais:
                                   # - axios: para requisições HTTP
                                   # - vue-router: para roteamento
                                   # - pinia: para gerenciamento de estado
npm run dev  # Inicia servidor de desenvolvimento

____________________________________________________

// Configuração básica de roteamento (router.js)
import { createRouter, createWebHistory } from 'vue-router';  // Importa funções do Vue Router
import TaskList from '../views/TaskList.vue';  // Importa o componente da lista de tarefas

// Define as rotas da aplicação
const routes = [
  { path: '/', component: TaskList }  // Rota principal que renderiza TaskList
];

// Cria e exporta a instância do router
const router = createRouter({
  history: createWebHistory(),  // Usa o modo history (URLs limpas sem #)
  routes  // Registra as rotas definidas
});

export default router;

____________________________________________________

<!-- Componente TaskList.vue (lista de tarefas) -->
<template>
  <div>
    <h1>Minhas Tarefas</h1>
    <ul>
      <!-- v-for renderiza cada tarefa da lista -->
      <li v-for="task in tasks" :key="task.id">
        {{ task.title }} - {{ task.completed ? '✓' : '✗' }}  <!-- Exibe status -->
      </li>
    </ul>
  </div>
</template>

<script setup>
// Composition API com <script setup>
import { ref, onMounted } from 'vue';  // Funções reativas e lifecycle
import axios from 'axios';  // Para requisições HTTP

const tasks = ref([]);  // Estado reativo da lista de tarefas

// Hook que executa quando o componente é montado
onMounted(async () => {
  const response = await axios.get('http://localhost:8080/api/tasks');  // Busca tarefas
  tasks.value = response.data;  // Atualiza estado com dados da API
});
</script>

<!-- Estilos com escopo (só aplicam a este componente) -->
<style scoped>
ul {
  list-style: none;  /* Remove marcadores de lista */
  padding: 0;       /* Remove padding padrão */
}
li {
  padding: 8px;     /* Espaçamento interno */
  margin: 4px 0;    /* Margem entre itens */
  border: 1px solid #eee;  /* Borda sutil */
}
</style>


____________________________________________________

// Arquivo taskService.js - camada de serviço para API
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/tasks';  // URL base da API

// Serviços exportados:
export const fetchTasks = () => axios.get(API_URL);  // Busca todas tarefas
export const createTask = (task) => axios.post(API_URL, task);  // Cria nova tarefa

____________________________________________________

<!-- Componente com formulário de adição (TaskList.vue atualizado) -->
<template>
  <div>
    <!-- Input vinculado ao estado newTask.title -->
    <input v-model="newTask.title" placeholder="Nova tarefa">
    <!-- Botão que dispara addTask -->
    <button @click="addTask">Adicionar</button>
    <!-- Lista existente de tarefas -->
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { fetchTasks, createTask } from '../services/taskService';  // Importa serviços

const tasks = ref([]);  // Estado da lista
const newTask = ref({ title: '', completed: false });  // Estado do novo item

// Carrega tarefas da API
const loadTasks = async () => {
  const response = await fetchTasks();
  tasks.value = response.data;
};

// Adiciona nova tarefa
const addTask = async () => {
  await createTask(newTask.value);  // Chama API
  newTask.value = { title: '', completed: false };  // Reseta formulário
  await loadTasks();  // Recarrega lista
};

// Carrega tarefas inicialmente
loadTasks();
</script>

____________________________________________________

Fluxo de dados em Vue.js:
1. Componente → Chama métodos do componente
2. Serviço → Faz chamadas à API externa
3. API → Processa requisições e retorna dados
4. Renderização → Atualiza a interface com os dados recebidos

____________________________________________________


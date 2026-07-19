// Opções API (Vue 2 e Vue 3)
data() {
  return { count: 0 } // Reativo automaticamente
}

// Composition API (Vue 3)
import { ref } from 'vue'
const count = ref(0) // Reatividade explícita

____________________________________________________

<template>
  <div>{{ message }}</div>
</template>

<script>
export default {
  data() {
    return { message: 'Hello Vue!' }
  },
  methods: {
    updateMessage() {
      this.message = 'Updated!'
    }
  }
}
</script>

<style scoped>
div { color: blue; }
</style>

____________________________________________________

npm create vue@latest vue-counter
cd vue-counter
npm install
npm run dev

____________________________________________________

<template>
  <div class="counter">
    <h1>{{ title }}</h1>
    <p>Count: {{ count }}</p>
    <button @click="increment">+</button>
    <button @click="decrement">-</button>
  </div>
</template>

____________________________________________________

<script setup>
import { ref } from 'vue'

const title = 'Vue Counter'
const count = ref(0)

const increment = () => count.value++
const decrement = () => count.value--
</script>

____________________________________________________

<style scoped>
.counter {
  text-align: center;
  margin-top: 50px;
}
button {
  margin: 0 10px;
  padding: 8px 16px;
}
</style>

____________________________________________________

<ul>
  <li v-for="(item, index) in items" :key="index">
    {{ item.name }} - R$ {{ item.price }}
  </li>
</ul>

____________________________________________________

const items = ref([
  { name: 'Notebook', price: 4500 },
  { name: 'Mouse', price: 150 }
])

____________________________________________________

<p v-if="count > 10">O contador passou de 10!</p>
<p v-else>Continue incrementando...</p>

____________________________________________________

<a :href="url">Link Dinâmico</a>

____________________________________________________


const url = 'https://vuejs.org'

____________________________________________________




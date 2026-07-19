// http.js
axios.interceptors.request.use(config => {
  const token = localStorage.getItem('token')
  if (token) config.headers.Authorization = `Bearer ${token}`
  return config
})

__________________________________________________________________

npm install axios

__________________________________________________________________
import axios from 'axios'

const http = axios.create({
  baseURL: 'https://jsonplaceholder.typicode.com',
  timeout: 5000
})

export default http

__________________________________________________________________

import http from './http'

export const PostService = {
  async getAll() {
    const response = await http.get('/posts')
    return response.data
  },
  async create(post) {
    const response = await http.post('/posts', post)
    return response.data
  }
}

__________________________________________________________________


<template>
  <div>
    <button @click="loadPosts">Carregar Posts</button>
    <ul v-if="!loading">
      <li v-for="post in posts" :key="post.id">{{ post.title }}</li>
    </ul>
    <p v-else>Carregando...</p>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { PostService } from '@/api/postService'

const posts = ref([])
const loading = ref(false)

const loadPosts = async () => {
  loading.value = true
  posts.value = await PostService.getAll()
  loading.value = false
}
</script>

__________________________________________________________________

<template>
  <form @submit.prevent="handleSubmit">
    <input v-model="post.title" placeholder="Título">
    <textarea v-model="post.body"></textarea>
    <button type="submit">Salvar</button>
  </form>
</template>

<script setup>
import { reactive } from 'vue'
import { PostService } from '@/api/postService'

const post = reactive({ title: '', body: '' })

const handleSubmit = async () => {
  await PostService.create(post)
  alert('Post criado!')
  Object.assign(post, { title: '', body: '' })
}
</script>

__________________________________________________________________

http.interceptors.response.use(
  response => response,
  error => {
    if (error.response.status === 401) {
      window.location.href = '/login'
    }
    return Promise.reject(error)
  }
)

__________________________________________________________________


const loadPosts = async () => {
  try {
    loading.value = true
    posts.value = await PostService.getAll()
  } catch (error) {
    console.error('Falha ao carregar posts:', error)
  } finally {
    loading.value = false
  }
}

__________________________________________________________________


// composables/useApi.js
import { ref } from 'vue'
import { PostService } from '@/api/postService'

export function useApi() {
  const error = ref(null)

  const fetchPosts = async () => {
    try {
      return await PostService.getAll()
    } catch (err) {
      error.value = err
      throw err
    }
  }

  return { error, fetchPosts }
}

__________________________________________________________________


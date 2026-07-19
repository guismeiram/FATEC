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
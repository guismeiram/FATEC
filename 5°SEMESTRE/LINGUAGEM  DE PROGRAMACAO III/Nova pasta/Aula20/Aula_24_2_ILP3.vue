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
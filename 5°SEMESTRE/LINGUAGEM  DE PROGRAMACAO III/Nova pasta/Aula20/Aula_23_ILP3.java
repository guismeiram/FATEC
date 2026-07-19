// composables/useCounter.js
import { ref } from 'vue'

export function useCounter(initialValue = 0) {
  const count = ref(initialValue)

  const increment = () => count.value++
  const decrement = () => count.value--

  return { count, increment, decrement }
}

_____________________________________________________

import { ref } from 'vue'

export function useFetch(url) {
  const data = ref(null)
  const error = ref(null)
  const loading = ref(false)

  const fetchData = async () => {
    loading.value = true
    try {
      const response = await fetch(url)
      data.value = await response.json()
    } catch (err) {
      error.value = err
    } finally {
      loading.value = false
    }
  }

  return { data, error, loading, fetchData }
}

_____________________________________________________

<script setup>
import { useFetch } from '@/composables/useFetch'

const { data: posts, loading, fetchData } = useFetch('https://jsonplaceholder.typicode.com/posts')

fetchData() // Chamada inicial
</script>

_____________________________________________________

import { ref, watchEffect } from 'vue'

export function useLocalStorage(key, defaultValue) {
  const storedValue = localStorage.getItem(key)
  const value = ref(storedValue ? JSON.parse(storedValue) : defaultValue)

  watchEffect(() => {
    localStorage.setItem(key, JSON.stringify(value.value))
  })

  return value
}

_____________________________________________________

<script setup>
import { useLocalStorage } from '@/composables/useLocalStorage'

const darkMode = useLocalStorage('darkMode', false)
</script>

_____________________________________________________


import { ref, onMounted, onUnmounted } from 'vue'

export function useMouseTracker() {
  const x = ref(0)
  const y = ref(0)

  const update = (e) => {
    x.value = e.clientX
    y.value = e.clientY
  }

  onMounted(() => window.addEventListener('mousemove', update))
  onUnmounted(() => window.removeEventListener('mousemove', update))

  return { x, y }
}

_____________________________________________________

<template>
  <div>Mouse position: {{ x }}, {{ y }}</div>
</template>

<script setup>
import { useMouseTracker } from '@/composables/useMouseTracker'
const { x, y } = useMouseTracker()
</script>

_____________________________________________________


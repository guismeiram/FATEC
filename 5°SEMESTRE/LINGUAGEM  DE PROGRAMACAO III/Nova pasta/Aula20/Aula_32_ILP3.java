npm install -D vitest @vue/test-utils happy-dom

__________________________________________________________________________

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  plugins: [vue()],
  test: {
    globals: true,
    environment: 'happy-dom'
  }
})

__________________________________________________________________________

"scripts": {
  "test": "vitest",
  "test:watch": "vitest watch"
}

__________________________________________________________________________

<template>
  <button @click="increment">{{ count }}</button>
</template>

<script setup>
import { ref } from 'vue'
const count = ref(0)
const increment = () => count.value++
</script>

__________________________________________________________________________


import { mount } from '@vue/test-utils'
import Counter from '@/components/Counter.vue'

describe('Counter.vue', () => {
  it('increments count on click', async () => {
    const wrapper = mount(Counter)
    await wrapper.find('button').trigger('click')
    expect(wrapper.text()).toContain('1')
  })
})

__________________________________________________________________________


it('renders greeting message', () => {
  const wrapper = mount(Greeting, {
    props: { name: 'John' }
  })
  expect(wrapper.text()).toMatch('Hello, John!')
})
__________________________________________________________________________


import { ref } from 'vue'

export function useCounter(initialValue = 0) {
  const count = ref(initialValue)
  const increment = () => count.value++
  return { count, increment }
}

__________________________________________________________________________


import { useCounter } from '@/composables/useCounter'
import { renderHook } from '@testing-library/vue'

describe('useCounter', () => {
  it('increments count', () => {
    const { result } = renderHook(() => useCounter())
    result.increment()
    expect(result.count.value).toBe(1)
  })
})

__________________________________________________________________________

npm install -D msw

__________________________________________________________________________

import { rest } from 'msw'

export const handlers = [
  rest.get('/api/products', (req, res, ctx) => {
    return res(ctx.json([{ id: 1, name: 'Notebook' }]))
  })
]

__________________________________________________________________________
import { setupServer } from 'msw/node'
import { handlers } from '@/mocks/handlers'

const server = setupServer(...handlers)

beforeAll(() => server.listen())
afterEach(() => server.resetHandlers())
afterAll(() => server.close())

it('loads products', async () => {
  const wrapper = mount(ProductList)
  await flushPromises()
  expect(wrapper.findAll('li')).toHaveLength(1)
})

__________________________________________________________________________


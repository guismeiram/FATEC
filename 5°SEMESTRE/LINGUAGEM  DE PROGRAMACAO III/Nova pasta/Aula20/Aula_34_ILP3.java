npm install vuetify@next @mdi/font

_____________________________________________

import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'

createApp(App)
  .use(vuetify)
  .mount('#app')
  
_____________________________________________

<template>
  <v-btn color="primary" @click="count++">
    Clicks: {{ count }}
  </v-btn>
</template>

<script setup>
import { ref } from 'vue'
const count = ref(0)
</script>

_____________________________________________

npm install -g @quasar/cli
quasar create my-app

_____________________________________________


<template>
  <q-btn 
    color="primary" 
    label="Clique-me" 
    @click="alert('Hello Quasar!')" 
  />
</template>

_____________________________________________



<!-- Scoped Styles (padrão Vue) -->
<style scoped>
.button { color: red; }  /* Vira .button[data-v-f3f3eg9] */
</style>

<!-- CSS Modules -->
<style module>
.button { color: blue; }  /* Vira ._button_1nz2r_1 */
</style>

_________________________________________________________

<template>
  <button class="btn">Clique-me</button>
</template>

<style scoped>
.btn {
  background: #42b983;
  color: white;
}
/* Estilo NÃO vaza para outros componentes */
</style>

_________________________________________________________


<button class="btn" data-v-f3f3eg9>Clique-me</button>

_________________________________________________________

.btn[data-v-f3f3eg9] { background: #42b983; }

_________________________________________________________


export default defineConfig({
  css: {
    modules: {
      localsConvention: 'camelCase' // Permite usar `styles.myClass`
    }
  }
})
_________________________________________________________

<template>
  <button :class="styles.primaryButton">Salvar</button>
</template>

<script setup>
import styles from './ModuleButton.module.css'
</script>

<style module>
.primary-button {  /* Kebab-case vira camelCase */
  background: #646cff;
}
</style>

_________________________________________________________

<button class="_primary-button_1nz2r_1">Salvar</button>

_________________________________________________________

<template>
  <button :class="[$style.button, 'global-class']">OK</button>
</template>

<style module>
.button { border: 2px solid; }
</style>

<style>
.global-class { font-weight: bold; }
</style>

_________________________________________________________


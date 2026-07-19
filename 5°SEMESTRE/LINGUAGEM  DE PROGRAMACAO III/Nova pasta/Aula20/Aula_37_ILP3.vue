<template>
  <div class="chat-container">
    <q-list bordered class="message-list">
      <q-item v-for="msg in messages" :key="msg.id">
        <strong>{{ msg.sender }}:</strong> {{ msg.content }}
      </q-item>
    </q-list>

    <q-input 
      v-model="newMessage" 
      label="Digite sua mensagem" 
      @keyup.enter="handleSend"
    >
      <template #append>
        <q-btn icon="send" @click="handleSend" />
      </template>
    </q-input>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { useChat } from '@/composables/useChat';

const { messages, sendMessage } = useChat();
const newMessage = ref('');

const handleSend = () => {
  if (newMessage.value.trim()) {
    sendMessage(newMessage.value, 'Usuário Anônimo');
    newMessage.value = '';
  }
};
</script>

<style scoped>
.chat-container {
  max-width: 600px;
  margin: 0 auto;
}
.message-list {
  height: 400px;
  overflow-y: auto;
}
</style>
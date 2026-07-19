<template>
  <div class="dashboard">
    <q-card>
      <q-card-section>
        <h5>Estatísticas do Chat</h5>
        <div v-if="stats">
          <p>Total de mensagens: {{ stats.totalMessages }}</p>
          <p>Usuários online: {{ stats.usersOnline }}</p>
          <q-chart 
            type="bar" 
            :data="chartData" 
            :options="chartOptions" 
          />
        </div>
      </q-card-section>
    </q-card>
  </div>
</template>

<script setup lang="ts">
import { useSSE } from '@/composables/useSSE';
import { computed } from 'vue';

const { data: stats } = useSSE('http://localhost:8080/stats/stream');

const chartData = computed(() => ({
  labels: Object.keys(stats.value?.messagesPerUser || {}),
  datasets: [{
    label: 'Mensagens por usuário',
    data: Object.values(stats.value?.messagesPerUser || {}),
    backgroundColor: '#1976D2'
  }]
}));

const chartOptions = {
  responsive: true
};
</script>
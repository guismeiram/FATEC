public record ChatStats(
    long totalMessages,
    long usersOnline,
    Map<String, Long> messagesPerUser, // Contagem por usuário
    Instant lastUpdate
) {}

__________________________________________________________

@RestController
@RequestMapping("/stats")
public class StatsController {

    @GetMapping(path = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ChatStats> streamStats() {
        return Flux.interval(Duration.ofSeconds(2)) // Atualiza a cada 2s
            .flatMap(tick -> statsService.getRealTimeStats());
    }
}

__________________________________________________________

@Service
public class StatsService {

    public Mono<ChatStats> getRealTimeStats() {
        return Mono.zip(
            messageRepository.count(),
            userSessionRepository.countActiveSessions(),
            messageRepository.countByUser()
        ).map(tuple -> new ChatStats(
            tuple.getT1(), 
            tuple.getT2(),
            tuple.getT3(),
            Instant.now()
        ));
    }
}

__________________________________________________________


import { ref } from 'vue';

export function useSSE(url: string) {
    const data = ref<any>(null);
    const error = ref<Error | null>(null);

    const eventSource = new EventSource(url);

    eventSource.onmessage = (event) => {
        data.value = JSON.parse(event.data);
    };

    eventSource.onerror = (err) => {
        error.value = err;
    };

    return { data, error };
}

__________________________________________________________

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

__________________________________________________________


// No componente DashboardStats.vue
const timeRange = ref('PT5M');
const historicalData = ref<number[]>([]);

watch(stats, (newStats) => {
  if (newStats?.usersOnline) {
    historicalData.value.push(newStats.usersOnline);
    if (historicalData.value.length > 10) {
      historicalData.value.shift();
    }
  }
});

// Novo gráfico
const historyChartData = computed(() => ({
  labels: historicalData.value.map((_, i) => `Ponto ${i + 1}`),
  datasets: [{
    label: 'Usuários online (histórico)',
    data: historicalData.value,
    borderColor: '#FF6B6B'
  }]
}));

__________________________________________________________


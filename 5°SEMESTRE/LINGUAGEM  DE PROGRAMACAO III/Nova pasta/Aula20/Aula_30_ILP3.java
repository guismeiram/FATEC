@GetMapping(path = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public Flux<String> streamData() {
    return Flux.interval(Duration.ofSeconds(1))
        .map(sequence -> "Evento " + sequence);
}

________________________________________________________________________

const socket = new WebSocket("ws://localhost:8080/ws");
socket.onmessage = (event) => console.log(event.data);

________________________________________________________________________

@RestController
public class SSEController {
    @GetMapping(value = "/api/sse/temperatura", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> streamTemperatura() {
        return Flux.interval(Duration.ofSeconds(1))
            .map(i -> new Random().nextInt(40)); // Simula sensor de temperatura
    }
}

________________________________________________________________________

@Bean
public WebFilter corsFilter() {
    return (exchange, chain) -> {
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "*");
        return chain.filter(exchange);
    };
}

________________________________________________________________________

import { ref, onMounted } from 'vue';

export function useSSE(url) {
    const data = ref(null);
    const error = ref(null);

    onMounted(() => {
        const eventSource = new EventSource(url);

        eventSource.onmessage = (event) => {
            data.value = event.data;
        };

        eventSource.onerror = (err) => {
            error.value = err;
            eventSource.close();
        };
    });

    return { data, error };
}

________________________________________________________________________


<template>
  <div>Temperatura atual: {{ temperatura }}°C</div>
</template>

<script setup>
import { useSSE } from '@/composables/useSSE';
const { data: temperatura } = useSSE('http://localhost:8080/api/sse/temperatura');
</script>

________________________________________________________________________

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("*");
    }
}

________________________________________________________________________

@Controller
public class ChatController {
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public String sendMessage(String message) {
        return "Usuário disse: " + message;
    }
}

________________________________________________________________________


npm install sockjs-client @stomp/stompjs

________________________________________________________________________

import { ref } from 'vue';
import { Client } from '@stomp/stompjs';

export function useWebSocket() {
    const messages = ref([]);
    const client = new Client({
        brokerURL: 'ws://localhost:8080/ws',
        onConnect: () => {
            client.subscribe('/topic/public', (message) => {
                messages.value.push(message.body);
            });
        }
    });

    client.activate();

    const sendMessage = (text) => {
        client.publish({ destination: '/app/chat.send', body: text });
    };

    return { messages, sendMessage };
}


________________________________________________________________________


<template>
  <div>
    <ul>
      <li v-for="(msg, index) in messages" :key="index">{{ msg }}</li>
    </ul>
    <input v-model="newMessage" @keyup.enter="sendMessage(newMessage)">
  </div>
</template>

________________________________________________________________________



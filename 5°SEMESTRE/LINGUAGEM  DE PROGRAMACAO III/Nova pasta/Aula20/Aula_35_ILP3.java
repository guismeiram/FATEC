# Criar projeto Spring Boot
spring init --dependencies=webflux,websocket,data-r2dbc,postgresql reactive-chat-backend

_______________________________________________________________________________________

docker run --name chat-db -e POSTGRES_PASSWORD=secret -p 5432:5432 -d postgres:14

_______________________________________________________________________________________

// Message.java
public record Message(
    @Id UUID id,
    String content,
    String sender,
    Instant timestamp
) {}

// MessageRepository.java
public interface MessageRepository extends ReactiveCrudRepository<Message, UUID> {}

_______________________________________________________________________________________

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageRepository repo;

    @GetMapping
    public Flux<Message> getAll() {
        return repo.findAll();
    }
}

_______________________________________________________________________________________

npm init quasar@latest chat-frontend
# Escolher: Vue 3 + TypeScript + Quasar

_______________________________________________________________________________________

npm install @stomp/stompjs

_______________________________________________________________________________________


<!-- ChatInput.vue -->
<template>
  <q-input v-model="message" @keyup.enter="send" />
</template>

<script setup lang="ts">
import { ref } from 'vue';
const message = ref('');
const send = () => console.log('Mensagem enviada:', message.value);
</script>

_______________________________________________________________________________________



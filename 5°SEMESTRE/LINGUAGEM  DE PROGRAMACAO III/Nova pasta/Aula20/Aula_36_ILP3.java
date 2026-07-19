import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-chat") // Endpoint para conexão
                .setAllowedOrigins("*"); // Permite qualquer origem (em dev)
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // Tópicos para broadcast
        registry.setApplicationDestinationPrefixes("/app"); // Prefixo para métodos @MessageMapping
    }
}
_____________________________________________________________________________

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class ChatController {

    @MessageMapping("/chat.send") // Recebe mensagens enviadas para "/app/chat.send"
    @SendTo("/topic/public") // Retransmite para todos inscritos em "/topic/public"
    public Mono<Message> sendMessage(Message message) {
        return Mono.just(message)
                .doOnNext(msg -> msg.setTimestamp(Instant.now()));
    }
}

_____________________________________________________________________________

{
  "destination": "/app/chat.send",
  "content": "Olá WebSockets!",
  "sender": "Postman"
}

_____________________________________________________________________________

@MessageMapping("/chat.private.{userId}")
@SendTo("/topic/private.{userId}")
public Mono<Message> sendPrivateMessage(
    @DestinationVariable String userId,
    Message message
) {
    return Mono.just(message)
            .filter(msg -> !msg.getContent().isBlank())
            .switchIfEmpty(Mono.error(new IllegalArgumentException("Mensagem vazia!")));
}

_____________________________________________________________________________


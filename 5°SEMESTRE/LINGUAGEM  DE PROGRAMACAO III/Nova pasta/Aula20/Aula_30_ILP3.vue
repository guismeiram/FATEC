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
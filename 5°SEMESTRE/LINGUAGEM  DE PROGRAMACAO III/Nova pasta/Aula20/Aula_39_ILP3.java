FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY build/libs/reactive-chat-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

__________________________________________________________


./gradlew build
docker build -t chat-backend .

__________________________________________________________

FROM node:18 as builder
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:alpine
COPY --from=builder /app/dist/spa /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80

__________________________________________________________

server {
    listen 80;
    location / {
        try_files $uri $uri/ /index.html;
    }
    location /ws-chat {
        proxy_pass http://backend:8080;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "Upgrade";
    }
}

__________________________________________________________

version: '3.8'

services:
  postgres:
    image: postgres:14
    environment:
      POSTGRES_PASSWORD: chat123
      POSTGRES_DB: chatdb
    volumes:
      - pgdata:/var/lib/postgresql/data

  backend:
    build: ./backend
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/chatdb
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: chat123
    depends_on:
      - postgres

  frontend:
    build: ./frontend
    ports:
      - "80:80"
    depends_on:
      - backend

volumes:
  pgdata:
  
  __________________________________________________________
  
  docker-compose up --build
  
  __________________________________________________________
  
  # docker-compose.yml
services:
  backend:
    healthcheck:
      test: ["CMD", "curl", "-f", "http://localhost:8080/actuator/health"]
      interval: 10s
      timeout: 5s
      retries: 3

  postgres:
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U postgres"]
      interval: 5s
	  
	  __________________________________________________________
	  
	  # .env
POSTGRES_PASSWORD=supersenha
SPRING_DATASOURCE_PASSWORD=supersenha

__________________________________________________________
@GetMapping("/messages")
public Flux<Message> getMessages(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "50") int size
) {
    return messageRepository.findAll()
        .skip(page * size)
        .take(size);
}


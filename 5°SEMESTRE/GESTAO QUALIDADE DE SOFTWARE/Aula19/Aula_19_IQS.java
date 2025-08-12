# Define a versão do Java que será usada no Heroku
java.runtime.version=17

___________________________________________

# Define o comando de inicialização da aplicação
web: java -jar target/ *.jar --server.port=$PORT 

___________________________________________

heroku login                  # Autentica no CLI do Heroku
heroku create meu-app-java    # Cria um novo app no Heroku
git push heroku main          # Faz deploy do branch main
heroku logs --tail            # Monitora logs em tempo real

___________________________________________

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

___________________________________________

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics  # Habilita endpoints específicos
  endpoint:
    health:
      show-details: always  # Mostra detalhes do health check
	  
___________________________________________


@Component
public class ApiExternaHealthIndicator implements HealthIndicator {
    
    @Override
    public Health health() {
        if (checkApiExterna()) {  // Método que verifica a API externa
            return Health.up().build();  # Status UP se disponível
        }
        return Health.down().withDetail("erro", "API externa indisponível").build();  # Status DOWN com detalhes
    }
}

___________________________________________


curl https://meu-app-java.herokuapp.com/actuator/health
# Resposta esperada: {"status":"UP","components":{"apiExterna":{"status":"UP"},...}}
___________________________________________

@Bean
DataSourceHealthIndicator dbHealth(DataSource dataSource) {
    return new DataSourceHealthIndicator(dataSource, "SELECT 1");  # Query simples para testar conexão
}

___________________________________________

## Como Deployar  
1. Instale o Heroku CLI  
2. `heroku login`  
3. `git push heroku main`  


___________________________________________



	  
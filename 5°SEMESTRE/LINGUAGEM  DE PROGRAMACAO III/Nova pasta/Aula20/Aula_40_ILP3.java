// build.gradle  
implementation 'org.springframework.boot:spring-boot-starter-actuator'  
implementation 'io.micrometer:micrometer-registry-prometheus'  

___________________________________________________________________

# application.yml  
management:  
  endpoints:  
    web:  
      exposure:  
        include: health, prometheus, metrics  
  metrics:  
    tags:  
      application: reactive-chat  
	  
	  ___________________________________________________________________
	  
	  
	  # docker-compose-monitoring.yml  
services:  
  prometheus:  
    image: prom/prometheus  
    ports: ["9090:9090"]  
    volumes:  
      - ./prometheus.yml:/etc/prometheus/prometheus.yml  

  grafana:  
    image: grafana/grafana  
    ports: ["3000:3000"]  
    depends_on: ["prometheus"]  
	
	___________________________________________________________________
	
	scrape_configs:  
  - job_name: 'spring'  
    metrics_path: '/actuator/prometheus'  
    static_configs:  
      - targets: ['backend:8080']  
	  
	  ___________________________________________________________________
	  
	  {  
  "title": "Chat Metrics",  
  "panels": [  
    {  
      "title": "Mensagens por Segundo",  
      "type": "graph",  
      "targets": [{  
        "expr": "rate(messages_processed_total[1m])",  
        "legendFormat": "{{instance}}"  
      }]  
    },  
    {  
      "title": "Conexões WebSocket Ativas",  
      "type": "stat",  
      "targets": [{  
        "expr": "websocket_sessions_active",  
        "legendFormat": "Sessões"  
      }]  
    }  
  ]  
}  

___________________________________________________________________

logging:  
  pattern:  
    console: '{"timestamp":"%d{ISO8601}","level":"%level","message":"%m"}'  
	
	___________________________________________________________________
	
	import * as Sentry from '@sentry/vue';  

Sentry.init({  
  dsn: 'SUA_DSN',  
  integrations: [new Sentry.BrowserTracing()],  
});  

___________________________________________________________________

# docker-compose-monitoring.yml (adicione)  
loki:  
  image: grafana/loki  
  ports: ["3100:3100"]  

promtail:  
  image: grafana/promtail  
  volumes:  
    - /var/log:/var/log  
  command: ["-config.file=/etc/promtail/config.yml"]  
  
  
  ___________________________________________________________________
  
  
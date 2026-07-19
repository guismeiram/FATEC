<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-r2dbc</artifactId>
</dependency>
<dependency>
    <groupId>dev.miku</groupId>
    <artifactId>r2dbc-mysql</artifactId>
</dependency>

____________________________________________________________________

spring:
  r2dbc:
    url: r2dbc:mysql://localhost:3306/reactive_db
    username: user
    password: senha
	

____________________________________________________________________

@Data @NoArgsConstructor @AllArgsConstructor
public class Order {
    @Id 
    private Long id;
    private String customerName;
    private LocalDateTime orderDate;
    private Double totalAmount;
}

____________________________________________________________________

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
    Flux<Order> findByOrderDateAfter(LocalDateTime date);
}

____________________________________________________________________

CREATE DATABASE reactive_db;
CREATE TABLE orders (id BIGINT AUTO_INCREMENT PRIMARY KEY, customer_name VARCHAR(255), order_date DATETIME, total_amount DOUBLE);

____________________________________________________________________

@Bean
public CommandLineRunner initData(OrderRepository repo) {
    return args -> {
        repo.saveAll(List.of(
            new Order(null, "Cliente A", LocalDateTime.now(), 150.0),
            new Order(null, "Cliente B", LocalDateTime.now().minusDays(1), 200.0)
        )).subscribe();  // Subscribe para executar a operação
    };
}


____________________________________________________________________

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository repo;

    @GetMapping
    public Flux<Order> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Mono<Order> create(@RequestBody Order order) {
        return repo.save(order);
    }
}

____________________________________________________________________

@GetMapping("/recent")
public Flux<Order> getRecentOrders() {
    return repo.findByOrderDateAfter(LocalDateTime.now().minusDays(7));
}

____________________________________________________________________

@SpringBootTest
class OrderControllerTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    void shouldReturnOrders() {
        webClient.get().uri("/orders")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(Order.class).hasSize(2);
    }
}

____________________________________________________________________



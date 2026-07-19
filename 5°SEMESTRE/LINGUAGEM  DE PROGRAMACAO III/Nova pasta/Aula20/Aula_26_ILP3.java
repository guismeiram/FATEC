Flux.range(1, 5)
    .map(i -> i * 2)            // Transformação
    .filter(i -> i > 5)         // Filtro
    .subscribe(System.out::println);  // Consumidor
	


________________________________________________________________

spring init --dependencies=webflux,data-r2dbc,h2 reactive-api

________________________________________________________________


spring:
  r2dbc:
    url: r2dbc:h2:mem:///testdb
    username: sa
    password: ""
	
________________________________________________________________

@Data @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id 
    private Long id;
    private String name;
    private double price;
}

________________________________________________________________

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    Flux<Product> findByPriceGreaterThan(double price);
}

________________________________________________________________

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository repository;

    @GetMapping
    public Flux<Product> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> getById(@PathVariable Long id) {
        return repository.findById(id);
    }
}


________________________________________________________________

@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public Flux<Product> streamProducts() {
    return repository.findAll()
        .delayElements(Duration.ofSeconds(1));  // Simula dados chegando em tempo real
}

________________________________________________________________


@SpringBootTest
class ProductControllerTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    void shouldReturnProducts() {
        webClient.get().uri("/products")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(Product.class).hasSize(2);
    }
}

________________________________________________________________


@Test
void shouldStreamProducts() {
    webClient.get().uri("/products/stream")
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.TEXT_EVENT_STREAM)
        .returnResult(Product.class);
}

________________________________________________________________


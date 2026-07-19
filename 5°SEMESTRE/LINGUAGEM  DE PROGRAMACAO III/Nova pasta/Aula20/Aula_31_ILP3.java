@Service
public class ProductService {
    private final ProductRepository repo;

    public Flux<Product> getExpensiveProducts(double minPrice) {
        return repo.findAll()
            .filter(p -> p.getPrice() > minPrice)
            .switchIfEmpty(Mono.error(new NoSuchElementException()));
    }
}

__________________________________________________________________________

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository repo;

    @InjectMocks
    private ProductService service;

    @Test
    void shouldReturnExpensiveProducts() {
        Product p1 = new Product("Notebook", 4500.0);
        Product p2 = new Product("Mouse", 50.0);

        when(repo.findAll()).thenReturn(Flux.just(p1, p2));

        StepVerifier.create(service.getExpensiveProducts(1000.0))
            .expectNext(p1)  // Notebook é caro
            .expectComplete()
            .verify();
    }

    @Test
    void shouldErrorWhenNoProductsFound() {
        when(repo.findAll()).thenReturn(Flux.empty());

        StepVerifier.create(service.getExpensiveProducts(1000.0))
            .expectError(NoSuchElementException.class)
            .verify();
    }
}

__________________________________________________________________________

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository repo;

    @InjectMocks
    private ProductService service;

    @Test
    void shouldReturnExpensiveProducts() {
        Product p1 = new Product("Notebook", 4500.0);
        Product p2 = new Product("Mouse", 50.0);

        when(repo.findAll()).thenReturn(Flux.just(p1, p2));

        StepVerifier.create(service.getExpensiveProducts(1000.0))
            .expectNext(p1)  // Notebook é caro
            .expectComplete()
            .verify();
    }

    @Test
    void shouldErrorWhenNoProductsFound() {
        when(repo.findAll()).thenReturn(Flux.empty());

        StepVerifier.create(service.getExpensiveProducts(1000.0))
            .expectError(NoSuchElementException.class)
            .verify();
    }
}

__________________________________________________________________________


@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/expensive")
    public Flux<Product> getExpensive(@RequestParam double minPrice) {
        return productService.getExpensiveProducts(minPrice);
    }
}

__________________________________________________________________________

@SpringBootTest
@AutoConfigureWebTestClient
class ProductControllerTest {
    @Autowired
    private WebTestClient webClient;

    @MockBean
    private ProductService service;

    @Test
    void shouldReturnExpensiveProducts() {
        Product p = new Product("Notebook", 4500.0);
        when(service.getExpensiveProducts(1000.0)).thenReturn(Flux.just(p));

        webClient.get()
            .uri("/products/expensive?minPrice=1000")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(Product.class).contains(p);
    }
}

__________________________________________________________________________

public Mono<Alert> checkPrice(Product product, double maxPrice) {
    return Mono.just(product)
        .delayElement(Duration.ofSeconds(1))  // Simula processamento
        .map(p -> p.getPrice() > maxPrice 
            ? new Alert("Preço alto!") 
            : new Alert("Preço OK"));
}

__________________________________________________________________________

@Test
void shouldCheckPriceInVirtualTime() {
    // Configura o tempo virtual
    StepVerifier.withVirtualTime(() -> 
            service.checkPrice(new Product("Notebook", 4500.0), 1000.0))
        .expectSubscription()
        .thenAwait(Duration.ofSeconds(1))  // Avança o tempo virtual
        .expectNextMatches(alert -> alert.getMessage().contains("alto"))
        .expectComplete()
        .verify();
}

__________________________________________________________________________



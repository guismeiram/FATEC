spring init --dependencies=web,data-jpa,mysql,security,lombok ecommerce-backend

______________________________________________________________________

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String imageUrl;
}

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password; // Hash com BCrypt
    @Enumerated(EnumType.STRING)
    private Role role;
}

______________________________________________________________________

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository repository;

    @GetMapping
    public List<Product> getAll() {
        return repository.findAll();
    }
}

______________________________________________________________________



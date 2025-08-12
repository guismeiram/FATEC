// Repositório com suporte a paginação
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Método que retorna todos produtos com paginação
    // Page<T> contém os itens da página atual + metadados de paginação
    Page<Product> findAll(Pageable pageable);
}
___________________________________________________________

# Configuração de tamanho máximo para upload de arquivos
# Tamanho máximo do arquivo individual (10MB)
spring.servlet.multipart.max-file-size=10MB
# Tamanho máximo total da requisição multipart (10MB)
spring.servlet.multipart.max-request-size=10MB

___________________________________________________________

// Controller para upload de arquivos
@RestController
@RequestMapping("/api/files")
public class FileController {
    private final Path root = Paths.get("uploads"); // Pasta onde os arquivos serão salvos

    @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        try {
            // Cria o diretório se não existir
            if (!Files.exists(root)) Files.createDirectory(root);
            
            // Gera nome único para o arquivo
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            
            // Salva o arquivo no disco
            Files.copy(file.getInputStream(), root.resolve(filename));
            
            return ResponseEntity.ok(filename);
        } catch (IOException e) {
            throw new RuntimeException("Falha no upload: " + e.getMessage());
        }
    }
}

___________________________________________________________

// Configuração para servir arquivos estáticos
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Mapeia requisições para /uploads/** para a pasta física uploads/
        registry.addResourceHandler("/uploads/**")
            .addResourceLocations("file:uploads/");
    }
}

___________________________________________________________

// Serviço Angular para upload de arquivos
@Injectable({ providedIn: 'root' })
export class FileService {
    private apiUrl = 'http://localhost:8080/api/files'; // URL do endpoint

    constructor(private http: HttpClient) {}

    // Método para enviar arquivo
    upload(file: File) {
        const formData = new FormData(); // Cria FormData
        formData.append('file', file); // Adiciona arquivo
        return this.http.post<string>(this.apiUrl, formData); // Faz requisição POST
    }
}

___________________________________________________________

// Componente de upload Angular
export class UploadComponent {
    selectedFile?: File; // Arquivo selecionado

    // Método chamado quando seleciona um arquivo
    onFileSelected(event: any) {
        this.selectedFile = event.target.files[0]; // Pega o primeiro arquivo
    }

    // Método para enviar o arquivo
    upload() {
        if (this.selectedFile) {
            this.fileService.upload(this.selectedFile).subscribe({
                next: (filename) => alert(`Arquivo ${filename} salvo!`),
                error: (err) => alert('Erro no upload!')
            });
        }
    }
}

___________________________________________________________

<!-- Template do componente de upload -->
<input type="file" (change)="onFileSelected($event)"> <!-- Input para selecionar arquivo -->
<button (click)="upload()">Enviar</button> <!-- Botão para disparar upload -->

___________________________________________________________

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);
}

___________________________________________________________

// Controller para produtos com paginação
@GetMapping
public Page<Product> getAll(
    @RequestParam(defaultValue = "0") int page, // Número da página (padrão 0)
    @RequestParam(defaultValue = "10") int size // Tamanho da página (padrão 10)
) {
    // Retorna página de produtos
    return repository.findAll(PageRequest.of(page, size));
}

___________________________________________________________

# Comando para adicionar Angular Material ao projeto
ng add @angular/material

___________________________________________________________

<!-- Tabela com paginação do Angular Material -->
<table mat-table [dataSource]="dataSource">
    <!-- Definição das colunas -->
</table>
<!-- Componente de paginação -->
<mat-paginator [pageSizeOptions]="[5, 10, 20]"></mat-paginator>

___________________________________________________________

// Configuração da tabela paginada
dataSource = new MatTableDataSource<Product>(); // Fonte de dados
@ViewChild(MatPaginator) paginator!: MatPaginator; // Referência ao paginador

ngOnInit() {
    // Carrega dados iniciais
    this.productService.getAll(0, 10).subscribe(products => {
        this.dataSource.data = products.content; // Preenche tabela
        this.dataSource.paginator = this.paginator; // Configura paginação
    });
}

___________________________________________________________


✅ Upload funcional
✅ Paginação backend + frontend
✅ Pronto para testes automatizados


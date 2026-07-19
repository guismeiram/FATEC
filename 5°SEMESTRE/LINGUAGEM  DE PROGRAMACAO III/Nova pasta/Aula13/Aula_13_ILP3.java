@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository repository;
    
    @InjectMocks
    private ProductService service;

    @Test
    void shouldReturnProductWhenValidId() {
        // Arrange
        Product mockProduct = new Product("Notebook", 4500.0);
        when(repository.findById(1L)).thenReturn(Optional.of(mockProduct));

        // Act
        Product result = service.findById(1L);

        // Assert
        assertEquals("Notebook", result.getName());
        verify(repository, times(1)).findById(1L);
    }
}
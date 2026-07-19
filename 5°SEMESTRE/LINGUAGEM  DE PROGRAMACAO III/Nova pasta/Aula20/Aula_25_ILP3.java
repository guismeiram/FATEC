// Criação direta
Thread vThread = Thread.startVirtualThread(() -> System.out.println("Hello from virtual thread!"));

// Via ExecutorService
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> System.out.println("Task 1"));
    executor.submit(() -> System.out.println("Task 2"));
}

__________________________________________________________________

// instanceof simplificado (Java 16+)
if (obj instanceof String s) {
    System.out.println(s.length());
}

// Switch com patterns (Java 21+)
String message = switch (obj) {
    case Integer i -> "Número: " + i;
    case String s && !s.isEmpty() -> "Texto: " + s;  // Guarded pattern
    case null -> "Null!";
    default -> "Desconhecido";
};

__________________________________________________________________


java -version  # Deve mostrar >= 21

__________________________________________________________________

<properties>
    <java.version>21</java.version>
</properties>


__________________________________________________________________

spring.threads.virtual.enabled=true

__________________________________________________________________


@GetMapping("/tasks")
public List<Task> getAllTasks() throws InterruptedException {
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
        Future<List<Task>> tasksFuture = executor.submit(() -> taskRepository.findAll());
        Future<Stats> statsFuture = executor.submit(() -> statsService.getStats());
        
        return tasksFuture.get()  // Bloqueia até concluir
            .stream()
            .peek(task -> task.setStats(statsFuture.get()))
            .toList();
    }
}

__________________________________________________________________

public String processData(Object input) {
    return switch (input) {
        case User u -> "User: " + u.name();
        case Order o -> "Order value: " + o.value();
        case null, default -> "Invalid data";
    };
}

__________________________________________________________________


public sealed interface Shape permits Circle, Rectangle {
    double area();
}

public double calculateTotalArea(List<Shape> shapes) {
    return shapes.stream()
        .mapToDouble(s -> switch (s) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Rectangle r -> r.width() * r.height();
        })
        .sum();
}

__________________________________________________________________


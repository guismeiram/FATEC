package br.com.guismeiram.aula04.database;

public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {}

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public static void main(String[] args) {
        // Testando o Singleton
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        DatabaseConnection connection3 = DatabaseConnection.getInstance();

        // Verificando se todas as referências apontam para a mesma instância
        System.out.println("connection1 == connection2: " + (connection1 == connection2));
        System.out.println("connection2 == connection3: " + (connection2 == connection3));
        System.out.println("connection1 == connection3: " + (connection1 == connection3));

        // Verificando o hashcode das instâncias (deve ser o mesmo)
        System.out.println("\nHashCodes:");
        System.out.println("connection1: " + connection1.hashCode());
        System.out.println("connection2: " + connection2.hashCode());
        System.out.println("connection3: " + connection3.hashCode());

        // Testando em threads diferentes
        System.out.println("\nTestando com múltiplas threads:");

        Thread thread1 = new Thread(() -> {
            DatabaseConnection threadConnection = DatabaseConnection.getInstance();
            System.out.println("Thread 1 - HashCode: " + threadConnection.hashCode());
        });

        Thread thread2 = new Thread(() -> {
            DatabaseConnection threadConnection = DatabaseConnection.getInstance();
            System.out.println("Thread 2 - HashCode: " + threadConnection.hashCode());
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nTeste concluído! Todas as instâncias são iguais.");
    }

}

package hw2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Task3Test {
    private Task3.ConnectionManager faultyManager;
    private Task3.PopularCommandExecutor executor;

    @BeforeEach
    public void setUp() {
        // Инициализация менеджеров соединений
        Task3.ConnectionManager defaultManager = new Task3.DefaultConnectionManager(0.2); // Вероятность проблемного соединения: 20%
        faultyManager = new Task3.FaultyConnectionManager();

        // Инициализация исполнителя команд
        executor = new Task3.PopularCommandExecutor(defaultManager, 3); // Максимальное количество попыток: 3
    }

    @Test
    public void testUpdatePackagesWithStableConnection() {
        // Попытка выполнить команду со стабильным соединением, которое успешно
        executor.updatePackages();
        // Если команда успешно выполнена, тест будет успешным
    }

    @Test
    public void testUpdatePackagesWithFaultyConnection() {
        // Попытка выполнить команду с проблемным соединением, которое всегда выбрасывает исключение
        executor = new Task3.PopularCommandExecutor(faultyManager, 3); // Используем проблемный менеджер

    }

    @Test
    public void testUpdatePackagesWithMaxAttemptsExceeded() {
        // Попытка выполнить команду с проблемным соединением, где максимальное количество попыток превышено
        executor = new Task3.PopularCommandExecutor(faultyManager, 2); // Максимальное количество попыток: 2

        Task3.ConnectionException e = assertThrows(Task3.ConnectionException.class, () -> executor.updatePackages());

        assertEquals("Failed to execute command after 2 attempts", e.getMessage());
    }
}

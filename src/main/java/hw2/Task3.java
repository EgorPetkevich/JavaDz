package hw2;
import java.util.Random;
public class Task3 {
    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    // Определение интерфейса ConnectionManager для управления соединениями
    public interface ConnectionManager {
        Connection getConnection();
    }

    // Исключение для обработки ошибок соединения
    public static class ConnectionException extends RuntimeException {
        public ConnectionException(String message) {
            super(message);
        }

        public ConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // Определение интерфейсов StableConnection и FaultyConnection, расширяющих интерфейс Connection
    public interface StableConnection extends Connection {
    }

    public interface FaultyConnection extends Connection {
    }

    // Реализация ConnectionManager, который может возвращать стабильное или проблемное соединение
    public static class DefaultConnectionManager implements ConnectionManager {
        private final double faultyConnectionProbability;
        private final Random random = new Random();

        public DefaultConnectionManager(double faultyConnectionProbability) {
            this.faultyConnectionProbability = faultyConnectionProbability;
        }

        @Override
        public Connection getConnection() {
            // С вероятностью faultyConnectionProbability возвращаем проблемное соединение
            if (random.nextDouble() < faultyConnectionProbability) {
                return new FaultyConnectionImpl();
            } else {
                return new StableConnectionImpl();
            }
        }

        // Реализация стабильного соединения
        private static class StableConnectionImpl implements StableConnection {
            @Override
            public void execute(String command) {
                // Реализация выполнения команды для стабильного соединения
            }

            @Override
            public void close() {
                // Реализация закрытия стабильного соединения
            }
        }

        // Реализация проблемного соединения
        private static class FaultyConnectionImpl implements FaultyConnection {
            @Override
            public void execute(String command) {
                // Реализация выполнения команды для проблемного соединения
                throw new ConnectionException("Connection failed");
            }

            @Override
            public void close() {
                // Реализация закрытия проблемного соединения
            }
        }
    }

    // Реализация ConnectionManager, который всегда возвращает проблемное соединение
    public static class FaultyConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            return new FaultyConnectionImpl();
        }

        // Реализация проблемного соединения
        private static class FaultyConnectionImpl implements FaultyConnection {
            @Override
            public void execute(String command) {
                // Реализация выполнения команды для проблемного соединения
                throw new ConnectionException("Connection failed");
            }

            @Override
            public void close() {
                // Реализация закрытия проблемного соединения
            }
        }
    }

    // Класс для выполнения популярных команд
    public static class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        // Метод для выполнения команды "apt update && apt upgrade -y"
        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        // Метод для попытки выполнения команды с ограниченным числом попыток
        public void tryExecute(String command) {
            int attempts = 0;
            Exception lastException = null;

            while (attempts < maxAttempts) {
                try (Connection connection = manager.getConnection()) {
                    connection.execute(command);
                    return;
                } catch (ConnectionException e) {
                    lastException = e;
                } catch (Exception e) {
                    // Обработка исключения, которое произошло при закрытии ресурса
                    // Это может включать в себя вывод информации об ошибке или логирование
                    lastException = e;
                } finally {
                    attempts++;
                }
            }

            // Бросаем исключение, если команду не удалось выполнить
            if (lastException != null) {
                throw new ConnectionException("Failed to execute command after " + maxAttempts + " attempts", lastException);
            } else {
                throw new ConnectionException("Failed to execute command after " + maxAttempts + " attempts");
            }
        }
    }
    public static void main(String[] args) {
    }
}

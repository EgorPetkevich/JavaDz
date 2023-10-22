package hw2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Task4Test {
    @Test
    void callingInfoShouldReturnCallingInfo() {
        // Подготовка данных

        // Действие: вызов метода, который мы тестируем
        Task4.CallingInfo info = Task4.CallingInfoExtractor.callingInfo();

        //Утверждение: проверка результата
        assertNotNull(info);
        assertNotNull(info.className());
        assertNotNull(info.methodName());
    }
}

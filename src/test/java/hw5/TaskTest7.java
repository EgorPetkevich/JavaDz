package hw5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskTest7 {
    @Test
    void testValidString() {
        assertTrue(Task7.isValidString("010101"));

    }

    @Test
    void testInvalidString() {

        assertFalse(Task7.isValidString(""));
        assertFalse(Task7.isValidString("11"));
    }

}

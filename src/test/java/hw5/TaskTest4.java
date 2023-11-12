package hw5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskTest4 {
    @Test
    void testValidPassword() {
        assertTrue(Task4.validatePassword("securePassword!"));
    }

    @Test
    void testInvalidPassword() {
        assertFalse(Task4.validatePassword("weakPassword"));
    }

    @Test
    void testPasswordWithoutSpecialCharacter() {
        assertFalse(Task4.validatePassword("noSpecialCharacter"));
    }

    @Test
    void testPasswordWithMultipleSpecialCharacters() {
        assertTrue(Task4.validatePassword("strongPassword@2023"));
    }

    @Test
    void testEmptyPassword() {
        assertFalse(Task4.validatePassword(""));
    }

}

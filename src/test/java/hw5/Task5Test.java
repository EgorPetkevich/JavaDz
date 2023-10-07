package hw5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
public class Task5Test {
    @Test
    public void testIsPalindromeDescendantWithPalindrome() {
        assertTrue(Task5.isPalindromeDescendant(11211230)); // Ожидаемый результат: true
        assertTrue(Task5.isPalindromeDescendant(13001120)); // Ожидаемый результат: true
        assertTrue(Task5.isPalindromeDescendant(23336014)); // Ожидаемый результат: true
        assertTrue(Task5.isPalindromeDescendant(11)); // Ожидаемый результат: true
        assertTrue(Task5.isPalindromeDescendant(121)); // Ожидаемый результат: true
    }


    @Test
    public void testIsPalindromeDescendantWithNonPalindrome() {
        assertTrue(Task5.isPalindromeDescendant(12345)); // Ожидаемый результат: true
        assertTrue(Task5.isPalindromeDescendant(54321)); // Ожидаемый результат: true
        assertTrue(Task5.isPalindromeDescendant(987654321)); // Ожидаемый результат: true
    }

    @Test
    public void testIsPalindromeDescendantWithSingleDigit() {
        assertTrue(Task5.isPalindromeDescendant(7)); // Ожидаемый результат: true (само однозначное число считается палиндромом)
    }

    @Test
    public void testIsPalindromeDescendantWithEmptyString() {
        assertTrue(Task5.isPalindromeDescendant(0)); // Ожидаемый результат: true (пустое число считается палиндромом)
    }


}

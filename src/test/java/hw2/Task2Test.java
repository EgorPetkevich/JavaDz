package hw2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class Task2Test {

    @Test
    public void testCountDigitsPositiveNumber() {
        assertEquals(4,Task2.countDigits(4666));
        assertEquals(3,Task2.countDigits(544));
        assertEquals(1,Task2.countDigits(0));
        assertEquals(5,Task2.countDigits(12345));
    }

    @Test
    public void testCountDigitsNegativeNumber() {
        assertEquals(4,Task2.countDigits(-4666));
        assertEquals(3,Task2.countDigits(-544));
        assertEquals(5,Task2.countDigits(-12345));
    }

    @Test
    public void testCountDigitsZero() {
        assertEquals(1,Task2.countDigits(0));
    }
}

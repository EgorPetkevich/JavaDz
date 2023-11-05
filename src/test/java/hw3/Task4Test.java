package hw3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class Task4Test {
    @Test
    public void testConvertToRoman() {
        Assertions.assertEquals("II",Task4.convertToRoman(2));
        Assertions.assertEquals("XII", Task4.convertToRoman(12));
        Assertions.assertEquals("XVI", Task4.convertToRoman(16));
    }
}

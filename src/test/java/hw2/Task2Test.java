package hw2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class Task2Test {
    @Test
    public void RectangleAreaTest() {
        var rectangle = new Task2.Rectangle(4,7);
        var result = rectangle.area();
        assertEquals(28, result);
    }
    @Test
    public void SquareAreaTest() {
        var square = new Task2.Square(4, 4);
        var result = square.area();
        assertEquals(16, result);
    }
}

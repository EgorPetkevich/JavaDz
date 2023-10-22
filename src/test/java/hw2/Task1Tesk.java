package hw2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Task1Tesk {
    @Test
    public void testConstantEvaluate() {
        Task1.Expr constant = new Task1.Constant(5.0);
        double result = constant.evaluate();
        assertEquals(5.0, result, 0.001); // Проверка, что значение константы равно 5.0
    }

    @Test
    public void testNegateEvaluate() {
        Task1.Expr operand = new Task1.Constant(3.0);
        Task1.Expr negate = new Task1.Negate(operand);
        double result = negate.evaluate();
        assertEquals(-3.0, result, 0.001); // Проверка, что отрицание числа работает правильно
    }

    @Test
    public void testExponentEvaluate() {
        Task1.Expr base = new Task1.Constant(2.0);
        Task1.Expr exponent = new Task1.Exponent(base, 3);
        double result = exponent.evaluate();
        assertEquals(8.0, result, 0.001); // Проверка возведения в степень
    }

    @Test
    public void testAdditionEvaluate() {
        Task1.Expr left = new Task1.Constant(2.0);
        Task1.Expr right = new Task1.Constant(3.0);
        Task1.Expr addition = new Task1.Addition(left, right);
        double result = addition.evaluate();
        assertEquals(5.0, result, 0.001); // Проверка сложения
    }

    @Test
    public void testMultiplicationEvaluate() {
        Task1.Expr left = new Task1.Constant(2.0);
        Task1.Expr right = new Task1.Constant(3.0);
        Task1.Expr multiplication = new Task1.Multiplication(left, right);
        double result = multiplication.evaluate();
        assertEquals(6.0, result, 0.001); // Проверка умножения
    }
}

package hw5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskTest8 {
    @Test
    void testIsOddLength() {

        assertTrue(Task8.isOddLength("010101"));

    }

    @Test
    void testStartsWithZeroOddLengthOrStartsWithOneEvenLength() {
        assertTrue(Task8.startsWithZeroOddLengthOrStartsWithOneEvenLength("010101"));

        assertFalse(Task8.startsWithZeroOddLengthOrStartsWithOneEvenLength("01010"));
        assertFalse(Task8.startsWithZeroOddLengthOrStartsWithOneEvenLength("11010"));
    }

    @Test
    void testCountOfZerosMultipleOfThree() {
        assertTrue(Task8.countOfZerosMultipleOfThree("100100100"));
        assertFalse(Task8.countOfZerosMultipleOfThree("100100"));
    }

    @Test
    void testNotElevenOr111() {
        assertTrue(Task8.notElevenOr111("010101"));
        assertFalse(Task8.notElevenOr111("11"));
        assertFalse(Task8.notElevenOr111("111"));
    }

    @Test
    void testEveryOddCharacterIsOne() {
        assertTrue(Task8.everyOddCharacterIsOne("010101"));
        assertFalse(Task8.everyOddCharacterIsOne("110101"));
    }

    @Test
    void testAtLeastTwoZerosAtMostOneOne() {

        assertFalse(Task8.atLeastTwoZerosAtMostOneOne("1001"));
        assertFalse(Task8.atLeastTwoZerosAtMostOneOne("111"));
    }

    @Test
    void testNoConsecutiveOnes() {

        assertFalse(Task8.noConsecutiveOnes("1101"));
    }

}

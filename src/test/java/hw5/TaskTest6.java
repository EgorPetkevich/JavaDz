package hw5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskTest6 {
    @Test
    void testIsSubsequence() {
        assertTrue(Task6.isSubsequence("abc", "achfdbaabgabcaabg"));
        assertTrue(Task6.isSubsequence("ab", "achfdbaabgabcaabg"));
        assertTrue(Task6.isSubsequence("aab", "achfdbaabgabcaabg"));
    }

    @Test
    void testIsNotSubsequence() {
        assertFalse(Task6.isSubsequence("xyz", "achfdbaabgabcaabg"));
        assertFalse(Task6.isSubsequence("bcd", "achfdbaabgabcaabg"));
    }

    @Test
    void testEmptyString() {
        assertTrue(Task6.isSubsequence("", "achfdbaabgabcaabg"));
    }

    @Test
    void testEmptyTargetString() {
        assertFalse(Task6.isSubsequence("abc", ""));
    }

    @Test
    void testBothEmptyStrings() {
        assertTrue(Task6.isSubsequence("", ""));
    }

}

package hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskTest1 {
    @Test
    void testCalculateSessionTime() {
        String session1 = "2022-03-12, 20:00 - 2022-03-12, 23:00";
        String session2 = "2022-04-01, 21:00 - 2022-04-02, 00:00";

        long result1 = Task1.calculateSessionTime(session1);
        long result2 = Task1.calculateSessionTime(session2);

        assertEquals(3 * 60 * 60 * 1000, result1); // 3 hours in milliseconds
        assertEquals(3 * 60 * 60 * 1000, result2); // 3 hours in milliseconds
    }

}

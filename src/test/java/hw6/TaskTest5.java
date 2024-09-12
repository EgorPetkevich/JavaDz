package hw6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskTest5 {
    @Test
    void testHackerNewsTopStories() {
        Task5 task5 = new Task5();
        long[] topStories = task5.hackerNewsTopStories();

        assertNotNull(topStories);
        assertTrue(topStories.length > 0);
    }

    @Test
    void testNews() {
        Task5 task5 = new Task5();
        long newsId = 37570037;
        String newsTitle = task5.news(newsId);

        assertNotNull(newsTitle);
        assertFalse(newsTitle.isEmpty());
    }

    @Test
    void testNewsWithInvalidId() {
        Task5 task5 = new Task5();
        long invalidNewsId = -1;
        String newsTitle = task5.news(invalidNewsId);

        assertEquals("Unable to fetch news title", newsTitle);
    }
}

package project2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

public class EllersTest {
    @Test
    public void testMakeMaze() {
        Ellers ellers = new Ellers(4, 4);
        ellers.makeMaze();
        char[][] maze = ellers.getMaze();

        // Check that the maze is not null
        assertNotNull(maze);

        // Check that the dimensions of the maze are correct
        assertEquals(ellers.rows, maze.length);
        assertEquals(ellers.cols, maze[0].length);

        // Check that the maze is not empty
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                assertNotEquals('\0', maze[i][j]);
            }
        }
    }

}

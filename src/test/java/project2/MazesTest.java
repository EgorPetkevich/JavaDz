package project2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
public class MazesTest {

    @Test
    public void testMazeGenerationAndSolving() {
        Ellers ell = new Ellers(4, 4);
        ell.makeMaze();

        // Check that the maze is not null
        assertNotNull(ell.getMaze());

        Solver ellSol = new Solver(ell.getMaze());
        ellSol.solveMaze();

        // Check that the solution is not null
        assertNotNull(ellSol.getSolution());
    }

}

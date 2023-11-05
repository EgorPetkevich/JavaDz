package project1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class Project1Test {
    private Project1 game;

    @BeforeEach
    public void setup() {
        game = new Project1();
    }

    @Test
    public void testIsInputValid() {
        assertTrue(game.isInputValid("a"));
        assertFalse(game.isInputValid("ab"));
        assertFalse(game.isInputValid(""));
    }

    @Test
    public void testIsGameWon() {
        game.guessedWord = "hello".toCharArray();
        game.wordToGuess = "hello";
        assertTrue(game.isGameWon());

        game.guessedWord = "world".toCharArray();
        game.wordToGuess = "world";
        assertTrue(game.isGameWon());

        game.guessedWord = "java".toCharArray();
        game.wordToGuess = "java";
        assertTrue(game.isGameWon());

        game.guessedWord = "h*llo".toCharArray();
        game.wordToGuess = "hello";
        assertFalse(game.isGameWon());
    }

    @Test
    public void testHandleMistake() {
        game.handleMistake();
        assertEquals(1, game.mistakes);

        game.handleMistake();
        assertEquals(2, game.mistakes);
    }
    @Test
    public void testInvalidWordLength() {
        assertTrue(game.isInputValid("a")); // Слово слишком короткое
        assertFalse(game.isInputValid("test")); // Слово средней длины
        assertFalse(game.isInputValid("verylongworda")); // Слово слишком длинное
    }
}

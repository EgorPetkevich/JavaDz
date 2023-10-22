package project1;

import java.util.Random;
import java.util.Scanner;

public class Project1 {
    private static final String[] WORDS = {"hello", "world", "java"};
    private static final int MAX_MISTAKES = 5;

    String wordToGuess;
    char[] guessedWord;
    int mistakes;

    public Project1() {
        wordToGuess = getRandomWord(WORDS);
        guessedWord = new char[wordToGuess.length()];
        mistakes = 0;
        initializeGuessedWord();
    }

    private void initializeGuessedWord() {
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord[i] = '*';
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Viselitsa!");
        printGameState();

        while (mistakes < MAX_MISTAKES) {
            System.out.print("Guess a letter or type 'surrender' to give up: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("surrender")) {
                surrenderGame();
                break;
            }

            if (!isInputValid(input)) {
                System.out.println("Invalid input. Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);

            if (wordToGuess.contains(String.valueOf(guess))) {
                updateGuessedWord(guess);
                if (isGameWon()) {
                    printGameState();
                    System.out.println("You won!");
                    break;
                }
            } else {
                handleMistake();
            }
        }

        if (mistakes == MAX_MISTAKES) {
            printGameState();
            System.out.println("You lost! The word was: " + wordToGuess);
        }
    }

    private void surrenderGame() {
        System.out.println("You surrendered. The word was: " + wordToGuess);
    }

    boolean isInputValid(String input) {
        return input.length() == 1;
    }

     void updateGuessedWord(char guess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedWord[i] = guess;
            }
        }
    }

    boolean isGameWon() {
        return String.valueOf(guessedWord).equals(wordToGuess);
    }

    void handleMistake() {
        mistakes++;
        printGameState();
        System.out.println("Missed, mistake " + mistakes + " out of " + MAX_MISTAKES + ".");
    }

    private void printGameState() {
        System.out.println("\n> The word: " + String.valueOf(guessedWord));
        System.out.println("\n> Missed, mistake " + mistakes + " out of " + MAX_MISTAKES + ".\n");
    }

    public static void main(String[] args) {
        Project1 game = new Project1();
        game.play();
    }

    private static String getRandomWord(String[] words) {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}

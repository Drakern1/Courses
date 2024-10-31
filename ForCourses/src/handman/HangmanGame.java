package handman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String[] RUSSIAN_WORDS = {"программа", "игра", "виселица", "разработка", "кириллица"};
    private static final String[] ENGLISH_WORDS = {"program", "game", "hangman", "development", "cyrillic"};
    private static final int MAX_LIVES = 6;

    private Word word;
    private Player player;
    private char baseChar;
    private int alphabetSize;

    public HangmanGame(String language) {
        Random random = new Random();
        String randomWord;
        if (language.equals("ru")) {
            randomWord = RUSSIAN_WORDS[random.nextInt(RUSSIAN_WORDS.length)];
            player = new Player(MAX_LIVES, 33); // 33 буквы в русском алфавите
            baseChar = 'а'; // База для русского алфавита
            alphabetSize = 33;
        } else {
            randomWord = ENGLISH_WORDS[random.nextInt(ENGLISH_WORDS.length)];
            player = new Player(MAX_LIVES, 26); // 26 букв в английском алфавите
            baseChar = 'a'; // База для английского алфавита
            alphabetSize = 26;
        }
        word = new Word(randomWord);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Добро пожаловать в игру 'Виселица'!");

        while (player.getLives() > 0 && word.getMaskedWord(player.getGuessedLetters(), alphabetSize, baseChar).contains("_")) {
            System.out.println("Слово: " + word.getMaskedWord(player.getGuessedLetters(), alphabetSize, baseChar));
            System.out.println("У вас осталось жизней: " + player.getLives());
            System.out.print("Введите букву: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if ((guess >= 'а' && guess <= 'я') || (guess >= 'a' && guess <= 'z')) {
                if (player.hasGuessedLetter(guess, baseChar)) {
                    System.out.println("Вы уже угадывали эту букву. Попробуйте другую.");
                    continue;
                }

                player.guessLetter(guess, baseChar);

                if (word.getWordToGuess().indexOf(guess) < 0) {
                    player.loseLife();
                    System.out.println("Нет такой буквы!");
                }
            } else {
                System.out.println("Пожалуйста, введите букву из русского или английского алфавита.");
            }
        }

        if (player.getLives() == 0) {
            System.out.println("Вы проиграли! Загаданное слово: " + word.getWordToGuess());
        } else {
            System.out.println("Поздравляем! Вы угадали слово: " + word.getWordToGuess());
        }

        scanner.close();
    }
}

package handman;

public class Player {
    private int lives;
    private boolean[] guessedLetters;

    public Player(int maxLives, int alphabetSize) {
        this.lives = maxLives;
        this.guessedLetters = new boolean[alphabetSize];
    }

    public int getLives() {
        return lives;
    }

    public void loseLife() {
        lives--;
    }

    public boolean hasGuessedLetter(char letter, char baseChar) {
        return guessedLetters[letter - baseChar];
    }

    public void guessLetter(char letter, char baseChar) {
        guessedLetters[letter - baseChar] = true;
    }

    public boolean[] getGuessedLetters() {
        return guessedLetters;
    }
}

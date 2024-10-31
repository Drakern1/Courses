package handman;

public class Word {
    private String wordToGuess;

    public Word(String word) {
        this.wordToGuess = word;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public String getMaskedWord(boolean[] guessedLetters, int alphabetSize, char baseChar) {
        StringBuilder maskedWord = new StringBuilder();
        for (char letter : wordToGuess.toCharArray()) {
            if (guessedLetters[letter - baseChar]) {
                maskedWord.append(letter);
            } else {
                maskedWord.append('_');
            }
        }
        return maskedWord.toString();
    }
}

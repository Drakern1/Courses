package passwordGenerator;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+<>?";

    private static final String ALL_CHARS = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARS;
    private SecureRandom random;

    public PasswordGenerator() {
        this.random = new SecureRandom();
    }

    public String generatePassword(int length) {
        if (length < 8 || length > 12) {
            throw new IllegalArgumentException("Длина пароля должна быть от 8 до 12 символов.");
        }
        StringBuilder password = new StringBuilder(length);
        password.append(getRandomCharacter(LOWERCASE));
        password.append(getRandomCharacter(UPPERCASE));
        password.append(getRandomCharacter(DIGITS));
        password.append(getRandomCharacter(SPECIAL_CHARS));

        for (int i = 4; i < length; i++) {
            password.append(getRandomCharacter(ALL_CHARS));
        }
        return shuffleString(password.toString());
    }

    private char getRandomCharacter(String source) {
        return source.charAt(random.nextInt(source.length()));
    }

    private String shuffleString(String input) {
        List<Character> characters = Arrays.asList(input.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        Collections.shuffle(characters);
        StringBuilder shuffled = new StringBuilder(input.length());
        for (char c : characters) {
            shuffled.append(c);
        }
        return shuffled.toString();
    }
}

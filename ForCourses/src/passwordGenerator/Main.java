package passwordGenerator;

public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        int length = userInput.getPasswordLength();
        try {
            String password = passwordGenerator.generatePassword(length);
            System.out.println("Сгенерированный пароль: " + password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            userInput.close();
        }
    }
}

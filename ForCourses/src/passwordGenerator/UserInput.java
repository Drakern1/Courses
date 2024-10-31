package passwordGenerator;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public int getPasswordLength() {
        System.out.print("Введите желаемую длину пароля (от 8 до 12): ");
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}

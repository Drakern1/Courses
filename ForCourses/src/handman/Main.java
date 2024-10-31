package handman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.print("Выберите язык (ru/en): ");
        String language = scanner.nextLine().toLowerCase();

        while (!language.equals("ru") && !language.equals("en")) {
            System.out.print("Неверный ввод. Пожалуйста, выберите язык (ru/en): ");
            language = scanner.nextLine().toLowerCase();
        }

        HangmanGame game = new HangmanGame(language);
        game.start();
    }
}

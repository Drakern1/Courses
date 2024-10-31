package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Добро пожаловать в конвертер валют!");
        System.out.print("Введите сумму в USD: ");

        double amount = scanner.nextDouble();

        System.out.println("Доступные валюты для конвертации: " + converter.getAvailableCurrencies().keySet());
        System.out.print("Выберите валюту для конвертации: ");
        String targetCurrency = scanner.next().toUpperCase();

        try {
            double convertedAmount = converter.convert(amount, targetCurrency);
            System.out.printf("%.2f USD = %.2f %s%n", amount, convertedAmount, targetCurrency);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

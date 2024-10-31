package converter;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private Map<String, Currency> currencies;

    public CurrencyConverter() {
        currencies = new HashMap<>();
        initializeCurrencies();
    }

    private void initializeCurrencies() {
        currencies.put("USD", new Currency("USD", 1.0));
        currencies.put("EUR", new Currency("EUR", 0.85));
        currencies.put("RUB", new Currency("RUB", 74.0));
        currencies.put("JPY", new Currency("JPY", 110.0));
        currencies.put("GBP", new Currency("GBP", 0.75));
    }

    public double convert(double amount, String targetCurrencyCode) {
        Currency targetCurrency = currencies.get(targetCurrencyCode);
        if (targetCurrency != null) {
            return amount * targetCurrency.getExchangeRate();
        } else {
            throw new IllegalArgumentException("Неверная валюта: " + targetCurrencyCode);
        }
    }

    public Map<String, Currency> getAvailableCurrencies() {
        return currencies;
    }
}

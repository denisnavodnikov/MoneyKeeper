package ru.navodnikov.denis.finance.core.start;

import java.math.BigDecimal;
import java.util.Currency;

import ru.navodnikov.denis.finance.core.exseptions.AmountException;
import ru.navodnikov.denis.finance.core.exseptions.CurrencyException;
import ru.navodnikov.denis.finance.core.impls.DefaultStorage;

public class Start {
    public static void main(String[] args) {
        DefaultStorage defaultStorage = new DefaultStorage();
        try {
            Currency currencyUSD = Currency.getInstance("USD");
            Currency currencyRUB = Currency.getInstance("RUB");
            defaultStorage.addCurrency(currencyUSD);
            defaultStorage.addCurrency(currencyRUB);
            defaultStorage.addAmount(new BigDecimal(500), currencyUSD);
            defaultStorage.addAmount(new BigDecimal(300), currencyRUB);
            defaultStorage.expenseAmount(new BigDecimal(400), currencyUSD);
            System.out.println(defaultStorage.getCurrencyAmounts());
        } catch (CurrencyException | AmountException e) {
            e.printStackTrace();
        }
    }
}

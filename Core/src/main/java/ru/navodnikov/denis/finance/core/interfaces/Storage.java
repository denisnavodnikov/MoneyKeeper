package ru.navodnikov.denis.finance.core.interfaces;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;

import ru.navodnikov.denis.finance.core.exseptions.AmountException;
import ru.navodnikov.denis.finance.core.exseptions.CurrencyException;

//TODO изменить тип BigDecimal на класс по работе с деньгами Money
public interface Storage {

    String getName();

    // получение баланса (остатка)
    Map<Currency, BigDecimal> getCurrencyAmounts(); // остаток по каждой доступной валюте в хранилище
    BigDecimal getAmount(Currency currency) throws CurrencyException; // остаток по определенной валюте
    BigDecimal getApproxAmount(Currency currency) throws CurrencyException;// примерный остаток в переводе всех денег в одну валюту


    // изменение баланса
    void changeAmount(BigDecimal amount, Currency currency) throws CurrencyException; // изменение баланса по определенной валюте
    void addAmount(BigDecimal amount, Currency currency) throws CurrencyException; // добавить сумму в валюте
    void expenseAmount(BigDecimal amount, Currency currency) throws CurrencyException, AmountException; // отнять сумму в валюте

    // работа с валютами (в отдельный интерфейс нет смысла выделять)
    Currency getCurrency(String code) throws CurrencyException;	// поулчить валюту по коду
    void addCurrency(Currency currency) throws CurrencyException; // добавить новую валюту в хранилище
    void deleteCurrency(Currency currency) throws CurrencyException; // удалить валюту из хранилища
    List<Currency> getAvailableCurrencies(); // получить все доступные валюты хранилища в отдельной коллекции

}

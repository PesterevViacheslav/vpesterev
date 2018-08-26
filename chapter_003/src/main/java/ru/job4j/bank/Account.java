package ru.job4j.bank;
import java.util.Objects;
/**
 * Class Account - Лицевой счет. Решение задачи Части 003. Collections. Lite.
 * Задача 5.2  Банковские переводы.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.08.2018
 * @version 1
 */
public class Account {
    private double balance;
    private String requisites;
    /**
     * Method User. Конструктор.
     * @param balance Баланс.
     * @param requisites Реквизиты ЛС.
    */
    public Account(double balance, String requisites) {
        this.balance = balance;
        this.requisites = requisites;
    }
    /**
     * Method getBalance. Получить значение Баланса.
     * @return Баланс.
     */
    public double getBalance() {
        return this.balance;
    }
    /**
     * Method setBalance. Установить значение Баланса.
     * @param balance Баланс.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    /**
     * Method getRequisites. Получить значение Реквизиты ЛС.
     * @return Реквизиты ЛС.
     */
    public String getRequisites() {
        return this.requisites;
    }
    /**
     * Method transfer. Перевод средств.
     * @param destination ЛС получатель
     * @param amount Сумма
     * @return Успешность транзакции.
     */
    boolean transfer(Account destination, double amount) {
        boolean result = false;
        if (amount > 0 && amount < this.balance && destination != null) {
            result = true;
            this.balance -= amount;
            destination.setBalance(destination.getBalance() + amount);
        }
        return result;
    }
    @Override
    public String toString() {
        return "Account{'balance='" + this.balance + "'" + ", requisites='" + this.requisites + "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return  Objects.equals(requisites, account.requisites);
    }
    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}
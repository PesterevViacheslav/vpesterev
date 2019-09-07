package ru.job4j.jmm;
import java.util.Arrays;
/**
 * Class Bank - Банк. Решение задач уровня Junior. Части 002. Multithreading.
 * 6.2.1. Проиллюстрировать проблемы с многопоточностью.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.12.2018
 * @version 1
 */
public class Bank {
    private final double[] accounts;
    /**
     * Method Bank Конструктор
     * @param n Количество счетов
     * @param initialBalance Первоначальный остаток на каждом счете
     */
     public Bank(int n, double initialBalance) {
         accounts = new double[n];
         Arrays.fill(accounts, initialBalance);
     }
    /**
     * Method transfer Переводит деньги с одного счета на другой
     * @param from Счет, с которого переводятся деньги
     * @param to Счет, на который переводятся деньги
     * @param amount Сумма перевода
     */
     public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" Перевод суммы %10.2f со счета %d на счет %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Общий баланс: %10.2f%n", getTotalBalance());
    }
    /**
     * Получает сумму остатков на всех счетах
     * @return Возвращает общий баланс
     */
    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }
    /**
     * Получает количество счетов в банке
     * @return Возвращает количество счетов
     */
    public int size() {
        return accounts.length;
    }
}
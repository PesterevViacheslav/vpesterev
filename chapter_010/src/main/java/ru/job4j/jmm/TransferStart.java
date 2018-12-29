package ru.job4j.jmm;
/**
 * Class TransferStart - Запуск теста банковских транзакций. Решение задач уровня Junior. Части 002. Multithreading.
 * 6.2.1. Проиллюстрировать проблемы с многопоточностью.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 14.12.2018
 * @version 1
 */
public class TransferStart {
    public static final int N_ACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;
    /**
     * Method main Запуск теста
     */
    public static void main(String[] args) {
        Bank bank = new Bank(N_ACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < N_ACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (bank.getTotalBalance() == INITIAL_BALANCE * N_ACCOUNTS) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            };
            Thread t = new Thread(r);
            t .start();
        }
    }
}
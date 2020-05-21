package ru.job4j.concurrent;
/**
 * Class ThreadSleep - Ожидания потоков. Решение задач уровня Middle. Блок 1. Multithreading
 * 1. Threads. 1.2. Режим ожидания.[#283071].
 *             3.1. Прерывание блокированной нити.[#283072]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 17.05.2020
 * @version 1
 */
public class ThreadSleep {
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    try {
                        System.out.println("Start loading ... ");
                        for (int i = 1; i <= 100; i++) {
                            System.out.print("\rLoading : " + i + "%");
                            Thread.sleep(1000);
                        }
                        System.out.println("Loaded.");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        );
        thread.start();
        System.out.println("Main");
    }
}
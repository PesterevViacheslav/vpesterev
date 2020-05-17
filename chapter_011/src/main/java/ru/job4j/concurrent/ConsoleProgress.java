package ru.job4j.concurrent;
/**
 * Class ConsoleProgress - Прерывание потоков. Решение задач уровня Middle. Блок 1. Multithreading
 * 1. Threads. 3. Прерывание нити[#283074].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 17.05.2020
 * @version 1
 */
public class ConsoleProgress implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted()) {
            if (count == 4) {
                count = 0;
            }
            char[] chars = new char[] {'-', '\\', '|', '/'};
            System.out.print("\r load: " + chars[count]);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
            count++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(10000);
        progress.interrupt();
    }
}
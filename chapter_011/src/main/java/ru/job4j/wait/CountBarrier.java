package ru.job4j.wait;
/**
 * Class CountBarrier - Управление нитью через wait. Решение задач уровня Middle. Части 011. Multithreading.
 * Wait, Notify, NotifyAll. 0. Управление нитью через wait.[#283067]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 01.08.2020
 * @version 1
 */
public class CountBarrier {
    private final Object monitor = this;
    private final int total;
    private int count = 0;
    /**
     * Method CountBarrier. Конструктор
     * @param total
     */
    public CountBarrier(final int total) {
        this.total = total;
    }
    /**
     * Method count. Приращение счетчика
     */
    public void count() {
        synchronized (monitor) {
            if (++this.count >= this.total) {
                System.out.println(Thread.currentThread().getName() + " send notifyAll");
                monitor.notifyAll();
            }
        }
    }
    /**
     * Method await. Ожидание события
     */
    public void await() {
        synchronized (monitor) {
            while (this.count < this.total) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting...");
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
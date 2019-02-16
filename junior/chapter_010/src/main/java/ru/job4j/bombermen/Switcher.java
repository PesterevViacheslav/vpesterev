package ru.job4j.bombermen;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Class Switcher - Свитчер. Решение задач уровня Middle. Части 001. Multithreading.
 * 10.7.4. Свитчер.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.02.2019
 * @version 1
 */
public class Switcher {
    private volatile String accumStr = "";
    private final ReentrantLock locker;
    private final Condition condition;
    private volatile String threadName;
    /**
     * Method Switcher. Конструктор.
     * @param threadName Ожидающий поток.
     */
    public Switcher(String threadName) {
        this.threadName = threadName;
        this.locker = new ReentrantLock();
        this.condition = this.locker.newCondition();
    }
    /**
     * Method getAccumStr. Получение результирующей строки.
     * @return Строка.
     */
    public synchronized String getAccumStr() {
        return this.accumStr;
    }
    /**
     * Method add. Конкатенация.
     * @param addDigit Символ для конкатенации.
     * @param count Число циклов.
     */
    public void add(int addDigit, int count) {
        System.out.println(Thread.currentThread() + " add entered");
        for (int k = 0; k < count; k++) {
            locker.lock();
            System.out.println(Thread.currentThread() + " lock");
            try {
                while (this.threadName == Thread.currentThread().getName()) {
                    System.out.println(Thread.currentThread() + " await");
                    condition.await();
                }
                for (int i = 0; i < 10; i++) {
                    this.accumStr = this.accumStr.concat(String.valueOf(addDigit));
                }
                System.out.println(Thread.currentThread() + this.accumStr);
                this.threadName = Thread.currentThread().getName();
                condition.signal();
                System.out.println(Thread.currentThread() + " signal");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread() + " Interrupted");
            } finally {
                locker.unlock();
                System.out.println(Thread.currentThread() + " unlock");
            }
        }
    }
}
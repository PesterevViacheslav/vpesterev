package ru.job4j.synchronize;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
/**
 * Class Count - Synchronized. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 6.3.1 класс Count и метод int increment().
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 19.12.2018
 * @version 1
 */
@ThreadSafe
public class Count {
    @GuardedBy("this")
    private int value;
    /**
     * Метод increment. Приращение счетчика.
     */
    public synchronized void increment() {
        this.value++;
    }
    /**
     * Метод get. Получение значения счетчика.
     * @return Значение счетчика
     */
    public synchronized int get() {
        return this.value;
    }
}
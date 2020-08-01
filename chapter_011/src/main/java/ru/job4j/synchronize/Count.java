package ru.job4j.synchronize;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
/**
 * Class Count - Счетчик. Решение задач уровня Middle. Части 011. Multithreading.
 * Синхронизация. 2. JCIP. Настройка библиотеки[#283083]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 01.08.2020
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
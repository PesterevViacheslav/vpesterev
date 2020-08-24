package ru.job4j.nonblocking;
import net.jcip.annotations.ThreadSafe;
import java.util.concurrent.atomic.AtomicReference;
/**
 * Class CASCount - CAS счетчик. Решения задач уровня Middle. Части 011. Multithreading.
 * Nonblocking. 0. CAS - операции[#283092]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 20.08.2020
 * @version 1
 */
@ThreadSafe
public class CasCount<T> {
    private final AtomicReference<Integer> count = new AtomicReference<>();
    /**
     * Method CasCount. Конструктор
     */
    public CasCount() {
        this.count.set(0);
    }
    /**
     * Method increment. Приращение счетчика
     */
    public void increment() {
        Integer current;
        Integer next;
        do {
            current = this.count.get();
            next = current + 1;
        } while (!count.compareAndSet(current, next));
    }
    /**
     * Method get. Получение значения счетчика
     * @return Значение
     */
    public int get() {
        return this.count.get();
    }
}
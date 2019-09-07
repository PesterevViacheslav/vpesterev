package ru.job4j.wait;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Class SimpleBlockingQueue - Блокирующая очередь. Решение задач уровня Middle. Части 001. Multithreading.
 * 10.4.1 Реализовать шаблон Producer Consumer.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.01.2019
 * @version 1
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("lock")
    private Queue<T> queue = new LinkedList<>();
    @GuardedBy("lock")
    private final Object lock = new Object();
    /**
     * Method offer. Добавление в очередь.
     * @param value Элемент.
     */
    public void offer(T value) {
        synchronized (this.lock) {
            this.queue.offer(value);
            this.lock.notifyAll();
            System.out.println("offer " + Thread.currentThread().getName());
        }
    }
    /**
     * Method poll. Извлечение из очереди.
     * @return Элемент.
     */
    public T poll() throws InterruptedException {
        synchronized (this.lock) {
            T res = null;
            do {
                res = this.queue.poll();
                if (res == null) {
                    System.out.println("Poll WAIT " + Thread.currentThread().getName());
                    this.lock.wait();
                }
            } while (res == null);
            return res;
        }
    }
    /**
     * Method size. Получение размера очереди.
     * @return Размер очереди.
     */
    public int size() {
        synchronized (this.lock) {
            return this.queue.size();
        }
    }
    /**
     * Method isEmpty. Получение признака пустой очереди.
     * @return Размер очереди.
     */
    public boolean isEmpty() {
        synchronized (this.lock) {
            return this.queue.isEmpty();
        }
    }
}
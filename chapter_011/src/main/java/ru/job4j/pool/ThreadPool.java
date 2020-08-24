package ru.job4j.pool;
import ru.job4j.wait.SimpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;
/**
 * Class ThreadPool - Пул. Решение задач уровня Middle. Части 011. Multithreading.
 * Пулы. 1. Реализовать ThreadPool[#283062]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 24.08.2020
 * @version 1
 */
public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    public List<Thread> getThreads() {
        return this.threads;
    }
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private volatile boolean processing = true;
    /**
     * Метод ThreadPool. Конструктор.
     */
    public ThreadPool() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < availableProcessors; i++) {
            this.threads.add(new Thread(() -> {
                try {
                    while (this.processing) {
                        this.tasks.poll().run();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }));
            this.threads.get(i).setName("Thread" + i);
            this.threads.get(i).start();
        }
    }
    /**
     * Метод work. Добавление задания.
     * @param job Задание.
     */
    public void work(Runnable job) {
        if (this.processing) {
            this.tasks.offer(job);
        }
    }
    /**
     * Метод shutdown. Остановка пула.
     */
    public void shutdown() {
        this.processing = false;
        for (Thread t: this.threads) {
            t.interrupt();
        }
    }
    /**
     * Метод size. Получение числа заданий.
     * @return Размер.
     */
    public int size() {
        return this.tasks.size();
    }
}

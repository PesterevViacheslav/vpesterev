package ru.job4j.pool;
import ru.job4j.wait.SimpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;
/**
 * Class ThreadPool - Пул потоков. Решение задач уровня Middle. Части 001. Multithreading.
 * 10.6.1. Реализовать ThreadPool.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 22.01.2019
 * @version 1
 */
public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
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
                        System.out.println("RUN " + Thread.currentThread().getName());
                        this.tasks.poll().run();
                    }
                } catch (InterruptedException e) {
                    System.out.println("constructor interrupt");
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
        System.out.println("Shutdown " + Thread.currentThread().getName());
        this.processing = false;
    }
    /**
     * Метод size. Получение числа заданий.
     * @return Размер.
     */
    public int size() {
        return this.tasks.size();
    }
}
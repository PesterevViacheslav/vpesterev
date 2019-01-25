package ru.job4j.pool;

import org.junit.Test;
import ru.job4j.wait.SimpleBlockingQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class ThreadPoolTest - Пул потоков. Автотесты для решения задач уровня Middle. Части 001. Multithreading.
 * 10.6.1. Реализовать ThreadPool.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 22.01.2019
 * @version 1
 */
public class ThreadPoolTest {
    private static class Job implements Runnable {
        private double a;
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                this.a = Math.random();
            }
            System.out.println("CALC=" + this.a + " " + Thread.currentThread().getName());
        }
    }
    /**
     * Тест работы с пулом потоков.
     */
    @Test
    public void testThreadPool() throws InterruptedException {
        ThreadPool pool = new ThreadPool();
        pool.work(new Job());
        pool.work(new Job());
        pool.work(new Job());
        pool.work(new Job());
        pool.work(new Job());
        pool.work(new Job());
        pool.work(new Job());
        pool.work(new Job());
        pool.work(new Job());
        pool.work(new Job());
        Thread.currentThread().join(1000);
        assertThat(pool.size(), is(0));

        pool.shutdown();
        Thread.currentThread().join(1000);

        for (Thread t: pool.getThreads()) {
            System.out.println(t.getName() + " " + t.getState());
        }
        Thread.currentThread().join(1000);

    }
}
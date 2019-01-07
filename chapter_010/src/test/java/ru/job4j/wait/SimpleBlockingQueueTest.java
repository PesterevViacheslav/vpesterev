package ru.job4j.wait;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Class SimpleBlockingQueueTest - Блокирующая очередь. Автотесты для решения задач уровня Middle. Части 001. Multithreading.
 * 10.4.1 Реализовать шаблон Producer Consumer.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.01.2019
 * @version 1
 */
public class SimpleBlockingQueueTest {
    /**
     * Тест работы с очередью в одном потоке.
     */
    @Test
    public void testQueueInOneThread() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertThat(queue.size(), is(3));
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
        assertThat(queue.size(), is(0));
    }
    /**
     * Тест работы с очередью в нескольких потоках.
     */
    @Test
    public void testQueueInMultiThread() {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                try {
                    System.out.println("Thread1 poll:" + queue.poll());
                } catch (InterruptedException e) {
                    System.out.println("Thread1 interrupt");
                    Thread.currentThread().interrupt();
                }
            }
        });
        t1.setName("Thread1");
        t1.start();
        Thread t2 = new Thread(() -> {
            System.out.println("Thread2");
            queue.offer(4);
            queue.offer(5);
        });
        t2.setName("Thread2");
        t2.start();
        try {
            Thread.currentThread().join(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        assertThat(queue.size(), is(0));
    }
    /**
     * Тест Producer - Consumer.
     */
    @Test
    public void whenFetchAllThenGetIt() throws InterruptedException {
        final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Thread producer = new Thread(
                () -> {
                    IntStream.range(0, 5).forEach(
                            queue::offer
                    );
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Producer interruption");
                        Thread.currentThread().interrupt();
                    }
                }
        );
        producer.start();
        Thread consumer = new Thread(
                () -> {
                    while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
                        System.out.println("EMPTY=" + queue.isEmpty() + " INTERRUPTED=" + Thread.currentThread().isInterrupted());
                        try {
                            buffer.add(queue.poll());
                        } catch (InterruptedException e) {
                            System.out.println("Consumer interruption");
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("End EMPTY=" + queue.isEmpty() + " INTERRUPTED=" + Thread.currentThread().isInterrupted());
                }
        );
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
        assertThat(buffer, is(Arrays.asList(0, 1, 2, 3, 4)));
    }
}
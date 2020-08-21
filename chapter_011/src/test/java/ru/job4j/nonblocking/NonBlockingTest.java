package ru.job4j.nonblocking;
import org.junit.Assert;
import org.junit.Test;
import java.util.concurrent.atomic.AtomicReference;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Class NonBlockingTest - Неблокирующий кеш. Автотесты для задач уровня Middle. Части 011. Multithreading.
 * Non blocking algorithm. 1. Неблокирующий кеш[#283091]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.08.2020
 * @version 1
 */
public class NonBlockingTest {
    /**
     * Тест работы с очередью в нескольких потоках.
     */
    @Test
    public void testQueueInMultiThread() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        NonBlocking queue = new NonBlocking();
        Thread t1 = new Thread(() -> {
            try {
                queue.add(new NonBlocking.Base(0));
                queue.add(new NonBlocking.Base(1));
                queue.add(new NonBlocking.Base(2));
            } catch (OptimisticException e) {
                System.out.println("Thread1 interrupt");
                ex.set(e);
                Thread.currentThread().interrupt();
            }
        });
        t1.setName("Thread1");
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                queue.add(new NonBlocking.Base(0));

            } catch (OptimisticException e) {
                System.out.println("Thread2 interrupt");
                ex.set(e);
                Thread.currentThread().interrupt();
            }
        });
        t2.setName("Thread2");
        t2.start();
        t1.join();
        t2.join();
        assertThat(queue.get(0).id, is(0));
        assertThat(queue.get(0).version, is(1));
        assertThat(queue.size(), is(3));
        Thread t3 = new Thread(() -> {
            try {
                queue.update(new NonBlocking.Base(0, queue.get(0).version));
            } catch (OptimisticException e) {
                System.out.println("Thread3 interrupt");
                ex.set(e);
                Thread.currentThread().interrupt();
            }
        });
        t3.setName("Thread3");
        t3.start();
        Thread t4 = new Thread(() -> {
            try {
                queue.update(new NonBlocking.Base(0, queue.get(0).version));
            } catch (OptimisticException e) {
                System.out.println("Thread4 interrupt");
                ex.set(e);
                Thread.currentThread().interrupt();
            }
        });
        t4.setName("Thread4");
        t4.start();
        t3.join();
        t4.join();
        assertThat(queue.size(), is(3));
        Assert.assertThat(ex.get().getMessage(), is("updateOptimisticException"));
        Thread t5 = new Thread(() -> {
            try {
                queue.delete(new NonBlocking.Base(0, queue.get(0).version));
            } catch (OptimisticException e) {
                System.out.println("Thread5 interrupt");
                ex.set(e);
                Thread.currentThread().interrupt();
            }
        });
        t5.setName("Thread5");
        Thread t6 = new Thread(() -> {
            try {
                queue.delete(new NonBlocking.Base(0, queue.get(0).version));
            } catch (OptimisticException e) {
                System.out.println("Thread5 interrupt");
                ex.set(e);
                Thread.currentThread().interrupt();
            }
        });
        t6.setName("Thread6");
        t5.start();
        t6.start();
        t5.join();
        t6.join();
        //assertThat(queue.size(), is(2));
        Assert.assertThat(ex.get().getMessage(), is("deleteOptimisticException"));
    }
}
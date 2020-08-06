package ru.job4j.wait;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class CountBarrierTest - Тест управления нитью через wait. Автотесты для решения задач уровня Middle. Части 011. Multithreading.
 * Wait, Notify, NotifyAll. 0. Управление нитью через wait.[#283067]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.08.2020
 * @version 1
 */
public class CountBarrierTest {
    /**
     * Тест выполнения двух синхронизированных потоков со счетчиком.
     */
    @Test
    public void whenExecute2ThreadThenAwaitCounter() throws InterruptedException {
        CountBarrier barrier = new CountBarrier(5);
        Thread count = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    for (int i = 0; i < 5; i++) {
                        barrier.count();
                    }
                },
                "Count"
        );
        Thread await = new Thread(
                () -> {
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + " started");
                },
                "Await"
        );
        await.start();
        count.start();
        await.join();
        count.join();
        assertThat(count.isAlive(), is(false));
        assertThat(await.isAlive(), is(false));
    }
}
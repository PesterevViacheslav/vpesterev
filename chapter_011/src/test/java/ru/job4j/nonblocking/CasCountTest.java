package ru.job4j.nonblocking;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
/**
 * Class CASCountTest - CAS счетчик. Автотесты для решения задач уровня Middle. Части 011. Multithreading.
 * Nonblocking. 0. CAS - операции[#283092]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 20.08.2020
 * @version 1
 */
public class CasCountTest {
    @Test
    public void testIncrement() throws InterruptedException {
        CasCount casCount = new CasCount();

        Thread thread1 = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    for (int i = 0; i < 5; i++) {
                        casCount.increment();
                    }
                },
                "thread1"
        );
        Thread thread2 = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    for (int i = 0; i < 5; i++) {
                        casCount.increment();
                    }
                },
                "thread2"
        );
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertThat(casCount.get(), is(10));
    }
}

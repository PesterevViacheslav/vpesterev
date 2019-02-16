package ru.job4j.bombermen;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Class SwitcherTest - Свитчер. Автотесты для задач уровня Middle. Части 001. Multithreading.
 * 10.7.4. Свитчер.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.02.2019
 * @version 1
 */
public class SwitcherTest {
    /**
     * Тест работы свитчера.
     */
    @Test
    public void testSwitcherInMultiThread() throws InterruptedException {
        Switcher switcher = new Switcher("Thread2");
        Thread t1 = new Thread(() -> {
            switcher.add(1, 3);
        });
        t1.setName("Thread1");
        t1.start();
        Thread t2 = new Thread(() -> {
            switcher.add(2, 3);
        });
        t2.setName("Thread2");
        t2.start();
        t1.join();
        t2.join();
        assertThat(switcher.getAccumStr(), is("111111111122222222221111111111222222222211111111112222222222"));
    }
}
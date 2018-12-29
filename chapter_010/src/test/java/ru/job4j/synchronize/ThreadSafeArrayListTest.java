package ru.job4j.synchronize;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.Matchers.is;
/**
 * Class ThreadSafeArrayListTest - Потокобезопасный список. Автотесты для решения задач уровня Middle. Части 001. Multithreading.
 * 10.3.3 ThreadSafe динамический список.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 28.12.2018
 * @version 1
 */
public class ThreadSafeArrayListTest {
    /**
     * Тест итератора с модификацией в одном потоке.
     */
    @Test
    public void testIteratorInOneThread() {
        ThreadSafeArrayList<Integer> array = new ThreadSafeArrayList<>(4);
        array.add(1);
        array.add(2);
        array.add(3);
        Iterator<Integer> it = array.iterator();
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(3));
        array.add(null);
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(IsNull.nullValue()));
        MatcherAssert.assertThat(it.hasNext(), is(false));
    }
    /**
     * Тест итератора с модификацией в нескольких потоках.
     */
    @Test
    public void testIteratorMultiThread() {
        ThreadSafeArrayList<Integer> array = new ThreadSafeArrayList<>(6);
        array.add(1);
        array.add(2);
        array.add(3);
        Thread t1 = new Thread(() -> {
            Iterator<Integer> it = array.iterator();
            while (it.hasNext()) {
                Integer i = it.next();
                System.out.println("Thread1:" + i);
            }
        });
        t1.setName("Thread1");
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("Thread2");
            array.add(4);
            array.add(5);
            array.add(6);

        });
        t2.setName("Thread2");
        t2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
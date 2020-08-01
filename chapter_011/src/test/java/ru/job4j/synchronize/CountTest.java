package ru.job4j.synchronize;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class CountTest - Тест счетчика. Автотесты для решения задач уровня Middle. Части 011. Multithreading.
 * Синхронизация. 2. JCIP. Настройка библиотеки[#283083]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 01.08.2020
 * @version 1
 */
public class CountTest {
    /**
     * Класс описывает нить со счетчиком.
     */
    private class ThreadCount extends Thread {
        private final Count count;
        /**
         * Метод ThreadCount. Конструктор.
         * @param count Счетчик.
         */
        private ThreadCount(final Count count) {
            this.count = count;
        }
        /**
         * Метод run. Обработчик.
         */
        @Override
        public void run() {
            this.count.increment();
        }
    }
    /**
     * Тест выполнения двух синхронизированных потоков.
     */
    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        final Count count = new Count();
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(count.get(), is(2));
    }
}
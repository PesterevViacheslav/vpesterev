package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CounterTest Автотесты для задач Части 001. Базовый синтаксис урок 5.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 23.03.2018
 * @version 1
 */
public class CounterTest {
    /**
     * Тест операции получения суммы нечетных чисел из диапазона (с нечетного до четного)
     */
    @Test
    public void whenFromOneToTenThenThirty() {
        Counter summ = new Counter();
        int result = summ.add(1, 10);
        assertThat(result, is(30));
    }
    /**
     * Тест операции получения суммы нечетных чисел из диапазона (с нечетного до нечетного)
     */
    @Test
    public void whenFromOneToElevenThenThirty() {
        Counter summ = new Counter();
        int result = summ.add(1, 11);
        assertThat(result, is(30));
    }
    /**
     * Тест операции получения суммы нечетных чисел из диапазона (с четного до нечетного)
     */
    @Test
    public void whenFromTwoToElevenThenThirty() {
        Counter summ = new Counter();
        int result = summ.add(2, 11);
        assertThat(result, is(30));
    }
    /**
     * Тест операции получения суммы нечетных чисел из диапазона (с четного до четного)
     */
    @Test
    public void whenFromTwoToEightThenTwenty() {
        Counter summ = new Counter();
        int result = summ.add(2, 8);
        assertThat(result, is(20));
    }

}

package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MaxTest Автотесты для задач Части 001. Базовый синтаксис урок 4.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 20.03.2018
 * @version 1
 */
public class MaxTest {
    /**
     * Тест операции получения максимума из двух чисел (первое меньше второго)
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Тест операции получения максимума из двух чисел (второе меньше первого)
     */
    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(3, 2);
        assertThat(result, is(3));
    }

    /**
     * Тест операции получения максимума из двух чисел (первое равно второму)
     */
    @Test
    public void whenFirstEqualSecond() {
        Max maxim = new Max();
        int result = maxim.max(3, 3);
        assertThat(result, is(3));
    }

}





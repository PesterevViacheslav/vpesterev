package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class FactorialTest Автотесты для задач Части 001. Базовый синтаксис урок 5.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 23.03.2018
 * @version 1
 */
public class FactorialTest {
    /**
     * Тест операции получения факториала числа 5
     */
    @Test
    public void whenFiveFactorialThenOneHundredTwenty() {
        Factorial clc = new Factorial();
        int result = clc.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Тест операции получения факториала числа 0
     */
    @Test
    public void whenZeroFactorialThenOne() {
        Factorial clc = new Factorial();
        int result = clc.calc(0);
        assertThat(result, is(1));
    }
}

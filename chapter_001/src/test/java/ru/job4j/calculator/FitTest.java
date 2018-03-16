package ru.job4j.calculator;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Class FitTest Автотесты для задач Части 001. Базовый синтаксис урок 3.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.03.2018
 * @version 1
 */

public class FitTest {
    /**
     * Тест операции вычисления идеального веса мужчины.
     */
    @Test
    public void whenManWeightCloseTo180Then92WithErr01() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    /**
     * Тест операции вычисления идеального веса женщины.
     */
    @Test
    public void whenWomanWeightCloseTo170Then69WithErr01() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}


package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PointTest Автотесты для задач Части 001. Базовый синтаксис урок 3.4.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.03.2018
 * @version 1
 */
public class PointTest {

    /**
     * Тест операции вычисления расстояния между точками.
     */
    @Test
    public void whenDistanceBetweenPointX1Y1AndPointX1Y3ThenTwo() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 3);

        double result = a.distanceTo(b);
        double expected = 2D;
        assertThat(result, is(expected));
    }

}

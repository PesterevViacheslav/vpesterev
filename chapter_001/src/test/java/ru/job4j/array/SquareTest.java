package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SquareTest Автотесты для задач Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 28.03.2018
 * @version 1
 */
public class SquareTest {
    /**
     * Тест операции получения массива квадратов чисел
     */
    @Test
    public void checkArraySquareValuesLengthFive() {
        Square p = new Square();
        int[] result = new int[] {1, 4, 9, 16, 25};
        assertThat(result, is(p.calculate(5)));
    }

    /**
     * Тест операции получения массива квадратов чисел (нулевая длина)
     */
    @Test
    public void checkArraySquareValuesLengthZero() {
        Square p = new Square();
        int[] result = new int[] {-1};
        assertThat(result, is(p.calculate(0)));
    }

    /**
     * Тест операции получения массива квадратов чисел (отрицательная длина)
     */
    @Test
    public void checkArraySquareValuesLengthNegative() {
        Square p = new Square();
        int[] result = new int[] {-1};
        assertThat(result, is(p.calculate(-1)));
    }
}

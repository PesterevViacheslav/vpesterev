package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Class TriangleTest Автотесты для задач Части 001. Базовый синтаксис урок 4.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 21.03.2018
 * @version 1
 */
public class TriangleTest {

    /**
     * Тест операции вычисления площади треугольника (удовлетворяет условиям выполнения)
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 5);
        Point c = new Point(4, 0);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 10D;
        assertThat(result, closeTo(expected, 0.01));
    }

    /**
     * Тест операции вычисления площади треугольника (вершины совпадают)
     */
    @Test
    public void whenAreaSetTwoSamePointsThenErrArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Point c = new Point(4, 0);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1D;
        assertThat(result, closeTo(expected, 0.01));
    }

    /**
     * Тест операции вычисления площади треугольника (длина одной из сторон больше чем сумма остальных)
     */
    @Test
    public void whenAreaSetDistanceToOnePointsGreaterThenSumAnotherThenErrArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 5);
        Point c = new Point(0, 15);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1D;
        assertThat(result, closeTo(expected, 0.01));
    }
}

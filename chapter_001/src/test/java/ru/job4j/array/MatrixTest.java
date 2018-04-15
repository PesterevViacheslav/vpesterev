package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class MatrixTest Автотесты для задач Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.04.2018
 * @version 1
 */
public class MatrixTest {
    /**
     * Тест операции построения таблицы умножения (пустой массив).
     */
    @Test
    public void checkMultiplicationTableSizeZero() {
        Matrix p = new Matrix();
        int[][] result = new int[0][0];
        assertThat(result, is(p.multiple(0)));
    }
    /**
     * Тест операции построения таблицы умножения (1x1).
     */
    @Test
    public void checkMultiplicationTableSizeOne() {
        Matrix p = new Matrix();
        int[][] result = {{1}};
        assertThat(result, is(p.multiple(1)));
    }
    /**
     * Тест операции построения таблицы умножения (размер 3x3).
     */
    @Test
    public void checkMultiplicationTableSizeThree() {
        Matrix p = new Matrix();
        int[][] result = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertThat(result, is(p.multiple(3)));
    }
    /**
     * Тест операции построения таблицы умножения (размер 5x5).
     */
    @Test
    public void checkMultiplicationTableSizeFive() {
        Matrix p = new Matrix();
        int[][] result = {{1, 2, 3, 4, 5}, {2, 4, 6, 8, 10}, {3, 6, 9, 12, 15}, {4, 8, 12, 16, 20}, {5, 10, 15, 20, 25}};
        assertThat(result, is(p.multiple(5)));
    }
}
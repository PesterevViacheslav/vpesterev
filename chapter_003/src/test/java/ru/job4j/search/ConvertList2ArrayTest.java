package ru.job4j.search;
/**
 * Class ConvertList2ArrayTest. Автотесты для задачи Части 003. Collections. Lite Задача 1.3. Конвертация ArrayList в двухмерный массив.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.07.2018
 * @version 1
 */
import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    /**
     * Тест конвертации массива из 7ми элементов в двумерный массив 3х3
     */
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
    @Test
    /**
     * Тест конвертации массива из 6ми элементов в двумерный массив 3х2
     */
    public void when6ElementsThen6() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6), 3);
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        assertThat(result, is(expect));
    }
    @Test
    /**
     * Тест конвертации массива из 6ми элементов в двумерный массив 3х2
     */
    public void when5ElementsThen5InRow() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5), 1);
        int[][] expect = {
                {1, 2, 3, 4, 5}
        };
        assertThat(result, is(expect));
    }
    @Test
    /**
     * Тест конвертации массива из 6ми элементов в двумерный массив 3х2
     */
    public void when5ElementsThen5InColumn() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5), 5);
        int[][] expect = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        assertThat(result, is(expect));
    }
}
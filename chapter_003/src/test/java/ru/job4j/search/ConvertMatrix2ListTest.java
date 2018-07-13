package ru.job4j.search;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class ConvertMatrix2ListTest. Автотесты для задачи Части 003. Collections. Lite Задача 1.4. двумерного массива в ArrayList.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 13.07.2018
 * @version 1
 */
public class ConvertMatrix2ListTest {
    @Test
    /**
     * Тест конвертации двумерного массива 2x2 в массив из 4 элементов
     */
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
    @Test
    /**
     * Тест конвертации двумерного массива с различной длиной строк в массив из 6 элементов
     */
    public void whenDifferentRowsArrayThenList6() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4, 5},
                {6}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
    @Test
    /**
     * Тест конвертации пустого двумерного массива в массив из 0 элементов
     */
    public void whenEmptyArrayThenList0() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {};
        List<Integer> expect = Arrays.asList();
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}



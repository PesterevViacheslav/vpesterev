package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class BubbleSortTest Автотесты для задач Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.04.2018
 * @version 1
 */
public class BubbleSortTest {
    /**
     * Тест операции сортировки массива
     */
    @Test
    public void checkSortArray() {
        BubbleSort p = new BubbleSort();
        int[] array = new int[] {3, 2, 1, 5, 4, -1};
        int[] result = new int[] {-1, 1, 2, 3, 4, 5};
        assertThat(result, is(p.sort(array)));
    }
}
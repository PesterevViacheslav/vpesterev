package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class FindLoopTest Автотесты для задач Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 30.03.2018
 * @version 1
 */
public class FindLoopTest {
    /**
     * Тест операции поиска элемента в массиве (элемент присутствует)
     */
    @Test
    public void checkFindArrayElementExists() {
        FindLoop p = new FindLoop();
        int[] array = new int[] {1, 4, 9, 16, 25};
        int result = 2;
        assertThat(result, is(p.indexOf(array, 9)));
    }
    /**
     * Тест операции поиска элемента в массиве (элемент отсутствует)
     */
    @Test
    public void checkFindArrayElementNotExists() {
        FindLoop p = new FindLoop();
        int[] array = new int[] {1, 4, 9, 16, 25};
        int result = -1;
        assertThat(result, is(p.indexOf(array, 30)));
    }
}
package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class ArrayMergeTest Автотесты для задач Части 001. Базовый синтаксис урок 7.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 14.04.2018
 * @version 1
 */
public class ArrayMergeTest {
    /**
     * Тест операции слияния отсортированных массивов (Размер первого больше).
     */
    @Test
    public void checkArrayMergeLessB() {
        ArrayMerge p = new ArrayMerge();
        int[] result = {1, 2, 4, 5, 7, 8, 10, 11, 12, 13, 13, 14, 15, 16, 17};
        int[] arrayA = {2, 4, 7, 10, 11, 13, 15, 16, 17};
        int[] arrayB = {1, 5, 8, 12, 13, 14};
        assertThat(result, is(p.merge(arrayA, arrayB)));
    }
    /**
     * Тест операции слияния отсортированных массивов (Размер второго больше).
     */
    @Test
    public void checkArrayMergeLessA() {
        ArrayMerge p = new ArrayMerge();
        int[] result = {1, 4, 5, 7, 8, 9};
        int[] arrayA = {4, 7};
        int[] arrayB = {1, 5, 8, 9};
        assertThat(result, is(p.merge(arrayA, arrayB)));
    }
    /**
     * Тест операции слияния отсортированных массивов (Размер одинаков).
     */
    @Test
    public void checkArrayMergeSameLength() {
        ArrayMerge p = new ArrayMerge();
        int[] result = {1, 4, 5, 7};
        int[] arrayA = {4, 7};
        int[] arrayB = {1, 5};
        assertThat(result, is(p.merge(arrayA, arrayB)));
    }
    /**
     * Тест операции слияния отсортированных массивов (Содержимое одинаково).
     */
    @Test
    public void checkArrayMergeSameValues() {
        ArrayMerge p = new ArrayMerge();
        int[] result = {1, 1, 3, 3, 5, 5};
        int[] arrayA = {1, 3, 5};
        int[] arrayB = {1, 3, 5};
        assertThat(result, is(p.merge(arrayA, arrayB)));
    }
}
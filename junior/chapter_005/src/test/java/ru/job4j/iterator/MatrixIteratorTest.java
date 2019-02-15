package ru.job4j.iterator;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Class MatrixIteratorTest. Автотесты для задач уровня Junior. Части 001. Collections. Pro.
 * Задача 5.1.1. Итератор для двухмерного массива int[][].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.09.2018
 * @version 1
 */
public class MatrixIteratorTest {
    private Iterator<Integer> it;
    private Iterator<Integer> itJagged;

    @Before
    public void setUp() {
        it = new MatrixIterator(new int[][]{{1, 2, 3}, {4, 5, 6}});
        itJagged = new MatrixIterator(new int[][]{{1}, {3, 4}, {7}});
    }
    /**
     * Тест последовательного прохода по массиву.
     */
    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
    }
    /**
     * Тест проверки того, что метод получения не зависит от предварительного вызова метода проверки.
     */
    @Test
    public void testsThatNextMethodDoesNotDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
    }
    /**
     * Тест проверки того, что вызов метода проверки не влияет на метод получения.
     */
    @Test
    public void sequentialHasNextInvocationDoesNotAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
    }
    /**
     * Тест прохода по пустому массиву.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementException() {
        it = new MatrixIterator(new int[][]{});
        it.next();
    }
    /**
     * Тест проверки того, что метод получения не зависит от предварительного вызова метода проверки.
     */
    @Test
    public void testsThatNextMethodDoesNotDependsOnPriorHasNextInvocationJagged() {
        assertThat(itJagged.next(), is(1));
        assertThat(itJagged.next(), is(3));
        assertThat(itJagged.next(), is(4));
        assertThat(itJagged.next(), is(7));
    }
    /**
     * Тест проверки того, что вызов метода проверки не влияет на метод получения.
     */
    @Test
    public void sequentialHasNextInvocationDoesNotAffectRetrievalOrderJagged() {
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(1));
        assertThat(itJagged.next(), is(3));
        assertThat(itJagged.next(), is(4));
        assertThat(itJagged.next(), is(7));
    }
    /**
     * Тест последовательного прохода по массиву.
     */
    @Test
    public void hasNextNextSequentialInvocationJagged() {
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(1));
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(3));
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(4));
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(7));
        assertThat(itJagged.hasNext(), is(false));
    }
}
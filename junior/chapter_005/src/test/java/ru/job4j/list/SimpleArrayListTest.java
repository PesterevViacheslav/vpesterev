package ru.job4j.list;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class SimpleArrayList - Динамический список. Автотесты для решения задач уровня Junior. Части 001. Collections. Pro.
 * 5.3.1. Создать динамический список на базе массива.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.10.2018
 * @version 1
 */
public class SimpleArrayListTest {
    /**
     * Тест наполнения контейнера до его первоначального размера.
     */
    @Test
    public void testAddToInitialSize() {
        SimpleArrayList<Integer> array = new SimpleArrayList<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
        assertThat(array.getSize(), is(3));
        assertThat(array.getIndex(), is(3));
        assertThat(array.get(0), is(1));
        assertThat(array.get(1), is(2));
        assertThat(array.get(2), is(3));
    }
    /**
     * Тест расширения контейнера до нового размера.
     */
    @Test
    public void testAddToNewSize() {
        SimpleArrayList<Integer> array = new SimpleArrayList<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        assertThat(array.getSize(), is(6));
        assertThat(array.getIndex(), is(4));
        assertThat(array.get(0), is(1));
        assertThat(array.get(1), is(2));
        assertThat(array.get(2), is(3));
        assertThat(array.get(3), is(4));
    }
    /**
     * Тест последовательного прохода по массиву.
     */
    @Test(expected = NoSuchElementException.class)
    public void testIteratorSequentiallyFetch() {
        SimpleArrayList<Integer> array = new SimpleArrayList<>(4);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(null);
        Iterator<Integer> it = array.iterator();
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(IsNull.nullValue()));
        MatcherAssert.assertThat(it.hasNext(), is(false));
        it.next();
    }
    /**
     * Тест последовательного прохода по массиву с модификацией.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void testIteratorConcurrentModificationException() {
        SimpleArrayList<Integer> array = new SimpleArrayList<>(4);
        array.add(1);
        array.add(2);
        array.add(3);
        Iterator<Integer> it = array.iterator();
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(3));
        array.add(null);
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(IsNull.nullValue()));
        MatcherAssert.assertThat(it.hasNext(), is(false));
    }
}
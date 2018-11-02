package ru.job4j.set;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class SimpleSet - Множество. Автотесты для решения задач уровня Junior. Части 001. Collections. Pro.
 * 5.4.1. Реализовать коллекцию Set на массиве.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.11.2018
 * @version 1
 */
public class SimpleSetTest {
    /**
     * Тест добавления элементов в множество.
     */
    @Test
    public void testAddNewElements() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        assertThat(set.getSize(), is(3));
        set.add(2);
        set.add(3);
        assertThat(set.getSize(), is(3));
        set.add(4);
        set.add(5);
        assertThat(set.getSize(), is(5));
        set.add(null);
        assertThat(set.getSize(), is(6));
    }
    /**
     * Тест последовательного прохода по массиву.
     */
    @Test(expected = NoSuchElementException.class)
    public void testIteratorSequentiallyFetch() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(null);
        Iterator<Integer> it = set.iterator();
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(IsNull.nullValue()));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.hasNext(), is(false));
        it.next();
    }
}
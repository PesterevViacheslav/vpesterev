package ru.job4j.generic;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Class MatrixIteratorTest. Автотесты для задач уровня Junior. Части 001. Collections. Pro.
 * Задача 5.2.1. Реализовать SimpleArray<T>.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.10.2018
 * @version 1
 */
public class SimpleArrayTest {
    /**
     * Тест наполнения контейнера значениями Integer.
     */
    @Test
    public void whenCreateIntegerReturnInteger() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        assertThat(array.get(0), is(1));
    }
    /**
     * Тест наполнения контейнера значениями String.
     */
    @Test
    public void whenCreateStringReturnString() {
        SimpleArray<String> array = new SimpleArray<>(10);
        array.add("Test");
        assertThat(array.get(0), is("Test"));
    }
    /**
     * Тест переполнения контейнера.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenOutOfBoundsThenThrowException() {
        SimpleArray<String> array = new SimpleArray<>(3);
        array.add("Test");
        array.add("Test2");
        array.add("Test3");
        array.add("Test4");
    }
    /**
     * Тест изменения элемента контейнера.
     */
    @Test
    public void whenSetNewValueThenReturnNewValue() {
        SimpleArray<String> array = new SimpleArray<>(3);
        array.add("Test");
        array.set(0, "Test2");
        assertThat(array.get(0), is("Test2"));
    }
    /**
     * Тест изменения элемента за пределами контейнера.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenSetWrongIndexThenThrowException() {
        SimpleArray<String> array = new SimpleArray<>(3);
        array.add("Test");
        array.set(3, "Test2");
    }
    /**
     * Тест удаления элемента контейнера.
     */
    @Test
    public void testDeleteElement() {
        SimpleArray<Integer> expect = new SimpleArray<>(2);
        expect.add(1);
        expect.add(3);
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
        array.delete(1);
        assertThat(array, is(expect));
    }
    /**
     * Тест удаления последнего элемента контейнера.
     */
    @Test
    public void testDeleteLastElement() {
        SimpleArray<Integer> expect = new SimpleArray<>(0);
        SimpleArray<Integer> array = new SimpleArray<>(1);
        array.add(1);
        array.delete(0);
        assertThat(array, is(expect));
    }
    /**
     * Тест итератора контейнера.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIntegerIterator() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
        Iterator<Integer> it = array.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
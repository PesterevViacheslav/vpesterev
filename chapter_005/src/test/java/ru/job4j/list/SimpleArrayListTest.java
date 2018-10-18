package ru.job4j.list;
import org.junit.Test;
import org.junit.Before;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class SimpleArrayList - Односвязный список. Автотесты для решения задач уровня Junior. Части 001. Collections. Pro.
 * 5.3.0 Создать метод delete для односвязного списка.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.10.2018
 * @version 1
 */
public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;
    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }
    /**
     * Тест получения элемента контейнера.
     */
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }
    /**
     * Тест получения размера контейнера.
     */
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }
    /**
     * Тест удаления первого элемента контейнера.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirstThenDeleteFirst() {
        list.delete();
        assertThat(list.getSize(), is(2));
        assertThat(list.get(0), is(2));
        list.delete();
        assertThat(list.getSize(), is(1));
        assertThat(list.get(0), is(1));
        list.delete();
        assertThat(list.getSize(), is(0));
        list.delete();
    }
}
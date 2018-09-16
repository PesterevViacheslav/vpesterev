package ru.job4j.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Class EvenIteratorTest. Автотесты для задач уровня Junior. Части 001. Collections. Pro.
 * Задача 5.1.2. Создать итератор четные числа.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.09.2018
 * @version 1
 */
public class EvenIteratorTest {
    private Iterator<Integer> it;
    @Before
    public void setUp() {
        it = new EvenIterator(new int[]{1, 2, 3, 4, 5, 6, 7});
    }
    /**
     * Тест последовательного прохода по массиву.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
    /**
     * Тест проверки того, что вызов метода проверки не влияет на метод получения.
     */
    @Test
    public void sequentialHasNextInvocationDoesNotAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }
    /**
     * Тест прохода по массиву в котором нет четных элементов.
     */
    @Test
    public void  shouldReturnFalseIfNoAnyEvenNumbers() {
        it = new EvenIterator(new int[]{1});
        assertThat(it.hasNext(), is(false));
    }
    /**
     * Тест прохода по массиву в котором только четные элементы.
     */
    @Test
    public void allNumbersAreEven() {
        it = new EvenIterator(new int[]{2, 4, 6, 8});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
    }
}
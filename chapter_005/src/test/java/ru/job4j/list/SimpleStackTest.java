package ru.job4j.list;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class SimpleStackTest - Стек. Автотесты для решения задач уровня Junior. Части 001. Collections. Pro.
 * 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.10.2018
 * @version 1
 */
public class SimpleStackTest {
    /**
     * Тест наполнения контейнера и извлечения из него.
     */
    @Test(expected = NoSuchElementException.class)
    public void testPushStackAndPollStack() {
        SimpleStack<Integer> list = new SimpleStack<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(null);
        assertThat(list.get(0), is(IsNull.nullValue()));
        assertThat(list.get(1), is(3));
        assertThat(list.get(2), is(2));
        assertThat(list.get(3), is(1));
        assertThat(list.poll(), is(IsNull.nullValue()));
        assertThat(list.poll(), is(3));
        assertThat(list.poll(), is(2));
        assertThat(list.poll(), is(1));
        list.poll();
    }
}
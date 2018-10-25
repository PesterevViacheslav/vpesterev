package ru.job4j.list;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class SimpleQueueTest - Очередь. Автотесты для решения задач уровня Junior. Части 001. Collections. Pro.
 * 5.3.3.1 Очередь на двух стеках.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.10.2018
 * @version 1
 */
public class SimpleQueueTest {
    /**
     * Тест наполнения очереди.
     */
    @Test
    public void testEnqueueSimpleQueue() {
        SimpleQueue<Integer> q = new SimpleQueue<>();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(null);
        assertThat(q.get(0), is(IsNull.nullValue()));
        assertThat(q.get(1), is(3));
        assertThat(q.get(2), is(2));
        assertThat(q.get(3), is(1));
    }
    /**
     * Тест извлечения из очереди.
     */
    @Test
    public void testDequeueSimpleQueue() {
        SimpleQueue<Integer> q = new SimpleQueue<>();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(null);
        assertThat(q.poll(), is(1));
        assertThat(q.poll(), is(2));
        assertThat(q.poll(), is(3));
        assertThat(q.poll(), is(IsNull.nullValue()));
    }
}

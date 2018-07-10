package ru.job4j.search;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class PriorityQueueTest - Автотесты. Решение задачи Части 003. Collections. Lite Задача 1.2 Очередь с приоритетом на LinkedList.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.07.2018
 * @version 1
 */
public class PriorityQueueTest {
    @Test
    /**
     * Тест получения задачи с максимальным приоритетом
    */
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("priority1", 1));
        queue.put(new Task("priority2", 2));
        queue.put(new Task("priority3", 3));
        queue.put(new Task("priority1_1", 1));
        queue.put(new Task("priority1_2", 1));
        Task result = queue.take();
        assertThat(result.getDesc(), is("priority1_2"));
    }
    @Test
    /**
     * Тест получения задачи с минимальным приоритетом
     */
    public void whenLowerPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("priority1", 1));
        queue.put(new Task("priority2", 2));
        queue.put(new Task("priority3", 3));
        queue.put(new Task("priority5", 5));
        queue.put(new Task("priority1_2", 1));
        Task result = queue.takeLast();
        assertThat(result.getDesc(), is("priority5"));
    }
}
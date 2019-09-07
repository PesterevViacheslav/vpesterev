package ru.job4j.map;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * Class SimpleHashMapTest - Отображения. Автотесты для решения задач уровня Junior. Части 001. Collections. Pro.
 * 5.5.8. Реализовать собственную структуру данных - HashMap.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.11.2018
 * @version 1
 */
public class SimpleHashMapTest {
    /**
     * Тест наполнения контейнера с расширением
     */
    @Test
    public void testAddUser() {
        Calendar cal = new GregorianCalendar(1990, 3, 25);
        Calendar cal2 = new GregorianCalendar(1991, 3, 25);
        Calendar cal3 = new GregorianCalendar(1992, 2, 11);
        User user1 = new User("User1", 0, cal);
        User user2 = new User("User2", 0, cal2);
        User user3 = new User("Not Found", 0, cal3);
        SimpleHashMap<User, String> map = new SimpleHashMap<>();
        map.insert(user1, "Test1");
        map.insert(user2, "Test2");
        map.insert(user2, "Test3");
        assertThat(map.getCurrentCapacity(), is(2));
        assertThat(map.get(user3), is(IsNull.nullValue()));
        assertThat(map.get(user1), is("Test1"));
        assertThat(map.get(user2), is("Test2"));
    }
    /**
     * Тест наполнения контейнера с расширением
     */
    @Test
    public void testAddIntegerToExpand() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "Test1");
        map.insert(1, "Test2");
        map.insert(2, "Test3");
        assertThat(map.getCurrentCapacity(), is(2));
        assertThat(map.get(0), is(IsNull.nullValue()));
        assertThat(map.get(1), is("Test1"));
        assertThat(map.get(2), is("Test3"));
        map.insert(3, "Test4");
        assertThat(map.getCurrentCapacity(), is(3));
        assertThat(map.getCurrentMaxCapacity(), is(4));
        map.insert(4, "Test5");
        assertThat(map.getCurrentCapacity(), is(4));
        assertThat(map.getCurrentMaxCapacity(), is(8));
        map.insert(5, "Test6");
        map.insert(6, "Test7");
        map.insert(7, "Test8");
        map.insert(8, "Test9");
        map.insert(9, "Test9");
        map.insert(10, "Test10");
        map.insert(11, "Test11");
        map.insert(12, "Test12");
        assertThat(map.getCurrentCapacity(), is(12));
        assertThat(map.getCurrentMaxCapacity(), is(16));
    }
    /**
     * Тест удаления из контейнера.
     */
    @Test
    public void testDeleteFromMap() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "Test1");
        map.insert(2, "Test2");
        assertThat(map.getCurrentCapacity(), is(2));
        assertTrue(map.delete(1));
        assertFalse(map.delete(1));
        assertThat(map.get(1), is(IsNull.nullValue()));
        assertThat(map.getCurrentCapacity(), is(1));
        assertThat(map.getCurrentMaxCapacity(), is(4));
    }
    /**
     * Тест последовательного прохода по массиву.
     */
    @Test(expected = NoSuchElementException.class)
    public void testIteratorSequentiallyFetch() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        assertTrue(map.insert(1, "Test1"));
        assertTrue(map.insert(2, "Test2"));
        assertTrue(map.insert(3, "Test3"));
        assertThat(map.getCurrentCapacity(), is(3));
        assertThat(map.getCurrentMaxCapacity(), is(4));
        assertTrue(map.insert(4, "Test4"));
        assertThat(map.getCurrentCapacity(), is(4));
        assertThat(map.getCurrentMaxCapacity(), is(8));
        assertTrue(map.insert(7, "Test5"));
        Iterator<Integer> it = map.iterator();
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(4));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(7));
        MatcherAssert.assertThat(it.hasNext(), is(false));
        it.next();
    }
    /**
     * Тест последовательного прохода по массиву с модификацией.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void testIteratorConcurrentModificationException() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        assertTrue(map.insert(1, "Test1"));
        assertTrue(map.insert(2, "Test2"));
        assertTrue(map.insert(3, "Test3"));
        assertThat(map.getCurrentCapacity(), is(3));
        assertThat(map.getCurrentMaxCapacity(), is(4));
        assertTrue(map.insert(4, "Test4"));
        assertThat(map.getCurrentCapacity(), is(4));
        assertThat(map.getCurrentMaxCapacity(), is(8));
        assertTrue(map.insert(7, "Test5"));
        Iterator<Integer> it = map.iterator();
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(3));
        assertTrue(map.insert(5, "Test6"));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(4));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(7));
        MatcherAssert.assertThat(it.hasNext(), is(false));
        it.next();
    }
}
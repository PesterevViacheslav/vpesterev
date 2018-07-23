package ru.job4j.search;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class PriorityQueue - Очередь задач. Автотесты задачи Части 003. Collections. Lite.
 * Задача 3.1 Организовать сортировку User.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 22.07.2018
 * @version 1
 */
public class SortUserTest {
    @Test
    /**
     * Тест сортировки пользователей по возрасту
     */
    public void whenSortListByAgeThenSortedByAgeList() {
        SortUser list = new SortUser();
        List<User> input = new ArrayList<>();
        input.add(new User(2, "User2", "City2", 2));
        input.add(new User(3, "User3", "City3", 3));
        input.add(new User(1, "User1", "City1", 1));
        List<User> expect = new ArrayList<>();
        expect.add(new User(1, "User1", "City1", 1));
        expect.add(new User(2, "User2", "City2", 2));
        expect.add(new User(3, "User3", "City3", 3));
        Set<User> result = list.sort(input);
        assertThat(result.toArray(), is(expect.toArray()));
    }
    @Test
    /**
     * Тест сортировки пользователей по возрасту
     */
    public void whenSortListBySameAgeThenSortedByAgeAndIdList() {
        SortUser list = new SortUser();
        List<User> input = new ArrayList<>();
        input.add(new User(2, "User2", "City2", 2));
        input.add(new User(3, "User3", "City3", 3));
        input.add(new User(1, "User1", "City1", 3));
        List<User> expect = new ArrayList<>();
        expect.add(new User(2, "User2", "City2", 2));
        expect.add(new User(1, "User1", "City1", 3));
        expect.add(new User(3, "User3", "City3", 3));
        Set<User> result = list.sort(input);
        assertThat(result.toArray(), is(expect.toArray()));
    }
}

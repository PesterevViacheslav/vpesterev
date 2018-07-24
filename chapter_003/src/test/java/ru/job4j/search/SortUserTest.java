package ru.job4j.search;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class PriorityQueue - Очередь задач. Автотесты задачи Части 003. Collections. Lite.
 * Задача 3.1 Организовать сортировку User.
 * Задача 3.2. Сортировка User с использованием Comparator
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
    @Test
    /**
     * Тест сортировки пользователей по длине имени
     */
    public void whenSortByNameLengthThenSortedByNameLengthList() {
        SortUser list = new SortUser();
        List<User> input = new ArrayList<>();
        input.add(new User(2, "User20", "City2", 2));
        input.add(new User(3, "User3", "City3", 3));
        input.add(new User(1, "User100", "City1", 3));
        List<User> expect = new ArrayList<>();
        expect.add(new User(3, "User3", "City3", 3));
        expect.add(new User(2, "User20", "City2", 2));
        expect.add(new User(1, "User100", "City1", 3));
        List<User> result = list.sortNameLength(input);
        assertThat(result.toArray(), is(expect.toArray()));
    }
    @Test
    /**
     * Тест сортировки пользователей по имени и возрасту
     */
    public void whenSortByNameAndAgeThenSortedByNameAndAgeList() {
        SortUser list = new SortUser();
        List<User> input = new ArrayList<>();
        input.add(new User(1, "UserC", "City1", 3));
        input.add(new User(2, "UserA", "City3", 5));
        input.add(new User(3, "UserA", "City2", 3));
        input.add(new User(4, "UserB", "City3", 1));
        List<User> expect = new ArrayList<>();
        expect.add(new User(3, "UserA", "City2", 3));
        expect.add(new User(2, "UserA", "City3", 5));
        expect.add(new User(4, "UserB", "City3", 1));
        expect.add(new User(1, "UserC", "City1", 3));
        List<User> result = list.sortByAllFields(input);
        assertThat(result.toArray(), is(expect.toArray()));
    }
}

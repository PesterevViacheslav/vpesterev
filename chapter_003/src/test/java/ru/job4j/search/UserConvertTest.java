package ru.job4j.search;
/**
 * Class UserConvertTest. Автотесты для задачи Части 003. Collections. Lite.
 * Задача 2.2  Написать программу преобразования List в Map.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.07.2018
 * @version 1
 */
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class UserConvertTest {
    @Test
    /**
     * Тест конвертации List в Map различные пользователи
     */
    public void whenConvertList3DifferentUserThen3UserMap() {
        UserConvert map = new UserConvert();
        List<User> input = new ArrayList<>();
        input.add(new User(2, "User2", "City2"));
        input.add(new User(1, "User1", "City1"));
        input.add(new User(3, "User3", "City3"));
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(2, new User(2, "User2", "City2"));
        expect.put(1, new User(1, "User1", "City1"));
        expect.put(3, new User(3, "User3", "City3"));
        HashMap<Integer, User> result = map.process(input);
        assertThat(result, is(expect));
    }
    @Test
    /**
     * Тест конвертации List в Map одинаковые пользователи
     */
    public void whenConvertList3SameUserThen1UserMap() {
        UserConvert map = new UserConvert();
        List<User> input = new ArrayList<>();
        input.add(new User(1, "User1", "City1"));
        input.add(new User(1, "User1", "City1"));
        input.add(new User(1, "User1", "City1"));
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, new User(1, "User1", "City1"));
        HashMap<Integer, User> result = map.process(input);
        assertThat(result, is(expect));
    }
    @Test
    /**
     * Тест конвертации List в Map пользователи с одинаковыми ID
     */
    public void whenConvertList3User2SameIdThen2UserMap() {
        UserConvert map = new UserConvert();
        List<User> input = new ArrayList<>();
        input.add(new User(1, "User1", "City1"));
        input.add(new User(1, "User2", "City2"));
        input.add(new User(3, "User3", "City3"));
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, new User(1, "User2", "City2"));
        expect.put(3, new User(3, "User3", "City3"));
        HashMap<Integer, User> result = map.process(input);
        assertThat(result, is(expect));
    }
}
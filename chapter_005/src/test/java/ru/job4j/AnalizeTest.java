package ru.job4j;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Class AnalizeTest - Статистика изменения коллекций. Автотесты для задач уровня Junior. Части 001. Collections. Pro.
 * 5.7.1 Статистику по коллекции.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 03.12.2018
 * @version 1
 */
public class AnalizeTest {
    /**
     * Тест сравнения - коллекция без изменений.
     */
    @Test
    public void whenTheSameCollectionsThenNoDiff() {
        Analize a = new Analize();
        List<Analize.User> previous = new ArrayList<>();
        previous.add(new Analize.User(1, "User1"));
        previous.add(new Analize.User(2, "User2"));
        previous.add(new Analize.User(3, "User3"));
        List<Analize.User> current = new ArrayList<>();
        current.add(new Analize.User(3, "User3"));
        current.add(new Analize.User(2, "User2"));
        current.add(new Analize.User(1, "User1"));
        Analize.Info info = a.diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(0));
    }
    /**
     * Тест сравнения - коллекция с изменениями.
     */
    @Test
    public void whenNotTheSameCollectionsThenDiff() {
        Analize a = new Analize();
        List<Analize.User> previous = new ArrayList<>();
        previous.add(new Analize.User(1, "User1"));
        previous.add(new Analize.User(2, "User2"));
        previous.add(new Analize.User(3, "User3"));
        List<Analize.User> current = new ArrayList<>();
        current.add(new Analize.User(3, "User4"));
        current.add(new Analize.User(4, "User4"));
        current.add(new Analize.User(5, "User5"));
        current.add(new Analize.User(6, "User6"));
        Analize.Info info = a.diff(previous, current);
        assertThat(info.added, is(3));
        assertThat(info.changed, is(1));
        assertThat(info.deleted, is(2));
    }
}
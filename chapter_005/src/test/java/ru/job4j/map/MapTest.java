package ru.job4j.map;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class MapTest - Отображения. Автотесты для решения задач уровня Junior. Части 001. Collections. Pro.
 * 5.5.1. Создать модель User.
 * 5.5.2. Не перекрывать equals hashCode.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 04.11.2018
 * @version 1
 */
public class MapTest {
    /**
     * Тест непереопределенных Equals и HashCode.
     */
    @Test
    public void testNotOverrideEqualsAndHashCode() {
        Calendar cal = Calendar.getInstance();
        cal.set(1990, Calendar.JANUARY, 1);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(1990, Calendar.JANUARY, 1);
        User user1 = new User("User1", 0, cal);
        User user2 = new User("User1", 0, cal2);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "user1");
        map.put(user2, "user2");
        System.out.println("Первый вызов-----------------------------");
        System.out.println(map);
        System.out.println("Второй вызов, HashCode не изменился------");
        System.out.println(map);
        assertThat(map.size(), is(2));
    }
}

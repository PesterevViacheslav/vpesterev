package ru.job4j.jdbc;
import org.junit.Test;
import ru.job4j.tracker.Item;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * Class TrackerSQLTest - Автотесты - Работа трекера с БД. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.2. Трекер SQL.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.08.2019
 * @version 1
 */
public class TrackerSQLTest {
    /**
     * Тест коннекта к БД
     */
    @Test
    public void checkConnection() throws Exception {
        try (TrackerSQL sql = new TrackerSQL()) {
            assertThat(sql.init(), is(true));
        }
    }
    /**
     * Тест DML операций в БД
     */
    @Test
    public void testDML() throws Exception {
        try (TrackerSQL sql = new TrackerSQL()) {
            assertTrue(sql.init());
            sql.createTableIfNotExists();
            assertTrue(sql.tableExist("ITEM"));
            sql.truncate();
            assertThat(sql.size(), is(0));
            Item item = new Item("name1", "desc1");
            sql.add(item);
            Item item2 = new Item("name2", "desc2");
            sql.add(item2);
            Item item3 = new Item("name3", "desc3");
            sql.add(item3);
            assertThat(sql.size(), is(3));
            assertThat(sql.findById(item.getId()).getId(), is(item.getId()));
            assertThat(sql.findByName("name2").get(0).getId(), is(item2.getId()));
            Item item4 = new Item("name4", "desc4");
            assertTrue(sql.replace(item3.getId(), item4));
            assertThat(sql.findById(item4.getId()).getId(), is(item4.getId()));
            assertNull(sql.findById(item3.getId()));
            Item item5 = new Item("name5", "desc5");
            assertTrue(sql.change(item4.getId(), item5));
            assertThat(sql.findById(item4.getId()).getName(), is(item5.getName()));
            assertTrue(sql.delete(item4.getId()));
            assertNull(sql.findById(item4.getId()));
            assertThat(sql.size(), is(2));
        }
    }
}
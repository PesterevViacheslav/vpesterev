package ru.job4j.jdbc;
import org.junit.Test;
import ru.job4j.tracker.Item;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
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
     * Method init. Инициализация коннекта к БД.
     */
    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    /**
     * Тест коннекта к БД
     */
   /* @Test
    public void checkConnection() throws Exception {
        try (TrackerSQL sql = new TrackerSQL()) {
            assertThat(sql.init(), is(true));
        }
    }*/
    /**
     * Тест DML операций в БД
     */
    /*@Test
    public void testDML() throws Exception {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            assertTrue(sql.init());
            assertTrue(sql.tableExist("ITEM"));
            sql.truncate();
            assertThat(sql.size(), is(0));
            Item item = new Item("name1", "desc1");
            item = sql.add(item);
            Item item2 = new Item("name2", "desc2");
            item2 = sql.add(item2);
            Item item3 = new Item("name3", "desc3");
            item3 = sql.add(item3);
            assertThat(sql.size(), is(3));
            assertThat(sql.findById(item.getId()).getId(), is(item.getId()));
            assertThat(sql.findByName("name2").get(0).getId(), is(item2.getId()));
            Item item4 = new Item(Integer.toString(sql.getCurrentValue() + 1), "name4", "desc4", System.currentTimeMillis(), 0);
            assertTrue(sql.replace(item3.getId(), item4));
            assertThat(sql.findById(item4.getId()).getId(), is(item4.getId()));
            assertNull(sql.findById(item3.getId()));
            Item item5 = new Item(Integer.toString(sql.getCurrentValue() + 1), "name5", "desc5", System.currentTimeMillis(), 0);
            assertTrue(sql.change(item4.getId(), item5));
            assertThat(sql.findById(item4.getId()).getName(), is(item5.getName()));
            assertTrue(sql.delete(item4.getId()));
            assertNull(sql.findById(item4.getId()));
            assertThat(sql.size(), is(2));
        }
    }*/
}
package ru.job4j.jdbc;
import org.junit.Test;
import ru.job4j.jdbc.parser.Parser;
import ru.job4j.jdbc.parser.StoreDB;
import ru.job4j.jdbc.parser.Vacancy;
import java.sql.SQLException;
import static org.junit.Assert.assertTrue;
/**
 * Class TestParser - Автотесты для разбора страницы сайта. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.5.2. Парсер вакансий на sql.ru.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.09.2019
 * @version 1
 */
public class TestParser {
    /**
     * Тест работы парсера вакансий www.SQL.ru.
     */
/*    @Test
    public void testParserSqlRu() throws SQLException {
        StoreDB storeDB = new StoreDB();
        assertTrue(storeDB.init());
        storeDB.createTable();
        storeDB.truncate();
        Parser parser = new Parser();
        parser.saveToDB(storeDB);
        Vacancy vacancy = storeDB.add(new Vacancy("test", "test", "www.test.ru"));
        assertTrue(vacancy.getId() > 0);
        Vacancy vacancy2 = storeDB.add(new Vacancy("test", "test", "www.test.ru"));
        assertTrue(vacancy2.getId() == 0);
        assertTrue(storeDB.delete(vacancy.getId()));
    }*/
}
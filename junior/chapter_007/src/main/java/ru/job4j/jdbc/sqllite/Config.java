package ru.job4j.jdbc.sqllite;
import java.io.InputStream;
import java.util.Properties;
/**
 * Class Config - Получение конфигурации. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 24.08.2019
 * @version 1
 */
public class Config {
    private final Properties values = new Properties();
    /**
     * Method init. Инициализация параметров.
     */
    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    /**
     * Method get. Получение параметра.
     * @param key Название параметра.
     * @return Значение.
     */
    public String get(String key) {
        return this.values.getProperty(key);
    }
}
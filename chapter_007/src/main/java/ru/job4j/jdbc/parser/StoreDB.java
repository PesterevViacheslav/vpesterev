package ru.job4j.jdbc.parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.sql.TrackerSQLException;
import java.sql.*;
import java.io.InputStream;
import java.util.Properties;
/**
 * Class StoreDB - Работа с БД. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.5.2. Парсер вакансий на sql.ru.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.09.2019
 * @version 1
 */
public class StoreDB implements AutoCloseable {
   private Connection connection;
   private static final Logger LOG = LogManager.getLogger(StoreDB.class.getName());
    /**
     * Method init. Инициализация коннекта к БД.
     */
    public boolean init() {
        try (InputStream in = ru.job4j.jdbc.parser.StoreDB.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("parser-driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("parser-url"),
                    config.getProperty("parser-username"),
                    config.getProperty("parser-password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }
    /**
     * Method createTable. Создание таблицы VACANCY в БД при отсутствии.
     */
    public void createTable() throws SQLException {
        try (PreparedStatement sql =  this.connection.prepareStatement(String.format("%s %s %s %s", "CREATE TABLE IF NOT EXISTS VACANCY (id SERIAL PRIMARY KEY, ",
                "vacancy_name TEXT not null, ",
                "vacancy_description TEXT, ",
                "link TEXT)"))) {
            sql.executeUpdate();
            LOG.debug("Table Created");
        }
    }
    /**
     * Method truncate. Очистка таблицы VACANCY.
     */
    public void truncate() throws SQLException {
        try (PreparedStatement sql = this.connection.prepareStatement("TRUNCATE TABLE VACANCY")) {
            sql.executeUpdate();
            LOG.debug("Table Truncated");
        }
    }
    /**
     * Method size. Число строк в таблице VACANCY.
     * @return Число строк.
     */
    public int size() throws SQLException {
        int res = -1;
        try (PreparedStatement sql =  this.connection.prepareStatement("SELECT COUNT(1) AS cnt FROM VACANCY")) {
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                res = rs.getInt("cnt");
            }
        }
        return res;
    }
    /**
     * Method findByName. Поиск по NAME.
     * @param name Название вакансии.
     * @return Заявка
     */
    public Vacancy findByName(String name) {
        Vacancy res = null;
        try (PreparedStatement sql = this.connection.prepareStatement("SELECT * FROM VACANCY WHERE VACANCY_NAME = ?")) {
            sql.setString(1, name);
            try (ResultSet rs = sql.executeQuery()) {
                while (rs.next()) {
                    res = new Vacancy(rs.getString("vacancy_name"),
                                      rs.getString("vacancy_description"),
                                      rs.getString("link")
                                      );
                    res.setId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new TrackerSQLException(e.getSQLState());
        }
        LOG.debug("findByName res={}", res);
        return res;
    }
    /**
     * Method add. Добавление записи.
     * @param vacancy Вакансия.
     * @return Заявка
     */
    public Vacancy add(Vacancy vacancy) {
        if (findByName(vacancy.getName()) == null) {
            try (PreparedStatement sql = this.connection.prepareStatement("INSERT INTO VACANCY(vacancy_name, vacancy_description, link) VALUES(?,?,?)")) {
                sql.setString(1, vacancy.getName());
                sql.setString(2, vacancy.getDescription());
                sql.setString(3, vacancy.getLink());
                sql.executeUpdate();
                vacancy.setId(getCurrentValue());
            } catch (SQLException e) {
                throw new TrackerSQLException(e.getSQLState());
            }
        }
        LOG.debug("add vacancy={}", vacancy);
        return vacancy;
    }
    /**
     * Method delete. Удаление вакансии.
     * @param id ID вакансии.
     * @return Признак удалена ли запись
     */
    public boolean delete(int id) {
        boolean res = false;
        try (PreparedStatement sql = this.connection.prepareStatement("DELETE FROM VACANCY WHERE ID = ?")) {
            sql.setInt(1, id);
            sql.executeUpdate();
            if (sql.getUpdateCount() > 0) {
                res = true;
            }
        } catch (SQLException e) {
            throw new TrackerSQLException(e.getSQLState());
        }
        LOG.debug("delete res={}", res);
        return res;
    }
    /**
     * Method getCurrentValue. Получение текущего значение sequence.
     * @return id
     */
    public int getCurrentValue() throws SQLException {
        int res = -1;
        try (PreparedStatement sq = this.connection.prepareStatement("SELECT currval(pg_get_serial_sequence('vacancy', 'id')) AS id")) {
            try (ResultSet rs = sq.executeQuery()) {
                while (rs.next()) {
                    res = rs.getInt("id");
                }
            }
        }
        return res;
    }
    /**
     * Method close. Закрытие коннекта к БД.
     */
    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            this.connection.close();
        }
    }
}
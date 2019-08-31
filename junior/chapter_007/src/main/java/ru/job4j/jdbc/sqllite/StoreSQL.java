package ru.job4j.jdbc.sqllite;
import java.io.File;
import java.sql.*;
import java.util.*;
import ru.job4j.sql.TrackerSQLException;
/**
 * Class StoreSQL - Работа с БД. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 24.08.2019
 * @version 1
 */
public class StoreSQL implements AutoCloseable {
    private static final String DIR = System.getProperty("java.io.tmpdir");
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    public static final String PATH = String.join("", DIR + "db");
    private final Config config = new Config();
    private Connection connect;
    private final String url;
    /**
     * Method StoreSQL. Конструктор.
     */
    public StoreSQL() {
        this.config.init();
        this.url = String.join("", this.config.get("sqllite-url"), PATH, this.FILE_SEPARATOR, this.config.get("sqllite-db-name"));

    }
    /**
     * Method createNewDatabase. Создание БД.
     */
    public void createNewDatabase() {
        File rootDir = new File(PATH);
        if (!rootDir.exists()) {
            rootDir.mkdirs();
            System.out.println(this.url);
            try (Connection conn = DriverManager.getConnection(this.url)) {
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println("The driver name is " + meta.getDriverName());
                    System.out.println("A new database has been created.");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /**
     * Method connect. Коннект к БД.
     */
    public void connect() {
        try {
            this.connect = DriverManager.getConnection(this.url);
            this.connect.setAutoCommit(false);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TrackerSQLException(e.getMessage());
        }
    }
    /**
     * Method generate. Создание таблицы и заполнение данными.
     * @param size Число строк.
     */
    public void generate(int size) {
        try (PreparedStatement sql = this.connect.prepareStatement("CREATE TABLE IF NOT EXISTS ENTRY (id INTEGER, val TEXT)")) {
            sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TrackerSQLException(e.getSQLState());
        }
        try (PreparedStatement sql = this.connect.prepareStatement("INSERT INTO ENTRY VALUES(?,?)")) {
            for (int i = 0; i < size; i++) {
                sql.setInt(1, i);
                sql.setString(2, String.join("", "VAL_", Integer.toString(i)));
                sql.addBatch();
            }
            sql.executeBatch();
            this.connect.commit();
        } catch (SQLException e) {
            try {
                this.connect.rollback();
            } catch (SQLException er) {
                er.printStackTrace();
                throw new TrackerSQLException(e.getSQLState());
            }
            e.printStackTrace();
            throw new TrackerSQLException(e.getSQLState());
        }
    }
    /**
     * Method load. Выгрузка из БД.
     */
    public List<Map.Entry<Integer, String>> load() {
        List<Map.Entry<Integer, String>> res = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        try (PreparedStatement sql = this.connect.prepareStatement("SELECT * FROM ENTRY")) {
            try (ResultSet rs = sql.executeQuery()) {
                while (rs.next()) {
                    map.put(rs.getInt("id"), rs.getString("val"));
                }
            }
            for (Map.Entry<Integer, String> rowEntry : map.entrySet()) {
                res.add(rowEntry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TrackerSQLException(e.getSQLState());
        }
        return res;
    }
    /**
     * Method close. Закрытие коннекта к БД.
     */
    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }
}
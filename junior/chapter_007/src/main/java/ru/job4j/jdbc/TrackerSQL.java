package ru.job4j.jdbc;
import ru.job4j.sql.TrackerSQLException;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;
import java.sql.*;
import java.util.ArrayList;
import java.io.InputStream;
import java.util.Properties;
/**
 * Class TrackerSQL - Работа трекера с БД. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.2. Трекер SQL.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.08.2019
 * @version 1
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    private Connection connection;
    /**
     * Method init. Инициализация коннекта к БД.
     */
    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }
    /**
     * Method tableExist. Проверка наличия таблицы в БД.
     * @param tableName Название таблицы.
     * @return Наличие.
     */
    public boolean tableExist(String tableName) throws SQLException {
        boolean tExists = false;
        try (ResultSet rs = this.connection.getMetaData().getTables(null, null, tableName.toLowerCase(), null)) {
            while (rs.next()) {
                String tName = rs.getString("TABLE_NAME");
                if (tName != null && tName.toLowerCase().equals(tableName.toLowerCase())) {
                    tExists = true;
                    break;
                }
            }
        }
        return tExists;
    }
    /**
     * Method createTableIfNotExists. Создание таблицы ITEM в БД при отсутствии.
     */
    public void createTableIfNotExists() throws SQLException {
        if (!tableExist("ITEM")) {
            try (PreparedStatement sql =  this.connection.prepareStatement(String.format("%s %s %s %s %s", "CREATE TABLE ITEM (id SERIAL PRIMARY KEY, ",
                    "item_name TEXT not null, ",
                    "item_description TEXT, ",
                    "created TIMESTAMP not null, ",
                    "changed TIMESTAMP)"))) {
                sql.executeUpdate();
            }
        }
    }
    /**
     * Method truncate. Очистка таблицы ITEM.
     */
    public void truncate() throws SQLException {
        try (PreparedStatement sql = this.connection.prepareStatement("TRUNCATE TABLE ITEM")) {
            sql.executeUpdate();
        }
    }
    /**
     * Method size. Число строк в таблице ITEM.
     * @return Число строк.
     */
    public int size() throws SQLException {
        int res = -1;
        try (PreparedStatement sql =  this.connection.prepareStatement("SELECT COUNT(1) AS cnt FROM ITEM")) {
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                res = rs.getInt("cnt");
            }
        }
        return res;
    }
    /**
     * Method longToTimestamp. Формирование Timestamp для вставки в БД.
     * @return Число строк.
     */
    private Timestamp longToTimestamp(long lg) {
        Timestamp res = null;
        if (lg > 0) {
            res = new Timestamp(lg);
        }
        return res;
    }
    /**
     * Method timestampToLong. Формирование long из Timestamp при получении из БД.
     * @return Число строк.
     */
    private long timestampToLong(Timestamp ts) {
        long res = 0;
        if (ts != null) {
            res = ts.getTime();
        }
        return res;
    }
    /**
     * Method add. Добавление заявки.
     * @param item Заявка.
     * @return Заявка
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement sql = this.connection.prepareStatement("INSERT INTO ITEM(item_name, item_description, created, changed) VALUES(?,?,?,?)")) {
            //sql.setString(1, item.getId());
            sql.setString(1, item.getName());
            sql.setString(2, item.getDescription());
            sql.setTimestamp(3, longToTimestamp(item.getCreated()));
            sql.setTimestamp(4, longToTimestamp(item.getChanged()));
            sql.executeUpdate();
            item.setId(Integer.toString(getCurrentValue()));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TrackerSQLException(e.getSQLState());
        }
        return item;
    }
    /**
     * Method getCurrentValue. Получение текущего значение sequence.
     * @return id
     */
    public int getCurrentValue() throws SQLException {
        int res = -1;
        try (PreparedStatement sq = this.connection.prepareStatement("SELECT currval(pg_get_serial_sequence('item', 'id')) AS id")) {
            try (ResultSet rs = sq.executeQuery()) {
                while (rs.next()) {
                    res = rs.getInt("id");
                }
            }
        }
        return res;
    }

    /**
     * Method replace. Замена заявки.
     * @param id ID заявки.
     * @param item Заявка.
     * @return Признак найдена ли заявка
     */
    @Override
    public boolean replace(String id, Item item) {
        boolean res = false;
        try (PreparedStatement sql = this.connection.prepareStatement("UPDATE ITEM SET ID = ?, ITEM_NAME = ?, ITEM_DESCRIPTION = ?, CREATED = ?, CHANGED = ? WHERE ID = ?")) {
            sql.setInt(1, Integer.valueOf(item.getId()));
            sql.setString(2, item.getName());
            sql.setString(3, item.getDescription());
            sql.setTimestamp(4, longToTimestamp(item.getCreated()));
            sql.setTimestamp(5, longToTimestamp(item.getChanged()));
            sql.setInt(6, Integer.valueOf(id));
            sql.executeUpdate();
            if (sql.getUpdateCount() > 0) {
                res = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TrackerSQLException(e.getSQLState());
        }
        return res;
    }
    /**
     * Method delete. Удаление заявки.
     * @param id ID заявки.
     * @return Признак удалена ли заявка
     */
    @Override
    public boolean delete(String id) {
        boolean res = false;
        try (PreparedStatement sql = this.connection.prepareStatement("DELETE FROM ITEM WHERE ID = ?")) {
            sql.setInt(1, Integer.valueOf(id));
            sql.executeUpdate();
            if (sql.getUpdateCount() > 0) {
                res = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TrackerSQLException(e.getSQLState());
        }
        return res;
    }
    /**
     * Method findAll. Получение списка текущих заявок.
     * @return Заявки.
     */
    @Override
    public ArrayList<Item> findAll() {
        ArrayList<Item> res = new ArrayList<>();
        try (PreparedStatement sql = this.connection.prepareStatement("SELECT * FROM ITEM")) {
            try (ResultSet rs = sql.executeQuery()) {
                while (rs.next()) {
                    res.add(new Item(rs.getString("id"),
                            rs.getString("item_name"),
                            rs.getString("item_description"),
                            timestampToLong(rs.getTimestamp("created")),
                            timestampToLong(rs.getTimestamp("changed")))
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TrackerSQLException(e.getSQLState());
        }
        return res;
    }
    /**
     * Method findByName. Поиск заявки по NAME.
     * @param name ID заявки.
     * @return Заявка
     */
    @Override
    public ArrayList<Item> findByName(String name) {
        ArrayList<Item> res = new ArrayList<>();
        try (PreparedStatement sql = this.connection.prepareStatement("SELECT * FROM ITEM WHERE ITEM_NAME = ?")) {
            sql.setString(1, name);
            try (ResultSet rs = sql.executeQuery()) {
                while (rs.next()) {
                    res.add(new Item(rs.getString("id"),
                                    rs.getString("item_name"),
                                    rs.getString("item_description"),
                                    timestampToLong(rs.getTimestamp("created")),
                                    timestampToLong(rs.getTimestamp("changed"))
                            )
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TrackerSQLException(e.getSQLState());
        }
        return res;
    }
    /**
     * Method findById. Поиск заявки по ID.
     * @param id ID заявки.
     * @return Заявка
     */
    @Override
    public Item findById(String id) {
        Item res = null;
        try (PreparedStatement sql = this.connection.prepareStatement("SELECT * FROM ITEM WHERE ID = ?")) {
            sql.setInt(1, Integer.valueOf(id));
            try (ResultSet rs = sql.executeQuery()) {
                while (rs.next()) {
                    res = new Item(Integer.toString(rs.getInt("id")),
                            rs.getString("item_name"),
                            rs.getString("item_description"),
                            timestampToLong(rs.getTimestamp("created")),
                            timestampToLong(rs.getTimestamp("changed"))
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TrackerSQLException(e.getSQLState());
        }
        return res;
    }
    /**
     * Method change. Изменение заявки.
     * @param id ID заявки.
     * @param item Заявка.
     * @return Признак найдена ли заявка
     */
    @Override
    public boolean change(String id, Item item) {
        boolean res = false;
        try (PreparedStatement sql = this.connection.prepareStatement("UPDATE ITEM SET ITEM_NAME = ?, ITEM_DESCRIPTION = ?, CREATED = ?, CHANGED = ? WHERE ID = ?")) {
            sql.setString(1, item.getName());
            sql.setString(2, item.getDescription());
            sql.setTimestamp(3, longToTimestamp(item.getCreated()));
            sql.setTimestamp(4, longToTimestamp(item.getChanged()));
            sql.setInt(5, Integer.valueOf(id));
            sql.executeUpdate();
            if (sql.getUpdateCount() > 0) {
                res = true;
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
        if (this.connection != null) {
            this.connection.close();
        }
    }
}
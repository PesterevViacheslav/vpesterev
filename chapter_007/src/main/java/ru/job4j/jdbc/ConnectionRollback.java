package ru.job4j.jdbc;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * Class ConnectionRollback - Коннект к БД с возможностью отката. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.4. Liquibase. Интеграционные тесты. Proxy.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.08.2019
 * @version 1
 */
public class ConnectionRollback {
    /**
     * Method create. Create connection with autocommit=false mode and rollback call, when connection is closed.
     * @param connection connection.
     * @return Connection object.
     * @throws SQLException possible exception.
     */
    public static Connection create(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        return (Connection) Proxy.newProxyInstance(
                ConnectionRollback.class.getClassLoader(),
                new Class[] {
                    Connection.class
                },
                (proxy, method, args) -> {
                    Object rsl = null;
                    if ("close".equals(method.getName())) {
                        connection.rollback();
                        connection.close();
                    } else {
                        rsl = method.invoke(connection, args);
                    }
                    return rsl;
                }
        );
    }
}
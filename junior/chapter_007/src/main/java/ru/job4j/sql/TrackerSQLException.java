package ru.job4j.sql;
/**
 * Class TrackerSQLException - Исключение при выполнении SQL. ешение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.2. Трекер SQL.
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 11.08.2019
 * @version 1
 */
public class TrackerSQLException extends RuntimeException {
    public TrackerSQLException(String msg) {
        super(msg);
    }
}

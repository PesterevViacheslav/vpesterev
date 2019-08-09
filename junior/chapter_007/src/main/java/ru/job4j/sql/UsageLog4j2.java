package ru.job4j.sql;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * Class UsageLog4j2 - Аргументы для метода архивации. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.1. Log4j Логирование системы.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 09.08.2019
 * @version 1
 */
public class UsageLog4j2 {
    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());
    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
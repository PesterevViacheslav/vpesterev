package ru.job4j.jdbc.parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import ru.job4j.sql.TrackerSQLException;
import java.sql.SQLException;
/**
 * Class ParseJob - Задание. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.5.2. Парсер вакансий на sql.ru.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 17.09.2019
 * @version 1
 */
public class ParseJob implements Job {
    private static final Logger LOG = LogManager.getLogger(ParseJob.class.getName());
    /**
     * Method execute. Тело задания.
     */
    public void execute(JobExecutionContext context) {
        LOG.debug("job execute");
        try {
            StoreDB storeDB = new StoreDB();
            storeDB.init();
            storeDB.createTable();
            Parser parser = new Parser();
            parser.saveToDB(storeDB);
        } catch (SQLException e) {
            LOG.error("job execute {}", e.getMessage());
            e.printStackTrace();
            throw new TrackerSQLException(e.getSQLState());
        }
    }
}
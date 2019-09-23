package ru.job4j.jdbc.sqlruparser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.io.InputStream;
import java.util.Properties;
/**
 * Class ScheduleJob - Планировщик. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.5.2. Парсер вакансий на sql.ru.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 17.09.2019
 * @version 1
 */
public class ScheduleJob {
    private static final Logger LOG = LogManager.getLogger(ScheduleJob.class.getName());
    /**
     * Method main. Запуск задания.
     * Формат расписания (пример "0/5 * * * * ?" - раз в 5 сек)
     * - Секунды
     * - Минуты
     * - Часы
     * - День месяца
     * - Месяц
     * - День недели
     * - Год (необязательное поле)
     * Символ косая черта (/) обозначает приращение значения. Например, "5/15" в поле "секунды" означает каждые 15 секунд, начиная с пятой секунды.
     * Знак вопроса (?) и букву L (L) разрешается использовать только в полях "день месяца" и "день недели". Знак вопроса означает, что в поле не должно быть указанной величины. Таким образом, если вы устанавливаете день недели, вы можете вставить "?" в поле "день недели" для обозначения того, что значение "день недели" несущественно. Буква L - это сокращение от last (последний). Если она помещается в поле "день месяца", задание будет запланировано на последний день месяца. В поле "день недели" "L" равнозначно "7", если помещается само по себе, или означает последний экземпляр "дня недели" в этом месяце. Так, "0L" запланирует выполнение задания на последнее воскресенье данного месяца.
     * Буква W (W) в поле "день месяца" планирует выполнение задания на ближайший к заданному значению рабочий день. Введя "1W" в поле "день месяца" вы планируете выполнение задания на рабочий день, ближайший к первому числу месяца.
     * Знак фунта (#) устанавливает конкретный рабочий день данного месяца. Ввод "MON#2" в поле "день недели" планирует задание на второй понедельник месяца.
     * Знак астериска (*) является подстановочным знаком и обозначает, что любое возможное значение может быть принято для данного отдельного поля.
     */
    public static void main(String[] args) throws SchedulerException {
        String cronSchedule;
        try (InputStream in = ru.job4j.jdbc.sqlruparser.StoreDB.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            cronSchedule = config.getProperty("parser-cron-time");
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new IllegalStateException(e);
        }
        JobDetail job = JobBuilder.newJob(ParseJob.class)
                .withIdentity("parseJob", "parseGroup").build();
        LOG.debug("runJob {}", job.toString());
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("parseTrigger", "parseGroup")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule(cronSchedule))
                .build();
        LOG.debug("runJob trigger {}", trigger.toString());

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        LOG.debug("runJob scheduler {}", scheduler.getSchedulerName());
        scheduler.start();
        LOG.debug("runJob scheduler start");
        scheduler.scheduleJob(job, trigger);
        LOG.debug("runJob scheduleJob finished {}", scheduler.getJobDetail(job.getKey()));
    }
}
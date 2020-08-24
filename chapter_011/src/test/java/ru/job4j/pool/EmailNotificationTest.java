package ru.job4j.pool;
import org.junit.Test;
/**
 * Class EmailNotificationTest - Отправка почты. Автотесты для решения задач уровня Middle. Части 011. Multithreading.
 * Пулы. 2. ExecutorService рассылка почты.[#283060]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.08.2020
 * @version 1
 */
public class EmailNotificationTest {
    /**
     * Тест работы с пулом потоков.
     */
    @Test
    public void testThreadPool() throws InterruptedException {
        EmailNotification exec = new EmailNotification();
        exec.emailTo(new EmailNotification.User("User1", "email1"));
        exec.emailTo(new EmailNotification.User("User2", "email2"));
        exec.emailTo(new EmailNotification.User("User3", "email3"));
        exec.emailTo(new EmailNotification.User("User4", "email4"));
        exec.emailTo(new EmailNotification.User("User5", "email5"));
        exec.emailTo(new EmailNotification.User("User6", "email6"));
        exec.emailTo(new EmailNotification.User("User7", "email7"));
        exec.emailTo(new EmailNotification.User("User8", "email8"));
        exec.emailTo(new EmailNotification.User("User9", "email9"));
        Thread.currentThread().join(1000);
        exec.close();
        Thread.currentThread().join(1000);
    }
}
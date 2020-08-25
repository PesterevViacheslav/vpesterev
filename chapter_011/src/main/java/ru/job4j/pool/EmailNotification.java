package ru.job4j.pool;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Class EmailNotification - Отправка почты. Решение задач уровня Middle. Части 011. Multithreading.
 * Пулы. 2. ExecutorService рассылка почты.[#283060]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.08.2020
 * @version 1
 */
public class EmailNotification {
    private final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    /**
     * Метод emailTo. Постановка задания на отправку емейл.
     * @param user Пользователь.
     */
    public void emailTo(User user) {
        String subject = String.format("Notification %s to email %s.", user.username, user.email);
        String body = String.format("Add a new event to %s", user.username);
        pool.submit(() -> {
            send(subject, body, user.email);
        });
    }
    /**
     * Метод send. Отправка емейл.
     * @param subject Тема.
     * @param body Тело письма.
     * @param email Адрес.
     */
    private void send(String subject, String body, String email){
    }
    /**
     * Метод close. Остановка пула.
     */
    public void close() {
        this.pool.shutdown();
        while (!this.pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    /**
     * Class Пользователь.
     */
    public static class User {
        final String username;
        final String email;
        public User(String username, String email) {
            this.username = username;
            this.email = email;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(username, user.username) &&  Objects.equals(email, user.email);
        }
        @Override
        public int hashCode() {
            return Objects.hash(username, email);
        }
        @Override
        public String toString() {
            return "User{" + "username='" + username + '\'' + ", email='" + email + '\'' + '}';
        }
    }
}
package ru.job4j.pool;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Class EmailNotification - Отправка почты. Решение задач уровня Middle. Части 001. Multithreading.
 * 10.6.2. ExecutorService рассылка почты.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.01.2019
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
            System.out.println("Execute " + Thread.currentThread().getName());
            send(subject, body, user.email);
        });
    }
    /**
     * Метод send. Отправка емейл.
     * @param subject Тема.
     * @param body Тело письма.
     * @param email Адрес.
     */
    private void send(String subject, String body, String email) {
        System.out.println("SEND Email: " + subject);
    }
    /**
     * Метод close. Остановка пула.
     */
    public void close() {
        this.pool.shutdown();
        System.out.println("Shutdown");
        while (!this.pool.isTerminated()) {
            try {
                System.out.println("SLEEP");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
        System.out.println("isTerminated=" + this.pool.isTerminated());
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
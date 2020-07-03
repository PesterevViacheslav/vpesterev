package ru.job4j.concurrent;
import java.util.List;
/**
 * Class ShareNotSafe - Демонстрация работы с кешем. Решение задач уровня Middle. Части 011. Multithreading.
 * 4. Thread без общих ресурсов[#283079]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 03.07.2020
 * @version 1
 */
public class ShareNotSafe {
    public static void main(String[] args) throws InterruptedException {
        UserCache cache = new UserCache();
        User user = User.of("name");
        cache.add(user);
        Thread first = new Thread(
                () -> {
                    User user2 = User.of("name2");
                    cache.add(user2);

                    List<User> list = cache.findAll();
                    System.out.println(cache.findAll());
                    list.set(1, User.of("test2"));
                    System.out.println(list);

                }
        );
        Thread second = new Thread(
                () -> {
                    User user2 = User.of("name3");
                    cache.add(user2);
                    List<User> list = cache.findAll();
                    System.out.println(cache.findAll());
                    list.set(1, User.of("test3"));
                    System.out.println(list);

                }
        );
        first.start();
        first.join();
        second.start();
        second.join();
        System.out.println(cache.findAll());
    }
}
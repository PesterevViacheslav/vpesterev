package ru.job4j.concurrent;
import net.jcip.annotations.NotThreadSafe;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Class UserCache - Кеш пользователей. Решение задач уровня Middle. Части 011. Multithreading.
 * 4. Thread без общих ресурсов[#283079]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 03.07.2020
 * @version 1
 */
@NotThreadSafe
public class UserCache {
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();
    private final AtomicInteger id = new AtomicInteger();
    /**
     * Method add. Добавление в кеш
     * @param user Пользователь
     */
    public void add(User user) {
        users.put(id.incrementAndGet(), User.of(user.getName()));
        //users.put(id.incrementAndGet(), user);
    }
    /**
     * Method findById. Поиск по Id
     * @param id
     * @return Пользователь
     */
    public User findById(int id) {
        return User.of(users.get(id).getName());
    }
    /**
     * Method findAll. Отображение кеша
     * @return Коллекция подбзователей
     */
    public List<User> findAll() {
        List<User> res = new ArrayList<>();
        for (User u : users.values()) {
            res.add(User.of(u.getName()));
        }
        return res;
    }
}
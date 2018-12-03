package ru.job4j;
import java.util.*;
/**
 * Class Analize - Статистика изменения коллекций. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.7.1 Статистику по коллекции.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 03.12.2018
 * @version 1
 */
public class Analize {
    /**
     * Метод diff. Вычисление разницы.
     * @param previous Коллекция до изменения.
     * @param current Коллекция после изменения.
     */
    public Info diff(List<User> previous, List<User> current) {
        Info res = new Info();
        Map<Integer, User> map = new TreeMap<>();
        User tst;
        for (User user : previous) {
            map.put(user.id, user);
        }
        for (User user : current) {
            tst = map.remove(user.id);
            if (tst == null) {
                res.added++;
            } else if (!tst.equals(user)) {
                res.changed++;
            }
        }
        res.deleted = map.size();
        return res;
    }
    /**
     * Class User. Пользователь.
     */
    public static class User {
        int id;
        String name;
        User(int id, String name) {
            this.id = id;
            this.name = name;
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
            return id == user.id && Objects.equals(name, user.name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }
    /**
     * Class Info. Статистика.
     */
    public static class Info {
        int added = 0;
        int changed = 0;
        int deleted = 0;
    }
}
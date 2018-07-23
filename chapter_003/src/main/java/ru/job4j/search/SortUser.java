package ru.job4j.search;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 * Class PriorityQueue - Очередь задач. Решение задачи Части 003. Collections. Lite.
 * Задача 3.1 Организовать сортировку User.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 22.07.2018
 * @version 1
 */
public class SortUser {
    public Set<User> sort(List<User> list) {
        TreeSet<User> result = new TreeSet<>();
        for (User user : list) {
            result.add(user);
        }
        return result;
    }
}
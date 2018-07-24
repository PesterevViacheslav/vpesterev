package ru.job4j.search;
import java.util.*;
/**
 * Class PriorityQueue - Очередь задач. Решение задачи Части 003. Collections. Lite.
 * Задача 3.1 Организовать сортировку User.
 * Задача 3.2. Сортировка User с использованием Comparator
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 22.07.2018
 * @version 1
 */
public class SortUser {
    /**
     * Method sort. Сортировка списка.
     * @param list Список.
     * @return Отсортированнный список.
    */
    public Set<User> sort(List<User> list) {
        TreeSet<User> result = new TreeSet<>();
        for (User user : list) {
            result.add(user);
        }
        return result;
    }
    /**
     * Method sortNameLength. Сортировка списка по длине имени.
     * @param list Список.
     * @return Отсортированнный список.
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return list;
    }
    /**
     * Method sortByAllFields. Сортировка списка по имени и возрасту.
     * @param list Список.
     * @return Отсортированнный список.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result;
                result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result : o1.getAge() - o2.getAge();
            }
        });
        return list;
}
}
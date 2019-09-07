package ru.job4j.search;
import java.util.HashMap;
import java.util.List;
/**
 * Class UserConvert. Решение задачи Части 003. Collections. Lite.
 * Задача 2.2  Написать программу преобразования List в Map.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.07.2018
 * @version 1
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
package ru.job4j.hierarchy;
import java.util.*;
/**
 * Class Hierarchy. Решение задач Части 003. Collections. Lite.
 * Задача 5.4 Отсортировать департаменты.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.09.2018
 * @version 1
 */
public class Hierarchy {
    /**
     * Method parse. Разбор массива строк.
     * @param str Массив строк.
     */
    public String[] parse(String[] str) {
        Set<String> res = new TreeSet<>();
        for (String s : str) {
            String tmp = "";
            for (int i = 0; i < s.length(); i++) {
                tmp += s.charAt(i);
                if (s.charAt(i) == '\\') {
                    if (tmp.endsWith("\\")) {
                        res.add(tmp.substring(0, tmp.length() - 1));
                    } else {
                        res.add(tmp);
                    }
                }
            }
            if (tmp.endsWith("\\")) {
                tmp = tmp.substring(0, tmp.length() - 1);
            }
            res.add(tmp);
        }
        return res.toArray(new String[0]);
    }
    /**
     * Method sortAsc. Сортировка списка по возрастанию.
     * @params str Массив строк.
     * @return Отсортированнный список.
     */
    public String[] sortAsc(String[] str) {
        String[] res = parse(str);
        Arrays.sort(res);
        return res;
    }
    /**
     * Method sortDesc. Сортировка списка по убыванию.
     * @params str Массив строк.
     * @return Отсортированнный список.
     */
    public String[] sortDesc(String[] str) {
        String[] res = parse(str);
        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = 0;
                for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                    if (o1.charAt(i) != o2.charAt(i)) {
                        res = Character.compare(o2.charAt(i), o1.charAt(i));
                        break;
                    }
                }
                if (res == 0 && o1.length() != o2.length()) {
                    res = Integer.compare(o1.length(), o2.length());
                }
                return res;
            }
        });
        return res;
    }
}
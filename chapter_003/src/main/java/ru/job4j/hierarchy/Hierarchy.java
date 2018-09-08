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
    private ArrayList<String> array = new ArrayList<>();
    /**
     * Method Hierarchy. Конструктор.
     * @param list Массив строк.
     */
    public Hierarchy(ArrayList<String> list) {
        for (String s : list) {
            this.array.addAll(parse(s));
        }
    }
    /**
     * Method Parse. Разбор строки.
     * @param s Строка.
     * @return Массив элементов.
     */
    public ArrayList<String> parse(String s) {
        String tmp = "";
        ArrayList<String> res = new ArrayList<>();
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
        return res;
    }
    /**
     * Method sortAsc. Сортировка списка по возрастанию.
     * @return Отсортированнный список.
     */
    public Set<String> sortAsc() {
        TreeSet<String> tree = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        tree.addAll(array);
        return tree;
    }
    /**
     * Method sortDesc. Сортировка списка по убыванию.
     * @return Отсортированнный список.
     */
    public Set<String> sortDesc() {
        TreeSet<String> tree = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = 0;
                ArrayList<String> array1 = parse(o1);
                ArrayList<String> array2 = parse(o2);
                for (int i = 0; i < Math.min(array1.size(), array2.size()); i++) {
                    if (array1.get(i).compareTo(array2.get(i)) < 0) {
                        res = 1;
                        break;
                    } else if (array1.get(i).compareTo(array2.get(i)) > 0) {
                        res = -1;
                        break;
                    } else {
                        res = 0;
                    }
                }
                if (res == 0) {
                    if (array1.size() > array2.size()) {
                        res = 1;
                    }
                    if (array1.size() < array2.size()) {
                        res = -1;
                    }
                }
                return res;
            }
        });
        tree.addAll(array);
        return tree;
    }
}
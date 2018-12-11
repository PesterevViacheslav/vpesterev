package ru.job4j;
import java.util.*;
/**
 * Class Diff - Сравнение слов. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.7.3 Дополнительная задача - Сравнить два слова на совпадение набора символов.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 11.12.2018
 * @version 1
 */
public class Diff {
    /**
     * Метод is_Diff. Вычисление разницы.
     * @param first Первое слово.
     * @param second Второе слово.
     */
    public boolean isDiff(String first, String second) {
        boolean res = false;
        Map<Character, Obj> map = new HashMap<>();
        Obj tmp;
        for (int i = 0; i < first.length(); i++) {
            tmp = map.get(first.charAt(i));
            if (tmp == null) {
                map.put(first.charAt(i), new Obj(0, first.charAt(i)));
            } else {
                tmp.counter++;
            }
        }
        boolean exit = false;
        for (int i = 0; i < second.length(); i++) {
            tmp = map.get(second.charAt(i));
            if (tmp == null) {
                exit = true;
                break;
            } else if (tmp.counter > 0) {
              tmp.counter--;
            } else {
                map.remove(tmp.value);
            }
        }
        if (map.size() == 0 && !exit) {
            res = true;
        }
        return res;
    }
    /**
     * Class Объект.
     */
    public static class Obj {
        int counter;
        Character value;
        Obj(int counter, Character value) {
            this.counter = counter;
            this.value = value;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Obj user = (Obj) o;
            return Objects.equals(value, user.value);
        }
        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
        @Override
        public String toString() {
            return "User{" + "id=" + counter + ", name='" + value + '\'' + '}';
        }
    }
}
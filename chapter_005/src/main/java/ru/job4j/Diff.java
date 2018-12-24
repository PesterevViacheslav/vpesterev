package ru.job4j;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Class Diff - Сравнение слов. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.7.3 Дополнительная задача - Сравнить два слова на совпадение набора символов.
 * 5.7.4 Дополнительная задача - Сравнить два слова, проверить на то, что они отличаются только одной перестановкой символов
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
        return first.chars().mapToObj(i -> (char) i).sorted().collect(Collectors.toList()).equals(second.chars().mapToObj(i -> (char) i).sorted().collect(Collectors.toList()));
    }
    /**
     * Метод hasOneShift. Проверка на наличие одной перестановки символов.
     * @param first Первое слово.
     * @param second Второе слово.
     */
    public boolean hasOneShift(String first, String second) {
        boolean res = false;
        Queue<Character> qFirst = new ArrayDeque<>();
        Queue<Character> qSecond = new ArrayDeque<>();
        Character tmpFirst = null;
        Character tmpSecond = null;
        int counter = 0;
        for (int i = 0; i < first.length(); i++) {
            qFirst.add(first.charAt(i));
        }
        for (int i = 0; i < second.length(); i++) {
            qSecond.add(second.charAt(i));
        }
        for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
            if (tmpFirst != null && tmpFirst.equals(qSecond.peek()) && tmpSecond.equals(qFirst.peek())) {
                res = true;
                counter++;
            }
            if (counter > 1 || first.length() != second.length()) {
                res = false;
                break;
            }
            if (qFirst.peek().equals(qSecond.peek())) {
                qFirst.poll();
                qSecond.poll();
            } else {
                tmpFirst = qFirst.poll();
                tmpSecond = qSecond.poll();
            }
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
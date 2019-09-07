package ru.job4j.search;
import java.util.ArrayList;
import java.util.List;
/**
 * Class ConvertMatrix2List. Решение задачи Части 003. Collections. Lite Задача 1.4. двумерного массива в ArrayList.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 13.07.2018
 * @version 1
 */
public class ConvertMatrix2List {
    /**
     * Method toList. Преобразование массива в ArrayList.
     * @param array Массив.
     * @return Коллекция.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}

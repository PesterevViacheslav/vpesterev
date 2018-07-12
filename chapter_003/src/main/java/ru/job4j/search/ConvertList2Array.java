package ru.job4j.search;
/**
 * Class ConvertList2Array. Решение задачи Части 003. Collections. Lite Задача 1.3. Конвертация ArrayList в двухмерный массив.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.07.2018
 * @version 1
 */
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int i = 0;
        int j = 0;
        int counter = 0;
        int cells = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        for (Integer arr : list) {
            array[i][j] = arr;
            counter++;
            if (Math.floorMod(counter, cells) == 0) {
                i++;
                j = 0;
            } else {
                j++;
            }
        }
        return array;
    }
}
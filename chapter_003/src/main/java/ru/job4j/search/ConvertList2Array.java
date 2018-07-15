package ru.job4j.search;
/**
 * Class ConvertList2Array. Решение задач Части 003. Collections. Lite.
 * Задача 1.3. Конвертация ArrayList в двухмерный массив.
 * Задача 2.1. Конвертация листа массивов в один лист Integer.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.07.2018
 * @version 1
 */
import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    /**
     * Method toArray. Преобразование ArrayList в двумерный массив.
     * @param list ArrayList.
     * @return Двумерный массив.
     */
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
    /**
     * Method convert. Конвертация листа массивов в один лист Integer.
     * @param list Список массивов.
     * @return Коллекция.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int value : array) {
                result.add(value);
            }
        }
        return result;
    }
}
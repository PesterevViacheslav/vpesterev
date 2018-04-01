package ru.job4j.array;

/**
 * Class BubbleSort решение задачи Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.04.2018
 * @version 1
 */
public class BubbleSort {
    /**
     * Method sort. Сорттировка массива методом пузырька.
     * @param array Массив элементов.
     * @return Отсортированный массив.
     */
    public int[] sort(int[] array) {
        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}

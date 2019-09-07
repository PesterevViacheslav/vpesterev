package ru.job4j.array;
/**
 * Class Turn решение задачи Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 30.03.2018
 * @version 1
 */
public class Turn {
    /**
     * Method turn. Переворачивание массива.
     * @param array Массив элементов.
     * @return Массив значений.
     */
    public int[] turn(int[] array) {
        int tmp;
        int half = array.length / 2;
        for (int i = 0; i < half; i++) {
            tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return array;
    }
}
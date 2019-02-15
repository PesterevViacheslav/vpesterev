package ru.job4j.array;
/**
 * Class Square решение задачи Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 28.03.2018
 * @version 1
 */
public class Square {
    /**
     * Method calculate. Возведение в квадрат элементов массива.
     * @param bound Размер массива.
     * @return Массив значений.
     */
    public int[] calculate(int bound) {
        int size = bound <= 0 ? 1 : bound;
        int[] result = new int[size];
        if (bound > 0) {
            for (int i = 0; i < bound; i++) {
                result[i] = (int) Math.pow(i + 1, 2);
            }
        } else {
            result[0] = -1;
        }
        return result;
    }
}
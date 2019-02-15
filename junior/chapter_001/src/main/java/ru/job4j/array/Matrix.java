package ru.job4j.array;
/**
 * Class Matrix решение задачи Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.04.2018
 * @version 1
 */
public class Matrix {
    /**
     * Method multiple. Постороение таблицы умножения.
     * @param size Размер таблицы.
     * @return Массив с таблицей умножения.
     */
    public int[][] multiple(int size) {
        int[][] result = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                result[i - 1][j - 1] = i * j;
            }
        }
        return result;
    }
}

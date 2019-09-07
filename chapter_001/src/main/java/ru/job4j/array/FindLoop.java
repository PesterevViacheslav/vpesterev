package ru.job4j.array;
/**
 * Class FindLoop решение задачи Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 30.03.2018
 * @version 1
 */
public class FindLoop {
    /**
     * Method indexOf. Поиск элемента в массиве.
     * @param data Массив элементов.
     * @param el Элемент поиска
     * @return Массив значений.
     */
    public int indexOf(int[] data, int el) {
        int result = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                result = i;
                break;
            }
        }
        return result;
    }
}
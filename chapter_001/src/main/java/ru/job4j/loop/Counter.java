package ru.job4j.loop;
/**
 * Class Counter решение задач Части 001. Базовый синтаксис урок 5.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 23.03.2018
 * @version 1
 */
public class Counter {
    /**
     * Method add. Определение суммы нечетных чисел в диапазоне.
     * @param start Начало диапазона.
     * @param finish Конец диапазона.
     * @return Сумма нечетных чисел.
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    };
}
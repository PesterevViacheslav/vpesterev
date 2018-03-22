package ru.job4j.max;

/**
 * Class Max решение задач Части 001. Базовый синтаксис урок 4.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 20.03.2018
 * @version 1
 */
public class Max {

    /**
     * Method max. Определение максимума из двух чисел.
     * @param first Первое число.
     * @param second Второе число.
     * @return Максимальное число.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Method max. Определение максимума из трех чисел.
     * @param first Первое число.
     * @param second Второе число.
     * @param third Третье число.
     * @return Максимальное число.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}

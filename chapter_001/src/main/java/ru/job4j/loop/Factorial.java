package ru.job4j.loop;
/**
 * Class Factorial решение задач Части 001. Базовый синтаксис урок 5.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 24.03.2018
 * @version 1
 */
public class Factorial {
    /**
     * Method calc. Определение факториала.
     * @param n Факториал данного числа.
     * @return Факториал.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
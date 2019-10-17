package ru.job4j.calculator;
/**
 * Class Calculator решение задачи Части 001. Базовый синтаксис урок 3.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 13.03.2018
 * @version 1
 */
public class Calculator {
    protected double result;
    /**
     * Method add. Сумма двух элементов.
     * @param  first - Первое слагаемое.
     * @param  second - Второе слагаемое.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Method minus. Разность двух элементов.
     * @param  first -  Уменьшаемое.
     * @param  second - Вычитаемое.
     */
    public void minus(double first, double second) {
        this.result = first - second;
    }
    /**
     * Method multiply. Произведение двух элементов.
     * @param  first - Первый множитель.
     * @param  second - Второй множитель.
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }
    /**
     * Method divide. Деление двух элементов.
     * @param  first - Делимое.
     * @param  second - Делитель.
     */
    public void divide(double first, double second) {
        this.result = first / second;
    }
    /**
     * Method getResult. Получение результата.
     * @return  Результат вычислений.
     */
    public double getResult() {
        return this.result;
    }
}
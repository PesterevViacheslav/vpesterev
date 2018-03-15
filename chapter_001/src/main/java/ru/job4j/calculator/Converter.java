package ru.job4j.calculator;
/**
 * Class Converter решение задачи Части 001. Базовый синтаксис урок 3.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.03.2018
 * @version 1
 */
public class Converter {
    private static final int EURO_TO_RUBLE_RATE = 70;
    private static final int DOLLAR_TO_RUBLE_RATE = 60;

    /**
     * Method rubleToEuro. Конвертирут рубли в евро.
     * @param value - Сумма в рублях.
     * @return Сумма в евро.
     */
    public int rubleToEuro(int value) {
        return value/EURO_TO_RUBLE_RATE;
    }

    /**
     * Method rubleToDollar. Конвертирут рубли в доллары.
     * @param value - Сумма в рублях.
     * @return Сумма в долларах.
     */
    public int rubleToDollar(int value) {
        return value/DOLLAR_TO_RUBLE_RATE;
    }

    /**
     * Method euroToRuble. Конвертирут евро в рубли.
     * @param value - Сумма в евро.
     * @return Сумма в рублях.
     */
    public int euroToRuble(int value) {
        return value*EURO_TO_RUBLE_RATE;
    }

    /**
     * Method dollarToRuble. Конвертирут доллары в рубли.
     * @param value - Сумма в долларах.
     * @return Сумма в рублях.
     */
    public int dollarToRuble(int value) {
        return value*DOLLAR_TO_RUBLE_RATE;
    }
}

package ru.job4j.calculator;
/**
 * Class Converter решение задачи Части 001. Базовый синтаксис урок 3.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.03.2018
 * @version 1
 */
public class Converter {

    /**
     * Method rubleToEuro. Конвертирут рубли в евро.
     * @param value - Сумма в рублях.
     * @return Сумма в евро.
     */
    public int rubleToEuro(int value) {
        //1 евро = 70 рублей.
        return value/70;
    }

    /**
     * Method rubleToDollar. Конвертирут рубли в доллары.
     * @param value - Сумма в рублях.
     * @return Сумма в долларах.
     */
    public int rubleToDollar(int value) {
        //1 доллар = 60 рублей.
        return value/60;
    }

    /**
     * Method euroToRuble. Конвертирут евро в рубли.
     * @param value - Сумма в евро.
     * @return Сумма в рублях.
     */
    public int euroToRuble(int value) {
        //1 евро = 70 рублей.
        return value*70;
    }

    /**
     * Method dollarToRuble. Конвертирут доллары в рубли.
     * @param value - Сумма в долларах.
     * @return Сумма в рублях.
     */
    public int dollarToRuble(int value) {
        //1 доллар = 60 рублей.
        return value*60;
    }
}

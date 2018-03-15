package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConverterTest Автотесты для задач Части 001. Базовый синтаксис урок 3.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.03.2018
 * @version 1
 */
public class ConverterTest {
    /**
     * Тест операции конвертации из рублей в доллары.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    /**
     * Тест операции конвертации из рублей в евро.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }

    /**
     * Тест операции конвертации из долларов в рубли.
     */
    @Test
    public void when1DollarToRubleThen60() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(1);
        assertThat(result, is(60));
    }

    /**
     * Тест операции конвертации из евро в рубли.
     */
    @Test
    public void when1EuroToRubleThen70() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(1);
        assertThat(result, is(70));
    }
}
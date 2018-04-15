package ru.job4j.calculator;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class CalculateTest Автотесты для задач Части 001. Базовый синтаксис урок 3.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 13.03.2018
 * @version 1
 */
public class CalculatorTest {
    /**
     * Тест операции сложения.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Тест операции вычитания.
     */
    @Test
    public void whenMinusTwoMinusOneThenOne() {
        Calculator calc = new Calculator();
        calc.minus(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
    /**
     * Тест операции умножения.
     */
    @Test
    public void whenMultiplyTwoMultiplyFourThenEight() {
        Calculator calc = new Calculator();
        calc.multiply(2D, 4D);
        double result = calc.getResult();
        double expected = 8D;
        assertThat(result, is(expected));
    }
    /**
     * Тест операции деления.
     */
    @Test
    public void whenDivideFourDevideTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.divide(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}
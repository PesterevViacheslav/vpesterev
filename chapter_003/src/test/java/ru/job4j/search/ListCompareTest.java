package ru.job4j.search;
/**
 * Class ListCompare - Автотесты задачи Части 003. Collections. Lite.
 * Задача 3.3. Компаратор для строк
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 28.07.2018
 * @version 1
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;
public class ListCompareTest {
    @Test
    /**
     * Тест сравнения одинаковых строк
     */
    public void whenStringsAreEqualThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "User1",
                "User1"
        );
        assertThat(rst, is(0));
    }
    @Test
    /**
     * Тест сравнения Левая строка меньше Правой
     */
    public void whenLeftLessThanRightResultShouldBeNegative() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "User1",
                "Userr2rr"
        );
        assertThat(rst, lessThan(0));
    }
    @Test
    /**
     * Тест сравнения Правая строка меньше Левой
     */
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "User1rr",
                "Ivanov"
        );
        assertThat(rst, greaterThan(0));
    }
    @Test
    /**
     * Тест сравнения Левая строка больше Правой по второму символу слева
     */
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "User1rrr",
                "Uaer1rr"
        );
        assertThat(rst, greaterThan(0));
    }
    @Test
    /**
     * Тест сравнения Левая строка меньше Правой по второму символу
     */
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Uaer1r",
                "User1dd"
        );
        assertThat(rst, lessThan(0));
    }
    @Test
    /**
     * Тест сравнения Левая строка больше Правой по второму символу слева
     */
    public void CompareByLengthThanShortStringMustBeTheLess() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "User1rrr",
                "User1rr"
        );
        assertThat(rst, greaterThan(0));
    }
}
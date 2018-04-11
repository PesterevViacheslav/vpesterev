package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class ArrayCharTest Автотесты для задач Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.04.2018
 * @version 1
 */
public class ArrayCharTest {
    /**
     * Тест операции проверки начала массива с нужного префикса (Префикс совпадает с началом массива).
     */
    @Test
    public void checkArrayStartWithPrefixSuccess() {
        ArrayChar p = new ArrayChar("Test");
        boolean result = p.startWith("T");
        assertThat(result, is(true));
    }

    /**
     * Тест операции проверки начала массива с нужного префикса (Префикс не совпадает с началом массива).
     */
    @Test
    public void checkArrayStartWithPrefixError() {
        ArrayChar p = new ArrayChar("Test");
        boolean result = p.startWith("Err");
        assertThat(result, is(false));
    }

    /**
     * Тест операции проверки начала массива с нужного префикса (Длина префиксам равна размерности массива).
     */
    @Test
    public void checkArrayStartWithPrefixLengthEqualArraySize() {
        ArrayChar p = new ArrayChar("Test");
        boolean result = p.startWith("Test");
        assertThat(result, is(true));
    }

    /**
     * Тест операции проверки начала массива с нужного префикса (Длина префиксам меньше размерности массива).
     */
    @Test
    public void checkArrayStartWithPrefixLengthLessArraySize() {
        ArrayChar p = new ArrayChar("Test");
        boolean result = p.startWith("Test01");
        assertThat(result, is(false));
    }

    /**
     * Тест операции поиска подстроки (Подстрока присутствует).
     */
    @Test
    public void checkArrayContainsTrue() {
        ArrayChar p = new ArrayChar("RRRTestUIUI");
        boolean result = p.contains("Test");
        assertThat(result, is(true));
    }

    /**
     * Тест операции поиска подстроки (Подстрока равна строке).
     */
    @Test
    public void checkArrayContainsTrueAll() {
        ArrayChar p = new ArrayChar("Test");
        boolean result = p.contains("Test");
        assertThat(result, is(true));
    }

    /**
     * Тест операции поиска подстроки (Подстрока присутствует в начале).
     */
    @Test
    public void checkArrayContainsTrueStart() {
        ArrayChar p = new ArrayChar("TestUIUI");
        boolean result = p.contains("Test");
        assertThat(result, is(true));
    }

    /**
     * Тест операции поиска подстроки (Подстрока присутствует в конце).
     */
    @Test
    public void checkArrayContainsTrueEnd() {
        ArrayChar p = new ArrayChar("RRRTest");
        boolean result = p.contains("Test");
        assertThat(result, is(true));
    }

    /**
     * Тест операции поиска подстроки (Подстрока отсутствует).
     */
    @Test
    public void checkArrayContainsFalse() {
        ArrayChar p = new ArrayChar("est");
        boolean result = p.contains("Test");
        assertThat(result, is(false));
    }
}

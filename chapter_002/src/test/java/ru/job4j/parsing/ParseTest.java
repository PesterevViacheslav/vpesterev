package ru.job4j.parsing;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Class ParseTest - Автотесты парсинга. Решение задачи Части 002. ООП. Задача 8.3 Распарсить скобки.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.08.2018
 * @version 1
 */
public class ParseTest {
    private Parse p = new Parse();
    @Before
    public void init() {
        this.p.add('{', new Delimiter('{', true, '}'));
        this.p.add('}', new Delimiter('}', false, '{'));
        this.p.add('[', new Delimiter('[', true, ']'));
        this.p.add(']', new Delimiter(']', false, '['));
        this.p.add('(', new Delimiter('(', true, ')'));
        this.p.add(')', new Delimiter(')', false, '('));
    }
    @Test
    /**
     * Тест парсинга строки из одной левой скобки
     */
    public void testOneSymbolStringLeft() {
        boolean result = false;
        try {
            this.p.parsing("[");
        } catch (WrongFormatException wfe) {
            result = true;
        }
        assertThat(true, is(result));
    }
    @Test
    /**
     * Тест парсинга строки из одной правой скобки
     */
    public void testOneSymbolStringRight() {
        boolean result = false;
        try {
            this.p.parsing("}");
        } catch (WrongFormatException wfe) {
            result = true;
        }
        assertThat(true, is(result));
    }
    @Test
    /**
     * Тест парсинга строки с нечетным числом скобок
     */
    public void testNotEvenString() {
        boolean result = false;
        try {
            this.p.parsing("{}}");
        } catch (WrongFormatException wfe) {
            result = true;
        }
        assertThat(true, is(result));
    }
    @Test
    /**
     * Тест парсинга строки с невалидной структурой скобок
     */
    public void testNotValidString() {
        boolean result = false;
        try {
            this.p.parsing("[(]){}");
        } catch (WrongFormatException wfe) {
            result = true;
        }
        assertThat(true, is(result));
    }
    @Test
    /**
     * Тест парсинга строки с некорректными символами в строке
     */
    public void testNotValidStringWrongSymbols() {
        boolean result = false;
        try {
            this.p.parsing("[]{}{}jk");
        } catch (WrongFormatException wfe) {
            result = true;
        }
        assertThat(true, is(result));
    }
    @Test
    /**
     * Тест парсинга строки с корректными символами в строке
     */
    public void testValidString() {
        ArrayList<ParsingResult> result;
        ArrayList<ParsingResult> correct = new ArrayList<>();
        correct.add(new ParsingResult('[', ']', 0, 3));
        correct.add(new ParsingResult('[', ']', 1, 2));
        correct.add(new ParsingResult('{', '}', 4, 9));
        correct.add(new ParsingResult('(', ')', 5, 8));
        correct.add(new ParsingResult('(', ')', 6, 7));
        result = this.p.parsing("[[]]{(())}");
        assertThat(correct.toArray(), is(result.toArray()));
    }
}
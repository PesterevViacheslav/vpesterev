package ru.job4j;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Class DiffTest - Сравнение слов. Автотесты для решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.7.3 Дополнительная задача - Сравнить два слова на совпадение набора символов.
 * 5.7.4 Дополнительная задача - Сравнить два слова, проверить на то, что они отличаются только одной перестановкой символов
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 11.12.2018
 * @version 1
 */
public class DiffTest {
    /**
     * Тест сравнения - Одинаковые слова.
     */
    @Test
    public void whenTheSameWordsThenNoDiff() {
        Diff tst = new Diff();
        assertThat(tst.isDiff("abcdef", "abcdef"), is(true));
        assertThat(tst.isDiff("aaaabcdef", "abaaacdef"), is(true));
        assertThat(tst.isDiff("abcdefff", "abffcdef"), is(true));
    }
    /**
     * Тест сравнения - Разные слова.
     */
    @Test
    public void whenNotTheSameWordsThenDiff() {
        Diff tst = new Diff();
        assertThat(tst.isDiff("abcdrf", "abcdef"), is(false));
        assertThat(tst.isDiff("abc", "abcdef"), is(false));
        assertThat(tst.isDiff("abcdesfdadsfsf", "hjh"), is(false));
        assertThat(tst.isDiff("dadsfsf", "fsf"), is(false));
    }
    /**
     * Тест поиска одной перестановки - Одинаковые слова.
     */
    @Test
    public void whenTheSameWordsThenNoShift() {
        Diff tst = new Diff();
        assertThat(tst.hasOneShift("abcdef", "abcdef"), is(false));
    }
    /**
     * Тест поиска одной перестановки - Одна перестановка.
     */
    @Test
    public void whenTheOneShiftThenTrue() {
        Diff tst = new Diff();
        assertThat(tst.hasOneShift("acbdef", "abcdef"), is(true));
        assertThat(tst.hasOneShift("abcdefh", "abcdehf"), is(true));
        assertThat(tst.hasOneShift("123", "321"), is(true));
        assertThat(tst.hasOneShift("1234", "4231"), is(true));
    }
    /**
     * Тест поиска одной перестановки - Более одной перестановки.
     */
    @Test
    public void whenMoreThenOneShiftThenFalse() {
        Diff tst = new Diff();
        assertThat(tst.hasOneShift("123456", "213465"), is(false));
    }
    /**
     * Тест поиска одной перестановки - Слова разной длины, тоже считаем FALSE.
     */
    @Test
    public void whenDifferentLengthsThenFalse() {
        Diff tst = new Diff();
        assertThat(tst.hasOneShift("acbdefhifff", "acbdefhi"), is(false));
        assertThat(tst.hasOneShift("acbdefhi", "acbdefhifff"), is(false));
    }
}
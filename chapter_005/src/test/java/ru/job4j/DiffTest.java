package ru.job4j;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Class DiffTest - Сравнение слов. Автотесты для решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.7.3 Дополнительная задача - Сравнить два слова на совпадение набора символов.
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
}
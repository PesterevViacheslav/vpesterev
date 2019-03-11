package ru.job4j.inout;
import org.junit.Test;
import java.io.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
/**
 * Class TestCheckInputStream - Проверка байтового потока. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.1.1. Проверить байтовый поток.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 08.03.2019
 * @version 1
 */
public class TestCheckInputStream {
    CheckInputStream check = new CheckInputStream();
    /**
     * Тест проверки байтового потока, в потоке только четные числа.
     * @return Индекс массива.
     */
    @Test
    public void whenOnlyEvenStreamThenTrue() throws IOException {
        String test = "02468";
        try (InputStream stream = new ByteArrayInputStream(test.getBytes())) {
            assertThat(this.check.isEvenNumber(stream), is(true));
        }
        byte[] test2 = new byte[] {49, 50, 51, 52, 53, 54, 55, 56};
        try (InputStream stream = new ByteArrayInputStream(test2)) {
            assertThat(this.check.isEvenNumber(stream), is(true));
        }
        try (InputStream stream = new ByteArrayInputStream("123454678".getBytes())) {
            assertTrue(this.check.isEvenNumber(stream));
        }
    }
    /**
     * Тест проверки байтового потока, в потоке не только четные числа.
     * @return Индекс массива.
     */
    @Test
    public void whenNotOnlyEvenStreamThenFalse() throws IOException {
        String test = "02468rt";
        try (InputStream stream = new ByteArrayInputStream(test.getBytes())) {
            assertThat(this.check.isEvenNumber(stream), is(false));
        }
        String test2 = "024689";
        try (InputStream stream = new ByteArrayInputStream(test2.getBytes())) {
            assertThat(this.check.isEvenNumber(stream), is(false));
        }
        byte[] test3 = new byte[] {49, 50, 51, 52, 53, 54, 55};
        try (InputStream stream = new ByteArrayInputStream(test3)) {
            assertThat(this.check.isEvenNumber(stream), is(false));
        }
    }
    /**
     * Тест проверки символьного потока на вырезание запрещенных слов.
     * @return Индекс массива.
     */
    @Test
    public void testDropAbusedWords() throws IOException {
        String test = "my test abuse1 string abuse2";
        String[] array = new String[] {"abuse1", "abuse2"};
        try (Reader in = new StringReader(test);
             Writer out = new StringWriter()
             ) {
            this.check.dropAbuses(in, out, array);
            assertThat(out.toString(), is("my test string "));
        }
    }
}
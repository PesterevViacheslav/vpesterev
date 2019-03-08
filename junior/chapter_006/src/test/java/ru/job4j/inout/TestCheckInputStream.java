package ru.job4j.inout;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
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
        byte[] test2 = new byte[] {0, 2, 4, 6, 8, 10, 12};
        try (InputStream stream = new ByteArrayInputStream(test2)) {
            assertThat(this.check.isEvenNumber(stream), is(true));
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
        byte[] test3 = new byte[] {0, 2, 4, 7, 8, 10, 12};
        try (InputStream stream = new ByteArrayInputStream(test3)) {
            assertThat(this.check.isEvenNumber(stream), is(false));
        }
    }
}
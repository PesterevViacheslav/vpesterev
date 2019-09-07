package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class BoardTest Автотесты для задач Части 001. Базовый синтаксис урок 5.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.03.2018
 * @version 1
 */
public class BoardTest {
    /**
     * Тест операции получения псевдографики шахматной доски размером 5x5
     */
    @Test
    public void checkPaintFiveOnFiveBoard() {
        Board brd = new Board();
        String ln = System.lineSeparator();
        String result = brd.paint(5, 5);
        assertThat(result, is(String.format("X X X%s X X %sX X X%s X X %sX X X%s", ln, ln, ln, ln, ln)));
    }
    /**
     * Тест операции получения псевдографики шахматной доски размером 3x5
     */
    @Test
    public void checkPaintThreeOnFourBoard() {
        Board brd = new Board();
        String ln = System.lineSeparator();
        String result = brd.paint(3, 4);
        assertThat(result, is(String.format("X X%s X %sX X%s X %s", ln, ln, ln, ln)));
    }
}

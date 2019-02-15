package ru.job4j.pseudo;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class SquareTest Автотесты для задачи 4.4 Шаблоны проектирования. Части 002. ООП.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 19.05.2018
 * @version 1
 */
public class SquareTest {
    /**
     * Тест метода рисования квадрата.
     */
    @Test
    public void checkDrawSquare() {
        Shape square = new Square();
        StringBuilder pic = new StringBuilder();
        pic.append("+++++\n");
        pic.append("+   +\n");
        pic.append("+++++");
        assertThat(pic.toString(), is(square.draw()));
    }
}

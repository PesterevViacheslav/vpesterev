package ru.job4j.pseudo;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * Class PaintTest Автотесты для задачи 4.4 Шаблоны проектирования. Части 002. ООП.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 19.05.2018
 * @version 1
 */
public class PaintTest {
    /**
     * Тест метода рисования квадрата.
     */
    @Test
    public void checkDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Shape square = new Square();
        new Paint().draw(square);
        StringBuilder pic = new StringBuilder();
        pic.append("+++++\n");
        pic.append("+   +\n");
        pic.append("+++++\r\n");
        assertThat(new String(out.toByteArray()), is(pic.toString()));
        System.setOut(stdout);
    }
    /**
     * Тест метода рисования треугольника.
     */
    @Test
    public void checkDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Shape triangle = new Triangle();
        new Paint().draw(triangle);
        StringBuilder pic = new StringBuilder();
        pic.append("   +   \n");
        pic.append(" +   + \n");
        pic.append("+++++++\r\n");
        assertThat(new String(out.toByteArray()), is(pic.toString()));
        System.setOut(stdout);
    }
}
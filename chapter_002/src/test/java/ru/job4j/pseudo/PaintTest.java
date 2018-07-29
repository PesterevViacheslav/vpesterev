package ru.job4j.pseudo;
import org.junit.After;
import org.junit.Before;
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
    private PrintStream stdout = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOut() {
        System.out.println("Exec before");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOut() {
        System.setOut(this.stdout);
        System.out.println("Exec after");
    }
    /**
     * Тест метода рисования квадрата.
     */
    @Test
    public void checkDrawSquare() {
        Shape square = new Square();
        new Paint().draw(square);
        StringBuilder pic = new StringBuilder();
        pic.append("+++++\n");
        pic.append("+   +\n");
        pic.append("+++++");
        pic.append(System.lineSeparator());
        assertThat(new String(out.toByteArray()), is(pic.toString()));
    }
    /**
     * Тест метода рисования треугольника.
     */
    @Test
    public void checkDrawTriangle() {
        Shape triangle = new Triangle();
        new Paint().draw(triangle);
        StringBuilder pic = new StringBuilder();
        pic.append("   +   \n");
        pic.append(" +   + \n");
        pic.append("+++++++");
        pic.append(System.lineSeparator());
        assertThat(new String(out.toByteArray()), is(pic.toString()));
    }
}
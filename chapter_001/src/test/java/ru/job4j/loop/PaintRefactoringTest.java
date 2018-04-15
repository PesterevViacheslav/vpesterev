package ru.job4j.loop;
import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class PaintRefactoringTest Автотесты для задач Части 001. Базовый синтаксис урок 5.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 03.04.2018
 * @version 1
 */
public class PaintRefactoringTest {
    /**
     * Тест операции получения псевдографики пирамиды высотой 1
     */
    @Test
    public void checkPaintPiramidHeigthOne() {
        PaintRefactoring p = new PaintRefactoring();
        String ln = System.lineSeparator();
        String result = p.piramid(1);
        assertThat(result, is(String.format("^%s", ln)));
    }
    /**
     * Тест операции получения псевдографики пирамиды высотой 3
     */
    @Test
    public void checkPaintPiramidHeigthThree() {
        PaintRefactoring p = new PaintRefactoring();
        String ln = System.lineSeparator();
        String result = p.piramid(3);
        assertThat(result, is(new StringJoiner(ln, "", ln)
                .add("  ^  ")
                .add(" ^^^ ")
                .add("^^^^^")
                .toString()));
    }
}
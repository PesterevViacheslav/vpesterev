package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TurnTest Автотесты для задач Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 30.03.2018
 * @version 1
 */
public class TurnTest {
    /**
     * Тест операции переворачивания массива (нечетное число элементов)
     */
    @Test
    public void checkTurnArrayEven() {
        Turn p = new Turn();
        int[] array = new int[] {1, 4, 9, 16, 25};
        int[] result = new int[] {25, 16, 9, 4, 1};
        assertThat(result, is(p.turn(array)));
    }
    /**
     * Тест операции переворачивания массива (четное число элементов)
     */
    @Test
    public void checkTurnArrayNotEven() {
        Turn p = new Turn();
        int[] array = new int[] {1, 4, 9, 16};
        int[] result = new int[] {16, 9, 4, 1};
        assertThat(result, is(p.turn(array)));
    }
}
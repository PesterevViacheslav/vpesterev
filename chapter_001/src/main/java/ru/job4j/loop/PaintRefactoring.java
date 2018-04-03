package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Class PaintRefactoring решение задач Части 001. Базовый синтаксис урок 5 (Рефакторинг).
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 03.04.2018
 * @version 1
 */
public class PaintRefactoring {

    /**
     * Method rightTrl. Отрисовка правой части пирамиды заданной высоты.
     * @param height Высота пирамиды.
     * @return Правая часть пирамиды.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Method leftTrl. Отрисовка левой части пирамиды заданной высоты.
     * @param height Высота пирамиды.
     * @return Левая часть пирамиды.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Method piramid. Отрисовка пирамиды заданной высоты.
     * @param height Высота пирамиды.
     * @return Псевдографика пирамиды.
     */
    public String piramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Method loopBy. Отрисовка пирамиды заданной высоты.
     * @param height Высота пирамиды.
     * @param width  Ширина основания пирамиды.
     * @param predict Generic слияния левой и правой части пирамиды.
     * @return Псевдографика пирамиды.
     */
    private String loopBy(int height, int width, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}

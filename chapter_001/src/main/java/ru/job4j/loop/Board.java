package ru.job4j.loop;

/**
 * Class Board решение задач Части 001. Базовый синтаксис урок 5.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.03.2018
 * @version 1
 */
public class Board {

    /**
     * Method paint. Отрисовка шахматной доски заданного размера.
     * @param width Размер по горизонтали.
     * @param height Размер по вертикали.
     * @return Псевдографика шахматной доски.
     */
    public String paint(int width, int height) {
        StringBuilder result = new StringBuilder();
        String ln = System.lineSeparator();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if ((i % 2 != 0 && j % 2 != 0) || (i % 2 == 0 && j % 2 == 0)) {
                    result.append("X");
                } else {
                    result.append(" ");
                }
            }
            result.append(ln);
        }
        return result.toString();
    }
}

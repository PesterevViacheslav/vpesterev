package ru.job4j.loop;

/**
 * Class Board решение задач Части 001. Базовый синтаксис урок 5.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.03.2018
 * @version 1
 */
public class Paint {

    /**
     * Method piramid. Отрисовка пирамиды заданной высоты.
     * @param h Высота пирамиды.
     * @return Псевдографика пирамиды.
     */
    public String piramid(int h) {
        StringBuilder result = new StringBuilder();
        String ln = System.lineSeparator();
        int bottom = (h - 1) * 2 + 1;
        int width = 0;

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= bottom; j++) {
                if ((j >= h - width) && (j <= h + width)) {
                    result.append("^");
                } else {
                    result.append(" ");
                }
            }
            width++;
            result.append(ln);
        }
        return result.toString();
    }
}

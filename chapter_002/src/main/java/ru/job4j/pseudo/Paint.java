package ru.job4j.pseudo;
/**
 * Class Paint - Рисование. Решение задачи 4.4 Шаблоны проектирования. Части 002. ООП.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 19.05.2018
 * @version 1
 */
public class Paint {
    /**
     * Method draw. Отрисовка фигуры.
     * @param shape Фигура.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}

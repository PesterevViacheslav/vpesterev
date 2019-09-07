package ru.job4j.pseudo;
/**
 * Class Square - Квадрат. Решение задачи 4.4 Шаблоны проектирования. Части 002. ООП.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 19.05.2018
 * @version 1
 */
public class Square implements Shape {
    /**
     * Method draw. Отрисовка фигуры.
     * @return Псевдографика
     */
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++\n");
        pic.append("+   +\n");
        pic.append("+++++");
        return pic.toString();
    }
}


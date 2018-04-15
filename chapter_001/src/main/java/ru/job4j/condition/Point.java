package ru.job4j.condition;
/**
 * Class Point решение задачи Части 001. Базовый синтаксис урок 3.4.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.03.2018
 * @version 1
 */
public class Point {
    private int x;
    private int y;
    /**
     * Method Point. Конструктор.
     * @param x Координата по оси x.
     * @param y Координата по оси y.
     */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Method distanceTo. Определение растояния между двумя точкаи на плоскости.
     * @param that Точка до которой вычисляется расстояние.
     * @return Расстояние между двумя точками.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
    /**
     * Method main. Вывод результата в консоль.
     * @param  args - args.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}
package ru.job4j.condition;
import static java.lang.Math.sqrt;
/**
 * Class Triangle решение задач Части 001. Базовый синтаксис урок 4.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 21.03.2018
 * @version 1
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    /**
     * Method Triangle. Конструктор.
     * @param a Точка a.
     * @param b Точка b.
     * @param c Точка c.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Method period. Вычисление полупериметра по длинам сторон.
     * @param ab Расстояние между точками a b.
     * @param ac Расстояние между точками a c.
     * @param bc Расстояние между точками b c.
     * @return Периметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }
    /**
     * Method area. Вычисление площади треугольника.
     * @return Площадь треугольника.
     */
    public double area() {
        double result = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            result = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return result;
    }
    /**
     * Method exist. Проверка возможности построения треугольника с заданными длинами сторон.
     * @param ab Длина от точки a до точки b.
     * @param ac Длина от точки a до точки c.
     * @param bc Длина от точки b до точки c.
     * @return Возможность построения
     */
    private boolean exist(double ab, double ac, double bc) {
        boolean result = true;
        if ((ab == 0) || (ac == 0) || (bc == 0) || (ab == (ac + bc)) || (bc == (ac + ab)) || (ac == (ab + bc))) {
            result = false;
        }
        return result;
    }
}
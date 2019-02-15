package ru.job4j.bombermen;
/**
 * Class RunBoard - Тест игры Бомбермен. Решение задач уровня Middle. Части 001. Multithreading.
 * 10.7.1. Игра Бомбермен.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.02.2019
 * @version 1
 */
public class RunBoard {
    public static void main(String[] args) {
        Board board = new Board(5, 5, 2, 100);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        board.runHero();
    }
}
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
        Board board = new Board(5, 100);
        board.init(5);
        board.addMonster("MONSTER1");
        board.addMonster("MONSTER2");
        board.addMonster("MONSTER3");
        board.addMonster("MONSTER4");
        board.addMonster("MONSTER5");
        board.runHero();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        board.print();
    }
}
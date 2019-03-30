package ru.job4j.bombermen;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Class Cell - Ячейка. Решение задач уровня Middle. Части 001. Multithreading.
 * 10.7.1. Игра Бомбермен.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.02.2019
 * @version 1
 */
public class Cell {
    final int x;
    final int y;
    volatile ReentrantLock lock;
    volatile String blockType;
    public Cell(int x, int y, ReentrantLock lock, String blockType) {
        this.x = x;
        this.y = y;
        this.lock = lock;
        this.blockType = blockType;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    @Override
    public String toString() {
        return String.join("", "Cell{", "x=", Integer.toString(x), ", y=", Integer.toString(y), ", type=", blockType, ", locked=", Boolean.toString(lock.isLocked()), "}");
    }
}
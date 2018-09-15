package ru.job4j.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class MatrixIterator. Решение задач уровня Junior. Части 001. Collections. Pro.
 * Задача 5.1.1. Итератор для двухмерного массива int[][].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.09.2018
 * @version 1
 */
public class MatrixIterator implements Iterator {
    private int[][] values;
    private int indexSize = 0;
    private int indexRow = 0;
    private int[] rowLength;
    /**
     * Method MatrixIterator. Конструктор.
     * @param values Двумерный массив.
     */
    public MatrixIterator(int[][] values) {
        int counter = 0;
        this.rowLength = new int[values.length];
        for (int[] i : values) {
            this.rowLength[counter++] = i.length;
        }
        this.values = values;
    }
    /**
     * Method hasNext. Проверка наличия следующего элемента массива.
     * @return Наличие элемента.
     */
    @Override
    public boolean hasNext() {
        boolean res = false;
        if (this.indexSize < this.values.length && this.indexRow < this.rowLength[this.indexSize]) {
            res = true;
        }
        return res;
    }
    /**
     * Method next. Получение следующего элемента массива.
     * @return Элемент.
     */
    @Override
    public Object next() {
        int res;
        if (this.values.length > 0) {
            res = this.values[this.indexSize][this.indexRow++];
            if (this.indexRow == this.rowLength[this.indexSize]) {
                this.indexSize++;
                this.indexRow = 0;
            }
        } else {
            throw new NoSuchElementException("NoSuchElementException");
        }
        return res;
    }
}
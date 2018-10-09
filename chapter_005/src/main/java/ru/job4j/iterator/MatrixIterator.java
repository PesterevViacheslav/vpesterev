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
    private Index index = new Index(0, 0);
    /**
     * Class Index. Индекс двумерного массива.
    */
    private class Index {
        private int row = 0;
        private int cell = 0;
        /**
         * Method Index. Конструктор.
         * @param row Индекс столбца.
         * @param cell Индекс строки.
         */
        public Index(int row, int cell) {
            this.row = row;
            this.cell = cell;
        }
        /**
         * Method checkIndex. Валидация индекса.
         * @return Признак валидности.
         */
        public boolean checkIndex() {
            return this.row >= 0 || this.cell >= 0;
        }
    }
    /**
     * Method MatrixIterator. Конструктор.
     * @param values Двумерный массив.
     */
    public MatrixIterator(int[][] values) {
        this.values = values;
    }
    /**
     * Method hasNext. Проверка наличия следующего элемента массива.
     * @return Наличие элемента.
     */
    @Override
    public boolean hasNext() {
        Index res = nextIndex(false);
        return res.checkIndex();
    }
    /**
     * Method next. Получение следующего элемента массива.
     * @return Элемент.
     */
    @Override
    public Object next() {
        Index index = nextIndex(true);
        if (!index.checkIndex()) {
            throw new NoSuchElementException("NoSuchElementException");
        }
        return this.values[index.row][index.cell];
    }
    /**
     * Method nextIndex. Получение следующего элемента массива.
     * @return Индекс.
     */
    private Index nextIndex(boolean doFetch) {
        Index res = new Index(-1, -1);
        boolean doBreak = false;
        for (int i = this.index.row; i < this.values.length && !doBreak; i++) {
            for (int j = this.index.cell; j < this.values[i].length; j++) {
                res.cell = this.index.cell;
                res.row = this.index.row;
                if (doFetch) {
                    if (j + 1 < this.values[i].length) {
                        this.index.cell++;
                    } else {
                        this.index.cell = 0;
                        this.index.row++;
                    }
                }
                doBreak = true;
                break;
            }
        }
        return res;
    }
}
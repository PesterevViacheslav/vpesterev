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
        private int indexI = 0;
        private int indexJ = 0;
        /**
         * Method Index. Конструктор.
         * @param indexI Индекс столбца.
         * @param indexJ Индекс строки.
         */
        public Index(int indexI, int indexJ) {
            this.indexI = indexI;
            this.indexJ = indexJ;
        }
        /**
         * Method checkIndex. Валидация индекса.
         * @return Признак валидности.
         */
        public boolean checkIndex() {
            return this.indexI >= 0 || this.indexJ >= 0;
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
        return this.values[index.indexI][index.indexJ];
    }
    /**
     * Method nextIndex. Получение следующего элемента массива.
     * @return Индекс.
     */
    private Index nextIndex(boolean doFetch) {
        Index res = new Index(-1, -1);
        boolean doBreak = false;
        for (int i = this.index.indexI; i < this.values.length && !doBreak; i++) {
            for (int j = this.index.indexJ; j < this.values[i].length; j++) {
                res.indexJ = this.index.indexJ;
                res.indexI = this.index.indexI;
                if (doFetch) {
                    if (j + 1 < this.values[i].length) {
                        this.index.indexJ++;
                    } else {
                        this.index.indexJ = 0;
                        this.index.indexI++;
                    }
                }
                doBreak = true;
                break;
            }
        }
        return res;
    }
}
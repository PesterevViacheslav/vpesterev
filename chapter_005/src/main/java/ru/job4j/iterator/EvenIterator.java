package ru.job4j.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class EvenIterator. Решение задач уровня Junior. Части 001. Collections. Pro.
 * Задача 5.1.2. Создать итератор четные числа.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.09.2018
 * @version 1
 */
public class EvenIterator implements Iterator {
    private int[] values;
    private int index = 0;
    /**
     * Method EvenIterator. Конструктор.
     * @param values Массив.
     */
    public EvenIterator(int[] values) {
        this.values = values;
    }
    /**
     * Method hasNext. Проверка наличия следующего элемента массива.
     * @return Наличие элемента.
     */
    @Override
    public boolean hasNext() {
        boolean res = false;
        if (this.index < this.values.length && getNextEvenIndex(false) >= 0) {
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
        int nextEvenIndex = getNextEvenIndex(true);
        if (!(this.values.length > 0 && nextEvenIndex >= 0)) {
            throw new NoSuchElementException("NoSuchElementException");
        }
        return this.values[nextEvenIndex];
    }
    /**
     * Method getNextEvenIndex. Получение следующего четного элемента массива.
     * @return Индекс.
     */
    private int getNextEvenIndex(boolean doFetch) {
        int res = -1;
        for (int i = this.index; i < this.values.length; i++) {
            if (this.values[i] % 2 == 0) {
                res = i;
                if (doFetch) {
                    this.index++;
                }
                break;
            } else {
                this.index++;
            }
        }
        return res;
    }
}
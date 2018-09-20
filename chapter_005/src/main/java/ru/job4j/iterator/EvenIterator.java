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
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                res = true;
                index = i;
                break;
            }
        }
        return res;
    }
    /**
     * Method next. Получение следующего элемента массива.
     * @return Элемент.
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return this.values[index++];
    }
}
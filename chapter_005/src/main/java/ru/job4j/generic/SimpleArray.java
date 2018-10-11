package ru.job4j.generic;
import java.util.Arrays;
import java.util.Iterator;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Class SimpleArray. Решение задач уровня Junior. Части 001. Collections. Pro.
 * Задача 5.2.1. Реализовать SimpleArray<T>.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.10.2018
 * @version 1
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;
    /**
     * Method SimpleArray. Конструктор.
     * @param size Размер массива.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }
    /**
     * Method getIndex. Получение значения индекса.
     * @return Индекс массива.
     */
    public int getIndex() {
        return this.index;
    }
    /**
     * Method add. Добавление элемента в структуру.
     * @param model Элемент.
     */
    public void add(T model) {
        if (this.index == this.objects.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[this.index++] = model;
    }
    /**
     * Method set. Установка значения элемента в структуре.
     * @param position Индекс.
     * @param model Элемент.
     */
    public void set(int position, T model) {
        if (position >= this.objects.length && position < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[position] = model;
    }
    /**
     * Method delete. Удаление значения элемента из структуры.
     * @param position Индекс.
     */
    public void delete(int position) {
        if (this.index > 0) {
            System.arraycopy(this.objects, position + 1, this.objects, position, this.objects.length - position - 1);
            this.index--;
        }
    }
    /**
     * Method get. Получение значения элемента из структуры.
     * @param position Индекс.
     */
    public T get(int position) {
        return (T) this.objects[position];
    }
    /**
     * Method iterator. Итератор.
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return this.currentIndex < index;
                        //&& objects[this.currentIndex] != null;
            }
            @Override
            public T next() {
                if (this.currentIndex == index) {
                    throw new NoSuchElementException();
                }
                return (T) objects[this.currentIndex++];
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleArray<?> that = (SimpleArray<?>) o;
        return Arrays.equals(objects, that.objects);
    }
    @Override
    public String toString() {
        return "SimpleArray{" + "objects=" + Arrays.toString(objects) + ", index=" + index + '}';
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(objects);
    }
}
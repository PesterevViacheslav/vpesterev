package ru.job4j.list;
import java.util.*;
/**
 * Interface SimpleArrayList - Динамический список. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.3.1. Создать динамический список на базе массива.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.10.2018
 * @version 1
 */
public class SimpleArrayList<E> implements SimpleContainer<E> {
    private Object[] container;
    private int size = 0;
    private int index = 0;
    private int modCount = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_CONTAINER = {};
    /**
     * Method SimpleArrayList. Конструктор.
     * @param capacity Размер контейнера.
     */
    public SimpleArrayList(int capacity) {
        this.size = capacity;
        if (capacity > 0) {
            this.container = new Object[capacity];
        } else if (capacity == 0) {
            this.container = EMPTY_CONTAINER;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }
    /**
     * Method SimpleArrayList. Конструктор.
     */
    public SimpleArrayList() {
        this.size = DEFAULT_CAPACITY;
        this.container = new Object[DEFAULT_CAPACITY];
    }
    /**
     * Method add. Добавление в контейнер.
     * @param e Элемент.
     */
    @Override
    public void add(E e) {
        this.modCount++;
        if (this.size == 0 && this.container == EMPTY_CONTAINER) {
            this.container = new Object[DEFAULT_CAPACITY];
        } else if (this.size > 0 && this.size == this.index) {
            this.container = Arrays.copyOf(this.container, this.size * 2);
            this.size = this.size * 2;
        }
        this.container[index++] = e;
    }
    /**
     * Method get. Поиск по индексу.
     * @param index Индекс.
     */
    @Override
    public E get(int index) {
        if (index > this.index) {
            throw new NoSuchElementException();
        }
        return (E) this.container[index];
    }
    /**
     * Method getSize. Получение размера контейнера.
     * @return Размер контейнера.
     */
    public int getSize() {
        return size;
    }
    /**
     * Method getIndex. Получение текущего идекса.
     * @return Индекс.
     */
    public int getIndex() {
        return index;
    }
    /**
     * Method iterator. Итератор.
     * @return Индекс.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int cursor = 0;
            /**
             * Method hasNext. Проверка наличия следующего элемента.
             * @return Наличие элемента.
             */
            @Override
            public boolean hasNext() {
                return this.cursor != size;
            }
            /**
             * Method next. Получение следующего элемента массива.
             * @return Элемент.
             */
            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                if (modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                int i = this.cursor;
                if (i >= size) {
                    throw new NoSuchElementException();
                }
                Object[] container = SimpleArrayList.this.container;
                if (i >= container.length) {
                    throw new ConcurrentModificationException();
                }
                this.cursor = i + 1;
                return (E) container[i];
            }
        };
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleArrayList<?> that = (SimpleArrayList<?>) o;
        return size == that.size && index == that.index && Arrays.equals(container, that.container);
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(size, index);
        result = 31 * result + Arrays.hashCode(container);
        return result;
    }
    @Override
    public String toString() {
        return "SimpleArrayList{" + "container=" + Arrays.toString(container) + ", size=" + size + ", index=" + index + '}';
    }
}
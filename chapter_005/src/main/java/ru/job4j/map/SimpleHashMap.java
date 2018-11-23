package ru.job4j.map;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class SimpleHashMap - Отображение. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.5.8. Реализовать собственную структуру данных - HashMap.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.11.2018
 * @version 1
 */
public class SimpleHashMap<K, V> implements Iterable {
    private int currentMaxCapacity = 0;
    private int modCount = 0;
    private int currentCapacity = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Node<K, V>[] container;
    /**
     * Method SimpleHashMap. Конструктор.
     */
    public SimpleHashMap() {
        this.currentMaxCapacity = DEFAULT_INITIAL_CAPACITY;
        this.container = new Node[DEFAULT_INITIAL_CAPACITY];
    }
    /**
     * Method hash. Вычисление хэш-кода.
     * @param key Ключ.
     * @return Хэш-код.
     */
    public int hash(K key) {
        return Math.abs(key.hashCode() % this.currentMaxCapacity);
    }
    /**
     * Method getCurrentCapacity. Получение числа элементов.
     * @return Число элементов.
     */
    public int getCurrentCapacity() {
        return this.currentCapacity;
    }
    /**
     * Method getCurrentMaxCapacity. Получение максимального числа элементов.
     * @return Число элементов.
     */
    public int getCurrentMaxCapacity() {
        return this.currentMaxCapacity;
    }
    /**
     * Method get. Получение значения по ключу.
     * @param key Ключ.
     * @return Значение.
     */
    public V get(K key) {
        V res = null;
        if (this.container[hash(key)] != null) {
            res = this.container[hash(key)].value;
        }
        return res;
    }
    /**
     * Method delete. Удаление элемента по ключу.
     * @param key Ключ.
     * @return Признак успеха.
     */
    public boolean delete(K key) {
        boolean res = false;
        if (this.container[hash(key)] != null) {
            this.container[hash(key)] = null;
            this.currentCapacity--;
            res = true;
            this.modCount++;
        }
        return res;
    }
    /**
     * Method insert. Добавление в контейнер.
     * @param key Ключ.
     * @param value Значение.
     * @return Признак успеха.
     */
    public boolean insert(K key, V value) {
        boolean res = false;
        this.modCount++;
        if ((float) this.currentCapacity / this.currentMaxCapacity >= DEFAULT_LOAD_FACTOR) {
            this.container = Arrays.copyOf(this.container, this.currentMaxCapacity * 2);
            this.currentMaxCapacity = this.currentMaxCapacity * 2;
        }
        if (this.container[hash(key)] == null) {
            this.container[hash(key)] = new Node(key, value);
            this.currentCapacity++;
            res = true;
        }
        return res;
    }
    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int expectedModCount = modCount;
            int index = 0;
            /**
             * Method hasNext. Проверка наличия следующего элемента.
             * @return Наличие элемента.
             */
            @Override
            public boolean hasNext() {
                boolean res = false;
                for (int i = this.index; i < currentMaxCapacity; i++) {
                    if (container[i] != null) {
                        res = true;
                        this.index = i;
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
            @SuppressWarnings("unchecked")
            public K next() {
                if (modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[this.index++].key;
            }
        };
    }
    /**
     * Class Node. Структура хранения данных.
     */
    private static class Node<K, V> {
        K key;
        V value;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
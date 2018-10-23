package ru.job4j.list;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class SimpleArrayList - Связный список. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.3.0 Создать метод delete для односвязного списка.
 * 5.3.2. Создать контейнер на базе связанного списка.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 23.10.2018
 * @version 1
 */
public class SimpleLinkedList<E> implements SimpleContainer<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;
    /**
     * Method add. Добавление в список.
     * @param date Размер контейнера.
     */
    public void add(E date) {
        Node<E> lst = this.last;
        Node<E> newNode = new Node<>(lst, date, null);
        this.last = newNode;
        if (lst == null) {
            this.first = newNode;
        } else {
            lst.next = newNode;
        }
        this.size++;
        this.modCount++;
    }
   /**
     * Method delete. Удаление первого элемента в списке.
     * @return  Элемент.
     */
    public E delete() {
        final Node<E> f = this.first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        final E element = f.date;
        final Node<E> next = f.next;
        f.date = null;
        f.next = null;
        this.first = next;
        if (next == null) {
            this.last = null;
        } else {
            next.prev = null;
        }
        this.size--;
        this.modCount++;
        return element;
    }
    /**
     * Method get. Получение значения элемента по индексу.
     * @param index Индекс.
     * @return Значение элемента.
     */
    public E get(int index) {
        Node<E> res;
        if (!(index >= 0 && index < this.size)) {
            throw new IndexOutOfBoundsException();
        }
        if (index < (this.size >> 1)) {
            res = this.first;
            for (int i = 0; i < index; i++) {
                res = res.next;
            }
        } else {
            res = this.last;
            for (int i = this.size - 1; i > index; i--) {
                res = res.prev;
            }
        }
        return res.date;
    }
    /**
     * Method getSize. Получение размера коллекции.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * Method iterator. Итератор.
     * @return Итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> lastReturned;
            private Node<E> next = first;
            private int nextIndex = 0;
            private int expectedModCount = modCount;
            /**
             * Method hasNext. Проверка наличия следующего элемента.
             * @return Наличие элемента.
             */
            @Override
            public boolean hasNext() {
                return this.nextIndex < size;
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
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.lastReturned = this.next;
                this.next = this.next.next;
                this.nextIndex++;
                return this.lastReturned.date;
            }
        };
    }
    /**
     * Class Node. Структура хранения данных.
     */
    private static class Node<E> {
        E date;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev, E date, Node<E> next) {
            this.prev = prev;
            this.date = date;
            this.next = next;
        }
    }
}
package ru.job4j.list;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Class SimpleArrayList - Односвязный список. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.3.0 Создать метод delete для односвязного списка.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.10.2018
 * @version 1
 */
public class SimpleList<E> {
    private int size;
    private Node<E> first;
    /**
     * Method add. Добавление в список.
     * @param date Размер контейнера.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
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
        this.size--;
        return element;
    }
    /**
     * Method get. Получение значения элемента по индексу.
     * @param index Индекс.
     * @return Значение элемента.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }
    /**
     * Method getSize. Получение размера коллекции.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * Method hasCycle. Проверка на зацикленность коллекции.
     */
    public boolean hasCycle() {
        boolean res = false;
        Node<E> current = this.first;
        Node<E> check;
        for (int i = 0; i < this.size && current.next != null; i++) {
            check = current.next;
            for (int j = i; j < this.size && check != null; j++) {
                if (current.next == check.next) {
                    res = true;
                    break;
                }
                check = check.next;
            }
            current = current.next;
        }
        return res;
    }
    /**
     * Method getNodeNext. Получение ссылки на следующий узел.
     * @param index Индекс.
     * @return Значение элемента.
     */
    public Node<E> getNodeNext(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.next;
    }
    /**
     * Method setNodeNext. Установка ссылки на следующий узел.
     * @param index Индекс.
     * @param next Значение элемента.
     */
    public void setNodeNext(int index, Node<E> next) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        result.next = next;
    }
    /**
     * Class Node. Структура хранения данных.
     */
    private static class Node<E> {
        E date;
        Node<E> next;
        Node(E date) {
            this.date = date;
        }
    }
}
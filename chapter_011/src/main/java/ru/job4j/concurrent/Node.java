package ru.job4j.concurrent;
/**
 * Class ConcurrentOutput - Запуск потоков. Решение задач уровня Middle. Части 011. Multithreading.
 * 3. Immutable объекты.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 03.07.2020
 * @version 1
 */
public class Node<T> {
    private final Node next;
    private final T value;

    public Node(final Node next, final T value) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return this.next;
    }

    public T getValue() {
        return this.value;
    }
}
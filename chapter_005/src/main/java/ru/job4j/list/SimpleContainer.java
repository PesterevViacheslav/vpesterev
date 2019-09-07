package ru.job4j.list;
/**
 * Interface SimpleContainer - Контейнер. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.3.1. Создать динамический список на базе массива.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.10.2018
 * @version 1
 */
public interface SimpleContainer<E> extends Iterable<E> {
    void add(E e);
    E get(int index);
}

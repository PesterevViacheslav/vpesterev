package ru.job4j.list;
/**
 * Interface SimpleStackContainer - Контейнер для стека. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack.
 * 5.3.3.1 Очередь на двух стеках.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.10.2018
 * @version 1
 */
public interface SimpleStackContainer<T> {
    T poll();
    void push(T value);
}
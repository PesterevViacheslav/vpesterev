package ru.job4j.list;
/**
 * Class SimpleStack - Стек. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 23.10.2018
 * @version 1
 */
public class SimpleStack<E> {
    private SimpleLinkedList<E> list = new SimpleLinkedList<>();
    /**
     * Method poll. Получение первого элемента стека с удалением.
     * @return Элемент.
     */
    public E poll() {
      return list.delete();
    }
    /**
     * Method get. Получение элемента по индексу.
     * @param index Индекс.
     * @return Элемент.
     */
    public E get(int index) {
        return list.get(index);
    }
    /**
     * Method push. Добавление элемента в стек.
     * @param value Элемент.
     */
    public void push(E value) {
        list.addFirst(value);
    }
}
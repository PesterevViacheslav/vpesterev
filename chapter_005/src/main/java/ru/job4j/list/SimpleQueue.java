package ru.job4j.list;
/**
 * Class SimpleQueue - Очередь. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.3.3.1 Очередь на двух стеках.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.10.2018
 * @version 1
 */
public class SimpleQueue<E> implements SimpleStackContainer<E> {
    private SimpleStack<E> enqueue;
    private SimpleStack<E> dequeue;
    private int size;
    /**
     * Method SimpleQueue. Конструктор.
     */
    public SimpleQueue() {
        this.enqueue = new SimpleStack<>();
        this.dequeue = new SimpleStack<>();
    }
    /**
     * Method push. Добавление элемента в стек.
     * @param value Элемент.
     */
    public void push(E value) {
        this.enqueue.push(value);
        this.size++;
    }
    /**
     * Method poll. Получение первого элемента очереди с удалением.
     * @return Элемент.
     */
    public E poll() {
        if (dequeue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.poll());
            }
        }
        E temp = null;
        if (!dequeue.isEmpty()) {
            temp = dequeue.poll();
            size--;
        }
        return temp;
    }
    /**
     * Method get. Получение элемента по индексу.
     * @param index Индекс.
     * @return Элемент.
     */
    public E get(int index) {
        return enqueue.get(index);
    }
}
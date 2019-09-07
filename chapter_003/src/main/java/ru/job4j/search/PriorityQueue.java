package ru.job4j.search;
import java.util.LinkedList;
/**
 * Class PriorityQueue - Очередь задач. Решение задачи Части 003. Collections. Lite Задача 1.2 Очередь с приоритетом на LinkedList.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.07.2018
 * @version 1
 */
public class PriorityQueue {
    public LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Method put. Вставка задачи в очередь согласно приоритета.
     * @param task Задача.
     */
    public void put(Task task) {
        boolean inserted = false;
        for (int i = 0; i < this.tasks.size(); i++) {
            if (task.getPriority() <= this.tasks.get(i).getPriority()) {
                this.tasks.add(i, task);
                inserted = true;
                break;
            }
        }
        if (!inserted) {
            this.tasks.add(task);
        }
    }
    /**
     * Method take. Извлечение первого элемента из очереди с удалением.
     * @return Задача.
     */
    public Task take() {
        return this.tasks.poll();
    }
    /**
     * Method takeLast. Извлечение последнего элемента из очереди с удалением.
     * @return Задача.
     */
    public Task takeLast() {
        return this.tasks.pollLast();
    }
}
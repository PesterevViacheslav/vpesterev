package ru.job4j.search;
/**
 * Class Task - Задача. Решение задачи Части 003. Collections. Lite Задача 1.2 Очередь с приоритетом на LinkedList.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.07.2018
 * @version 1
 */
public class Task {
    private String desc;
    private int priority;
    /**
     * Method Task. Конструктор.
     * @param desc Описание.
     * @param priority Приоритет.
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }
    /**
     * Method getDesc. Получение описания задачи.
     * @return Описание.
     */
    public String getDesc() {
        return desc;
    }
    /**
     * Method getPriority. Получение приоритета задачи.
     * @return Приоритет.
     */
    public int getPriority() {
        return priority;
    }
}
package ru.job4j.tracker;
/**
 * Interface UserAction - Действия пользователя. Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 28.05.2018
 * @version 1
 */
public interface UserAction {
    int key();
    void execute(Input input, ITracker tracker);
    String info();
}
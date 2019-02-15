package ru.job4j.tracker;

import java.util.List;

/**
 * Interface Input - Ввод данных. Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.05.2018
 * @version 1
 */
public interface Input {
    String ask(String question);
    int ask(String question, List<Integer> range);
}

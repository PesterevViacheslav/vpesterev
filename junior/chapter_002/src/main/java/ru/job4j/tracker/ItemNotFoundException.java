package ru.job4j.tracker;
/**
 * Class ItemNotFoundException - Исключение - заявка не найдена. Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.06.2018
 * @version 1
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String msg) {
        super(msg);
    }
}
package ru.job4j.tracker;
/**
 * Class MenuOutException - Исключение при выборе несуществующего пункта меню. Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 04.06.2018
 * @version 1
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}

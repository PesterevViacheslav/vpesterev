package ru.job4j.bank;
/**
 * Class AlreadyExistsException - Исключение - объект уже существует. Решение задачи Части 003. Collections. Lite.
 * Задача 5.2  Банковские переводы.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.08.2018
 * @version 1
 */
public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String msg) {
        super(msg);
    }
}
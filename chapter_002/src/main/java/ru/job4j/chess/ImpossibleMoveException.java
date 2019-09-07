package ru.job4j.chess;
/**
 * Class ImpossibleMoveException - Исключение при попытке занять уже занятую клетку. Решение задачи Части 002. ООП. Задача 8.1 Каркас шахматной доски.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.06.2018
 * @version 1
 */
public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}

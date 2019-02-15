package ru.job4j.parsing;
/**
 * Class WrongFormatException - Исключение о неверном формате строки. Решение задачи Части 002. ООП. Задача 8.3 Распарсить скобки.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.08.2018
 * @version 1
 */
public class WrongFormatException extends RuntimeException {
    public WrongFormatException(String msg) {
        super(msg);
    }
}

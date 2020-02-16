package ru.job4j.tdd;
/**
 * Class NotAllKeysReplacedException - Исключение - не все ключи не заменены. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.02.2020
 * @version 1
 */
public class NotAllKeysReplacedException extends RuntimeException {
    public NotAllKeysReplacedException(String msg) {
        super(msg);
    }
}

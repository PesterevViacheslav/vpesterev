package ru.job4j.tdd;
/**
 * Class KeyNotFoundException - Исключение - ключ не существует. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.02.2020
 * @version 1
 */
public class KeyNotFoundException extends RuntimeException {
        public KeyNotFoundException(String msg) {
            super(msg);
        }
}

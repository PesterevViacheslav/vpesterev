package ru.job4j.nonblocking;
/**
 * Class OptimisticException - Исключение о нарушении целостности данных. Решение задач уровня Middle. Части 001. Multithreading.
 * 10.5.1. Неблокирующий кеш.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 09.01.2019
 * @version 1
 */
public class OptimisticException extends RuntimeException {
    public OptimisticException(String msg) {
        super(msg);
    }
}
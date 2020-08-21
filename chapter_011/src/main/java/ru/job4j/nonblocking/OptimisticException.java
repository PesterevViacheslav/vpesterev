package ru.job4j.nonblocking;
/**
 * Class OptimisticException - Исключение о нарушении целостности данных. Решение задач уровня Middle. Части 011. Multithreading.
 * Non blocking algorithm. 1. Неблокирующий кеш[#283091]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.08.2020
 * @version 1
 */
public class OptimisticException extends RuntimeException {
    public OptimisticException(String msg) {
        super(msg);
    }
}
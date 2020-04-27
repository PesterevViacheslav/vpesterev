package ru.job4j.gc;
import java.util.Scanner;
/**
 * Interface CacheAction - Действия кеша. Решение задач уровня Junior. Части 005. Garbage Collection.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.04.2020
 * @version 1
 */
public interface CacheActions {
    String key();
    void execute(Scanner input, Cache calculator);
    String info();
}
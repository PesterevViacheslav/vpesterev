package ru.job4j.generic;
/**
 * Interface Store - Контейнер. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.2.2. Реализовать Store<T extends Base>.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.10.2018
 * @version 1
 */
public interface Store<T extends Base> {
    void add(T model);
    boolean replace(String id, T model);
    boolean delete(String id);
    T findById(String id);
}
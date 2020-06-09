package ru.job4j.concurrent;
/**
 * Class Cache - Кеш. Решение задач уровня Middle. Блок 1. Multithreading
 * 2. Общие ресурсы. 1. Синхронизация общих ресурсов.[#283080].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 09.06.2020
 * @version 1
 */
public final class Cache {
    private static Cache cache;
    public synchronized Cache instOf() {
        if (cache == null) {
            System.out.println("check null");
            cache = new Cache();
        }
        return cache;
    }
}

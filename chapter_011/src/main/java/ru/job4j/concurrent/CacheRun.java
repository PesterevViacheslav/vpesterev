package ru.job4j.concurrent;
/**
 * Class CacheRun - Тест синхронизации кеша. Решение задач уровня Middle. Блок 1. Multithreading
 * 2. Общие ресурсы. 1. Синхронизация общих ресурсов.[#283080].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 09.06.2020
 * @version 1
 */
public class CacheRun {
    public static void main(String[] args) throws InterruptedException {
        Cache count = new Cache();
        Thread first = new Thread(count::instOf);
        Thread second = new Thread(count::instOf);
        first.start();
        second.start();
        first.join();
        second.join();
    }
}
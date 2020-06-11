package ru.job4j.concurrent;
/**
 * Class DCLSingletonRun - Запуск потоков. Решение задач уровня Middle. Части 011. Multithreading.
 * 2. Общие ресурсы. 2. Модель памяти Java.[#283077]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 11.06.2020
 * @version 1
 */
public class DCLSingletonRun {
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(DCLSingleton::instOf);
        Thread second = new Thread(DCLSingleton::instOf);
        first.start();
        second.start();
        first.join();
        second.join();
    }
}
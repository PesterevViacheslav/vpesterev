package ru.job4j.concurrent;
/**
 * Class ConcurrentOutput - Запуск потоков. Решение задач уровня Middle. Части 011. Multithreading.
 * 1. Запуск нити. Thread#start()[#283073].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.05.2020
 * @version 1
 */
public class ConcurrentOutput {
    public static void main(String[] args) {
        Thread another = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        Thread second = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
        another.start();
        second.start();
        System.out.println(Thread.currentThread().getName());
    }
}
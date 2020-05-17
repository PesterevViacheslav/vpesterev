package ru.job4j.concurrent;
/**
 * Class ThreadState - Состояние потоков. Решение задач уровня Middle. Блок 1. Multithreading
 * 1. Threads. 1.1. Состояние нити.[#283070].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 17.05.2020
 * @version 1
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(
            () -> { }
        );
        Thread second = new Thread(
                () -> { }
        );
        System.out.println("First thread state=" + first.getState());
        System.out.println("Second thread state=" + second.getState());
        first.start();
        second.start();
        while (first.getState() != Thread.State.TERMINATED || second.getState() != Thread.State.TERMINATED) {
            System.out.println(String.format("First thread state=%s, Second thread state=%s", second.getState(), first.getState()));
        }
        System.out.println("First thread state=" + first.getState());
        System.out.println("Second thread state=" + second.getState());
    }
}
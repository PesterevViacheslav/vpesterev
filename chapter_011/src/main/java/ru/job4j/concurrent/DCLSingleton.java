package ru.job4j.concurrent;
/**
 * Class DCLSingleton - Синглтон. Решение задач уровня Middle. Части 011. Multithreading.
 * 2. Общие ресурсы. 2. Модель памяти Java.[#283077]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 11.06.2020
 * @version 1
 */
public final class DCLSingleton {
    private static volatile DCLSingleton inst;
    public static DCLSingleton instOf() {
        if (inst == null) {
            System.out.println("null 1 pass");
            synchronized (DCLSingleton.class) {
                if (inst == null) {
                    System.out.println("null 2 pass");
                    inst = new DCLSingleton();
                }
            }
        }
        return inst;
    }
    private DCLSingleton() {
    }
}
package ru.job4j;
/**
 * Class Switcher - Свитчер. Решение задач уровня Middle. Части 011. Multithreading.
 * Контрольные вопросы Thread switcher.[#283095]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.09.2020
 * @version 1
 */
public class Switcher {
    public static void main(String[] args) throws InterruptedException {
        MasterSlaveBarrier barrier = new MasterSlaveBarrier();
        Thread first = new Thread(
                () -> {
                    while (true) {
                        try {
                            if (barrier.tryMaster()) {
                                barrier.doneMaster();
                            }
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        Thread second = new Thread(
                () -> {
                    while (true) {
                        try {
                            if (barrier.trySlave()) {
                                barrier.doneSlave();
                            }
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        first.start();
        second.start();
        first.join();
        second.join();
    }
}
package ru.job4j;
/**
 * Class MasterSlaveBarrier - Контроль свитчера. Решение задач уровня Middle. Части 011. Multithreading.
 * Контрольные вопросы Thread switcher.[#283095]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.10.2020
 * @version 1
 */
public class MasterSlaveBarrier {
    private final Object monitor = this;
    private volatile boolean isMaster = false;
    /**
     * Method tryMaster - Контроль потока A
     * @return Получен монитор
     * @throws InterruptedException
     */
    public boolean tryMaster() throws InterruptedException {
        boolean res = false;
        synchronized (monitor) {
            if (!isMaster) {
                System.out.println("Thread A--------------");
                res = true;
            } else {
                monitor.wait();
            }
        }
        return res;
    }
    /**
     * Method trySlave - Контроль потока B
     * @return Получен монитор
     * @throws InterruptedException
     */
    public boolean trySlave() throws InterruptedException {
        boolean res = false;
        synchronized (monitor) {
            if (isMaster) {
                System.out.println("Thread B------------------------------");
                res = true;
            } else {
                monitor.wait();
            }
        }
        return res;
    }
    /**
     * Method doneMaster. Старт потока B
     */
    public void doneMaster() {
        synchronized (monitor) {
            isMaster = true;
            monitor.notifyAll();
        }
    }
    /**
     * Method doneSlave. Старт потока A
     */
    public void doneSlave() {
        synchronized (monitor) {
            isMaster = false;
            monitor.notifyAll();
        }
    }
}
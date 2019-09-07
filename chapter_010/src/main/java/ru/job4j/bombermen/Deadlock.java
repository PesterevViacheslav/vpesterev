package ru.job4j.bombermen;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Class Deadlock - Гарантированный дедлок. Решение задач уровня Middle. Части 001. Multithreading.
 * 10.7.3. Гарантированный дедлок.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.02.2019
 * @version 1
 */
public class Deadlock {
    /**
     * Class Block - Объект блокирования.
    */
    static class Block implements Runnable {
        private CountDownLatch latch;
        private Lock first;
        private Lock second;
        Block(CountDownLatch latch, Lock first, Lock second) {
            this.latch = latch;
            this.first = first;
            this.second = second;
        }
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": first tryLock=" + first.tryLock());
                first.lock();
                System.out.println(Thread.currentThread().getName() + ": latch count=" + latch.getCount());
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + ": locked first latch count=" + latch.getCount());
                latch.await();
                System.out.println(Thread.currentThread().getName() + ": attempt to lock second tryLock=" + second.tryLock());
                second.lock();
                System.out.println(Thread.currentThread().getName() + ": never reached");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        new Thread(new Block(latch, lock1, lock2), "Block thread 1").start();
        new Thread(new Block(latch, lock2, lock1), "Block thread 2").start();
    }
}


package ru.job4j.wait;
/**
 * Class SimpleBlockingQueue - Блокирующая очередь. Решение задач уровня Middle. Части 001. Multithreading.
 * 10.4.2. Обеспечить остановку потребителя.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 04.01.2019
 * @version 1
 */
public class ParallelSearch {
    public static void main(String[] args) throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
        final Thread consumer = new Thread(
                () -> {
                    while (true) {
                        if (!Thread.currentThread().isInterrupted()) {
                            try {
                                System.out.println(queue.poll());
                            } catch (InterruptedException e) {
                                System.out.println("CONSUMER interrupted 1");
                                Thread.currentThread().interrupt();
                            }
                        } else {
                            System.out.println("CONSUMER interrupted");
                            Thread.currentThread().interrupt();
                            break;
                        }
                    }
                }
        );
        final Thread producer = new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        queue.offer(index);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        producer.start();
        System.out.println("Producer start");
        consumer.start();
        System.out.println("Consumer start");
        producer.join();
        System.out.println("Producer finished");
        while (true) {
            if (queue.size() == 0) {
                consumer.interrupt();
                System.out.println("Consumer interrupt");
                break;
            }
        }
        consumer.join();
        System.out.println("Main finished");
    }
}
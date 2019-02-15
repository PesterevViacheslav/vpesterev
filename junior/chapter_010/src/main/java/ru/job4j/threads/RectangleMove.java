package ru.job4j.threads;
import javafx.scene.shape.Rectangle;
/**
 * Class RectangleMove - Логика перемещения мяча. Решение задач уровня Junior. Части 002. Multithreading.
 * 6.1.1. Пинг-понг.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 14.12.2018
 * @version 1
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private int dx;
    private int dy;
    /**
     * Method RectangleMove. Конструктор.
     * @param rect Мяч.
     */
    public RectangleMove(Rectangle rect) {
        this.rect = rect;
        this.dx = 1;
        this.dy = 1;
    }
    /**
     * Method run. Выпонение действия потока.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            this.rect.setX(this.rect.getX() + this.dx);
            this.rect.setY(this.rect.getY() + this.dy);
            if (this.rect.getX() < 0) {
                this.rect.setX(0);
                this.dx = -this.dx;
            }
            if (this.rect.getX() >= PingPong.getLimitX()) {
                this.rect.setX(PingPong.getLimitX());
                this.dx = -this.dx;
            }
            if (this.rect.getY() < 0) {
                this.rect.setY(0);
                this.dy = -this.dy;
            }
            if (this.rect.getY() >= PingPong.getLimitY()) {
                this.rect.setY(PingPong.getLimitY());
                this.dy = -this.dy;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
package ru.job4j.threads;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 * Class PingPong - Компонент отображающия мяч. Решение задач уровня Junior. Части 002. Multithreading.
 * 6.1.1. Пинг-понг.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 14.12.2018
 * @version 1
 */
public class PingPong extends Application {
    private static final String JOB4J = "Пинг-понг www.job4j.ru";
    private static final int LIMIT_X = 300;
    private static final int LIMIT_Y = 300;
    /**
     * Method getLimitX. Получение лимита X.
     * @return лимит X.
     */
    public static int getLimitX() {
        return LIMIT_X;
    }
    /**
     * Method getLimitY. Получение лимита Y.
     * @return лимит Y.
     */
    public static int getLimitY() {
        return LIMIT_Y;
    }
    /**
     * Method start. Запуск потока.
     */
    @Override
    public void start(Stage stage) {
        Group group = new Group();
        Rectangle rect = new Rectangle(50, 100, 10, 10);
        group.getChildren().add(rect);
        new Thread(new RectangleMove(rect)).start();
        stage.setScene(new Scene(group, LIMIT_X, LIMIT_Y));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
    }
}
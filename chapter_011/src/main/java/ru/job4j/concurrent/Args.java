package ru.job4j.concurrent;
/**
 * Class Args - Параметры закачки. Решение задач уровня Middle. Блок 1. Multithreading
 * 1. Threads. 4. Скачивание файла с ограничением.[#283069].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 28.05.2020
 * @version 1
 */
public class Args {
    private String url;
    private int speed;
    /**
     * Method Args. Конструктор
     * @param url
     * @param speed
     */
    public Args(String url, int speed) {
        this.url = url;
        this.speed = speed;
    }
    /**
     * Method getUrl. Получение url
     * @return url
     */
    public String getUrl() {
        return this.url;
    }
    /**
     * Method getSpeed. Получение скорости закачки
     * @return
     */
    public int getSpeed() {
        return this.speed;
    }
}
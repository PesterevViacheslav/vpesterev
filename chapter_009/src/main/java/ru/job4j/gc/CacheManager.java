package ru.job4j.gc;
import java.util.Scanner;
/**
 * Class CacheManager - Менеджер кеша. Решение задач уровня Junior. Части 005. Garbage Collection.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.04.2020
 * @version 1
 */
public class CacheManager {
    private Scanner in;
    private Cache cache;
    private boolean work = true;
    /**
     * Method CacheManager. Конструктор.
     * @param cache
     * @param in Входной поток
     */
    public CacheManager(Cache cache, Scanner in) {
        this.cache = cache;
        this.in = in;
    }
    /**
     * Method start. Запуск менеджера
     * @param menu Меню
     */
    public void start(CacheMenu menu) {
        String key;
        menu.show();
        do {
            System.out.println("Enter operation:");
            key = in.next();
            menu.select(key);
        } while (this.work);
    }
    /**
     * Method getIn. Получение потока ввода/вывода
     * @return Поток ввода/вывода.
     */
    public Scanner getIn() {
        return in;
    }
    /**
     * Method stop. Прекращение работы.
     */
    public void stop() {
        this.work = false;
    }
}
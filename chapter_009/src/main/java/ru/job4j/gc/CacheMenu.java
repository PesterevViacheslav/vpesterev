package ru.job4j.gc;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Class CacheMenu - Меню кеша. Решение задач уровня Junior. Части 005. Garbage Collection.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.04.2020
 * @version 1
 */
public class CacheMenu {
    private Cache cache;
    private Scanner in;
    private HashMap<String, CacheActions> actions = new HashMap<>();
    /**
     * Method CacheMenu. Конструктор
     * @param in
     * @param cache
     */
    public CacheMenu(Scanner in, Cache cache) {
        this.in = in;
        this.cache = cache;
    }
    /**
     * Method show. Заполнение информация об операции.
     */
    public void show() {
        System.out.println("Cache MENU");
        System.out.println("------------");
        this.actions.entrySet().forEach(entry -> System.out.println(entry.getValue().info()));
        System.out.println("------------");
    }
    /**
     * Method select. Выбор операции.
     * @param key Код операции.
     */
    public void select(String key) {
        if (this.actions.containsKey(key)) {
            this.actions.get(key).execute(this.in, this.cache);
        } else {
            System.out.println("Wrong menu key");
        }
    }
    /**
     * Method addActions. Добавление действия.
     */
    public void addActions(CacheActions cacheActions) {
        this.actions.put(cacheActions.key(), cacheActions);
    }
}
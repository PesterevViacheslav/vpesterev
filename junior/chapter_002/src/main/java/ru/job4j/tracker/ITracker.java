package ru.job4j.tracker;
import java.util.ArrayList;
/**
 * Interface ITracker - Работа с БД. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.4.2. Трекер SQL.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.08.2019
 * @version 1
 */
public interface ITracker {
    /**
     * Method add. Добавление заявки.
     * @param item Заявка.
     * @return Заявка
     */
    Item add(Item item);
    /**
     * Method replace. Замена заявки.
     * @param id ID заявки.
     * @param item Заявка.
     * @return Признак найдена ли заявка
     */
    boolean replace(String id, Item item);
    /**
     * Method delete. Удаление заявки.
     * @param id ID заявки.
     * @return Признак найдена ли заявка
     */
    boolean delete(String id);
    /**
     * Method findAll. Получение списка текущих заявок.
     * @return Заявки.
     */
    ArrayList<Item> findAll();
    /**
     * Method findByName. Поиск заявок по названию.
     * @param name Название заявки.
     * @return Заявка
     */
    ArrayList<Item> findByName(String name);
    /**
     * Method findById. Поиск заявки по ID.
     * @param id ID заявки.
     * @return Заявка
     */
    Item findById(String id);
    /**
     * Method change. Изменение заявки.
     * @param id ID заявки.
     * @param item Заявка.
     * @return Признак найдена ли заявка
     */
    boolean change(String id, Item item);
}
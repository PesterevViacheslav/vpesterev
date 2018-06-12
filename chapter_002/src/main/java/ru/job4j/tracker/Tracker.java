package ru.job4j.tracker;
import java.util.Arrays;
import java.util.Date;

/**
 * Class Tracker - Обработка заявок. Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.04.2018
 * @version 1
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    /**
     * Method size. Получить размер стека заявок.
     */
    public int size() {
        return this.position;
    }
    /**
     * Method add. Добавление заявки.
     * @param item Заявка.
     * @return Заявка
     */
    public Item add(Item item) {
        this.items[position++] = item;
        return item;
    }
    /**
     * Method findById. Поиск заявки по ID.
     * @param id ID заявки.
     * @return Заявка
     */
    public Item findById(String id) {
        Item result = new Item();
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && id.equals(this.items[i].getId())) {
                result = this.items[i];
                break;
            }
        }
        return result;
    }
    /**
     * Method findByName. Поиск заявок по названию.
     * @param name Название заявки.
     * @return Заявка
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[100];
        int length = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && name.equals(this.items[i].getName())) {
                result[length] = this.items[i];
                length++;
            }
        }
        return Arrays.copyOf(result, length);
    }
    /**
     * Method replace. Замена заявки.
     * @param id ID заявки.
     * @param item Заявка.
     */
    public void replace(String id, Item item) {
        Item result = findById(id);
        result.setId(item.getId());
        result.setName(item.getName());
        result.setDescription(item.getDescription());
        result.setChanged(System.currentTimeMillis());
    }
    /**
     * Method change. Изменение заявки.
     * @param id ID заявки.
     * @param item Заявка.
     */
    public void change(String id, Item item) {
        Item result = findById(id);
        result.setName(item.getName());
        result.setDescription(item.getDescription());
        result.setChanged(System.currentTimeMillis());
    }
    /**
     * Method delete. Удаление заявки.
     * @param id ID заявки.
     */
    public void delete(String id) {
        Item exists = findById(id);
        if (this.position > 0 && exists.getId() != null) {
            int positionTmp = 0;
            for (int i = 0; i < this.position; i++) {
                positionTmp++;
                if (this.items[i].getId().equals(id)) {
                    break;
                }
            }
            this.position--;
            System.arraycopy(this.items, positionTmp, this.items, positionTmp - 1, this.position - positionTmp + 1);
        }
    };
    /**
     * Method findAll. Получение списка текущих заявок.
     * @return Заявки.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }
}
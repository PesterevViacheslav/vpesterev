package ru.job4j.tracker;

/**
 * Class BaseAction - Основные действия меню трекера. Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.06.2018
 * @version 1
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;
    /**
     * Method BaseAction. Конструктор.
     * @param key Значение ключа меню.
     * @param name Название действия меню.
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }
    /**
     * Method key. Возврат номера операции.
     * @return Номер операции.
     */
    @Override
    public int key() {
        return this.key;
    }
    /**
     * Method info. Отображение информации об операции.
     * @return Информация об операции.
     */
    @Override
    public String info() {
        return String.format("%s%s", this.key, this.name);
    }
}
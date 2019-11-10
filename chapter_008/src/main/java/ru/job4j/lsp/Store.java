package ru.job4j.lsp;
/**
 * Class Store - Хранилище. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.11.2019
 * @version 1
 */
public interface Store {
    /**
     * Method accept. Контроль качества продукта
     * @param food Продукт.
     * @param expirePercent Срок годности
     * @return
     */
    boolean accept(Food food, double expirePercent);
    /**
     * Method add. Добавление в хранилище
     * @param food Продукт.
     */
    void add(Food food);
}
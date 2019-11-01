package ru.job4j.lsp;
import java.util.Date;
/**
 * Class Pizza - Пицца. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class Pizza extends Food {
    private int radius;
    /**
     * Method Pizza. Конструктор
     *
     * @param name - Название
     * @param price - Цена
     * @param discount - Признак есть ли скидка
     * @param expireDate - Дата истечения срока годности
     * @param createDate - Дата создания
     * @param radius - Радиус пиццы
     */
    public Pizza(String name, double price, int discount, Date expireDate, Date createDate, int radius) {
        super(name, price, discount, expireDate, createDate);
        this.radius = radius;
    }
}
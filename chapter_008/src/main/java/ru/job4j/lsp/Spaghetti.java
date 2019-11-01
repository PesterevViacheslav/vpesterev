package ru.job4j.lsp;
import java.util.Date;
/**
 * Class Spaghetti - Спагетти. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class Spaghetti extends Food {
    private int length;
    /**
     * Method Food. Конструктор
     *
     * @param name - Название
     * @param price - Цена
     * @param discount - Признак есть ли скидка
     * @param expireDate - Дата истечения срока годности
     * @param createDate - Дата создания
     * @param length - Длина
     */
    public Spaghetti(String name, double price, int discount, Date expireDate, Date createDate, int length) {
        super(name, price, discount, expireDate, createDate);
        this.length = length;
    }
}
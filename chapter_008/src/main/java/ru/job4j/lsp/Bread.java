package ru.job4j.lsp;
import java.time.LocalDate;
import java.util.Date;
/**
 * Class Bread - Хлеб. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class Bread extends Food {
    private double weight;
    private String colour;
    /**
     * Method Food. Конструктор
     *
     * @param name - Название
     * @param price - Цена
     * @param discount - Признак есть ли скидка
     * @param expireDate - Дата истечения срока годности
     * @param createDate - Дата создания
     * @param weight - Масса
     * @param colour - Цвет
     */
    public Bread(String name, double price, int discount, LocalDate expireDate, LocalDate createDate, double weight, String colour) {
        super(name, price, discount, expireDate, createDate);
        this.weight = weight;
        this.colour = colour;
    }
}
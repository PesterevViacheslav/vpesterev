package ru.job4j.lsp;
import java.time.LocalDate;
/**
 * Class Food - Продукт. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class Food {
    private String name;
    private double price;
    private int discount;
    private LocalDate expireDate;
    private LocalDate createDate;
    /**
     * Method Food. Конструктор
     * @param name - Название
     * @param price - Цена
     * @param discount - Признак есть ли скидка
     * @param expireDate - Дата истечения срока годности
     * @param createDate - Дата создания
     */
    public Food(String name, double price, int discount, LocalDate expireDate, LocalDate createDate) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.expireDate = expireDate;
        this.createDate = createDate;
    }
    /**
     * Method getExpireDate. Срок годности продукта.
     * @return Дата
     */
    public LocalDate getExpireDate() {
        return this.expireDate;
    }
    /**
     * Method getCreateDate. Дата изготовления продукта.
     * @return Дата
     */
    public LocalDate getCreateDate() {
        return this.createDate;
    }
    /**
     * Method setDiscount. Установка скидки.
     * @param discount Скидка
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
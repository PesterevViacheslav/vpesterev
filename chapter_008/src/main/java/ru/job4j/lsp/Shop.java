package ru.job4j.lsp;
/**
 * Class Shop - Магазин. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class Shop extends Storage implements Store {
    private String address;
    private String name;
    /**
     * Method Shop. Конструктор.
     * @param address Адрес.
     * @param name Название.
     */
    public Shop(String address, String name) {
        super();
        this.address = address;
        this.name = name;
    }
    /**
     * Method accept. Контроль качества продукта
     * @param food Продукт.
     * @param expirePercent Срок годности
     * @return
     */
    @Override
    public boolean accept(Food food, double expirePercent) {
        boolean res = false;
        if (expirePercent <= 0.75 && expirePercent > 0.25) {
            res = true;
        } else if (expirePercent >= 0.25 && expirePercent > 0.01) {
            food.setDiscount(1);
            res = true;
        }
        return res;
    }
}
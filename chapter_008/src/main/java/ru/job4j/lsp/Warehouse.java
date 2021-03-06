package ru.job4j.lsp;
/**
 * Class Warehouse - Склад. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class Warehouse extends Storage implements Store {
    private String address;
    /**
     * Method Warehouse. Конструктор
     * @param address Адрес
     */
    public Warehouse(String address) {
        super();
        this.address = address;
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
        if (expirePercent > 0.75) {
            res = true;
        }
        return res;
    }
}
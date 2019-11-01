package ru.job4j.lsp;
/**
 * Class Warehouse - Склад. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class Warehouse extends Storage {
    private String address;
    /**
     * Method Warehouse. Конструктор
     * @param address Адрес
     */
    public Warehouse(String address) {
        super();
        this.address = address;
    }
}
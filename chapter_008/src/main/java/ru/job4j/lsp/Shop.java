package ru.job4j.lsp;
/**
 * Class Shop - Магазин. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class Shop extends Storage {
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
}
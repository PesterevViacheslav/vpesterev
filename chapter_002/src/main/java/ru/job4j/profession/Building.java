package ru.job4j.profession;
/**
 * Class Building решение задачи Части 002. ООП урок 2.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.04.2018
 * @version 1
 */
public class Building {
    private String kind;
    /**
     * Method Building. Конструктор.
     * @param kind Тип здания.
     */
    public Building(String kind) {
        this.kind = kind;
    }
    /**
     * Method getKind. Установить значение типа.
     */
    public void setKind(String name) {
        this.kind = kind;
    }
    /**
     * Method getKind. Получить значение типа.
     */
    public String getKind() {
        return this.kind;
    }
}
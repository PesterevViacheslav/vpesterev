package ru.job4j.profession;
/**
 * Class Student решение задачи Части 002. ООП урок 2.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.04.2018
 * @version 1
 */
public class Student {
    private String name;
    /**
     * Method Student. Конструктор.
     * @param name Имя.
     */
    public Student(String name) {
        this.name = name;
    }
    /**
     * Method setName. Установить значение имени.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method getName. Получить значение имени.
     */
    public String getName() {
        return this.name;
    }
}
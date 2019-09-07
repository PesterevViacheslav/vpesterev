package ru.job4j.profession;
/**
 * Class Profession решение задачи Части 002. ООП урок 2.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.04.2018
 * @version 1
 */
public class Profession {
    private String name;
    private String profession;
    /**
     * Method Profession. Конструктор.
     * @param name Имя.
     * @param profession Профессия.
     */
    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }
    /**
     * Method getName. Получить значение имени.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Method getProfession. Получить значение профессии.
     */
    public String getProfession() {
        return this.profession;
    }
}
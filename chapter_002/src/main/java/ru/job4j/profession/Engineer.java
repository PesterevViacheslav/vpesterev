package ru.job4j.profession;
import java.util.Date;
/**
 * Class Engineer решение задачи Части 002. ООП урок 2.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.04.2018
 * @version 1
 */
public class Engineer extends Profession {
    /**
     * Method Engineer. Конструктор.
     * @param name Имя.
     */
    public Engineer(String name) {
        super(name, "Инженер");
    }
    /**
     * Method build. Строить.
     * @param building Здание.
     */
    public Report build(Building building) {
        String note = "Ждем цемент. " + this.getProfession() + " " + this.getName();
        Date period = new Date(2018, 05, 30);
        Report report = new Report(note, period);
        return report;
    }
}
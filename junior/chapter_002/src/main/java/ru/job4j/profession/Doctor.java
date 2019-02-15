package ru.job4j.profession;
/**
 * Class Doctor решение задачи Части 002. ООП урок 2.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.04.2018
 * @version 1
 */
public class Doctor extends Profession {
    /**
     * Method Doctor. Конструктор.
     * @param name Имя.
     */
    public Doctor(String name) {
        super(name, "Доктор");
    }
    /**
     * Method heal. Лечить.
     * @param patient Пациент.
     */
    public Diagnose heal(Patient patient) {
        String description = patient.getName() + " Здоров. " + this.getProfession() + " " + this.getName();
        return new Diagnose(description, "Витамины");
    }
}
package ru.job4j.profession;
/**
 * Class Teacher решение задачи Части 002. ООП урок 2.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.04.2018
 * @version 1
 */
public class Teacher extends Profession {
    /**
     * Method Teacher. Конструктор.
     * @param name Имя.
     */
    public Teacher(String name) {
        super(name, "Учитель");
    }
    /**
     * Method teach. Учить.
     * @param student Студент.
     */
    public Mark teach(Student student) {
        return new Mark(5, this.getProfession() + " " + this.getName());
    }
}
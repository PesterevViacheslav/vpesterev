package ru.job4j.profession;
import java.util.Date;
/**
 * Class Report решение задачи Части 002. ООП урок 2.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.04.2018
 * @version 1
 */
public class Report {
    private String note;
    private Date period;
    /**
     * Method Report. Конструктор.
     * @param note Состояние работ.
     * @param period Срок выполнения.
     */
    public Report(String note, Date period) {
        this.note = note;
        this.period = period;
    };
    /**
     * Method getNote. Получить состояние работ.
     */
    public String getNote() {
        return this.note;
    }
    /**
     * Method getPeriod. Получить срок выполнения.
     */
    public Date getPeriod() {
        return this.period;
    }
}
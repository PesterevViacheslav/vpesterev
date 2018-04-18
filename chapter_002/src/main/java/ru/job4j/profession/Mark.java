package ru.job4j.profession;
/**
 * Class Mark решение задачи Части 002. ООП урок 2.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.04.2018
 * @version 1
 */
public class Mark {
    private int mark;
    private String note;
    /**
     * Method Mark. Конструктор.
     * @param mark Оценка.
     * @param note Комментарий.
     */
    public Mark(int mark, String note) {
        this.mark = mark;
        this.note = note;
    };
    /**
     * Method getMark. Получить значение оценки.
     */
    public int getMark() {
        return this.mark;
    }
    /**
     * Method getNote. Получить комментарий.
     */
    public String getNote() {
        return this.note;
    }
}

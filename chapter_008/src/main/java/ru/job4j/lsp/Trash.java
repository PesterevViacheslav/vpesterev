package ru.job4j.lsp;
import java.util.Date;
/**
 * Class Trash - Мусорка. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class Trash extends Storage {
    private Date deletePeriod;

    public Trash(Date deletePeriod) {
        super();
        this.deletePeriod = deletePeriod;
    }
}
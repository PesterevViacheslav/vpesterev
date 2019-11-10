package ru.job4j.lsp;
import java.time.LocalDate;
/**
 * Class Trash - Мусорка. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class Trash extends Storage implements Store {
    private LocalDate deletePeriod;
    /**
     * Method Trash. Конструктор.
     * @param deletePeriod Срок очистки.
     */
    public Trash(LocalDate deletePeriod) {
        super();
        this.deletePeriod = deletePeriod;
    }
    /**
     * Method accept. Контроль качества продукта
     * @param food Продукт.
     * @param expirePercent Срок годности
     * @return
     */
    @Override
    public boolean accept(Food food, double expirePercent) {
        boolean res = false;
        if (expirePercent < 0.25) {
            res = true;
        }
        return res;
    }
}
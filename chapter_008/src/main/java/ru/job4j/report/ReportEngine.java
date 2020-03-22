package ru.job4j.report;
import java.util.function.Predicate;
/**
 * Class ReportEngine - Генератор отчетов. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.03.2020
 * @version 1
 */
public class ReportEngine {
    private Store store;
    /**
     * Method ReportEngine. Конструктор
     * @param store Хранилище
     */
    public ReportEngine(Store store) {
        this.store = store;
    }
    /**
     * Method generate. Сгенерировать отчет
     * @param filter Фильтр
     * @param department Подразделение
     * @return Строка для печати
     */
    public String generate(Predicate<Employer> filter, Print department) {
        return department.print(this.store, filter);
    }
}
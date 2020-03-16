package ru.job4j.report;
import java.util.function.Predicate;
/**
 * Interface Print - Печать. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.03.2020
 * @version 1
 */
public interface Print {
    /**
     * Method print. Формирование строки для печати
     * @param store Хранилище
     * @param filter Фильтр
     * @return Строка для печати
     */
    String print(Store store, Predicate<Employer> filter);
}

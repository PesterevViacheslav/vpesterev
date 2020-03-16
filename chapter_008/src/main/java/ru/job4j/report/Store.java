package ru.job4j.report;
import java.util.List;
import java.util.function.Predicate;
/**
 * Interface Store - Хранилище. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.03.2020
 * @version 1
 */
public interface Store {
    /**
     * Method findBy. Поиск по хранилищу
     * @param filter
     * @return
     */
    List<Employer> findBy(Predicate<Employer> filter);
}

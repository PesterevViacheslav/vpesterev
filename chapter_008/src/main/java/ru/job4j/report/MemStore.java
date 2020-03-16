package ru.job4j.report;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 * Class MemStore - Хранилище. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.03.2020
 * @version 1
 */
public class MemStore implements Store {
    private final List<Employer> employers = new ArrayList<>();
    /**
     * Method add. Добавление в хранилище
     * @param em
     */
    public void add(Employer em) {
        employers.add(em);
    }
    /**
     * Method findBy. Поиск по хранилищу
     * @param filter
     * @return
     */
    @Override
    public List<Employer> findBy(Predicate<Employer> filter) {
        return employers.stream().filter(filter).collect(Collectors.toList());
    }
}
package ru.job4j.report;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
/**
 * Class HR - Подразделение - HR. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.03.2020
 * @version 1
 */
public class HR extends ReportDepartment {
    /**
     * Method HR. Конструктор
     * @param name Название
     */
    public HR(String name) {
        super(name);
    }
    /**
     * Method print. Формирование строки для печати
     * @param store Хранилище
     * @param filter Фильтр
     * @return Строка для печати
     */
    @Override
    public String print(Store store, Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        List<Employer> list = new ArrayList();
        for (Employer employer : store.findBy(filter)) {
            list.add(employer);
        }
        Collections.sort(list, (a, b) -> {
            int res = 0;
            if (b.getSalary() > a.getSalary()) {
                res = 1;
            } else if (b.getSalary() < a.getSalary()) {
                res = -1;
            }
            return res;
        });
        text.append("Name; Salary");
        for (Employer employer : list) {
            text.append(employer.getName()).append(";")
                .append(employer.getSalary()).append(";");
        }
        return text.toString();
    }
}
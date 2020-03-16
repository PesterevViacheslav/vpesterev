package ru.job4j.report;
import java.util.function.Predicate;
/**
 * Class ReportDepartment - Подразделение печати. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.03.2020
 * @version 1
 */
public class ReportDepartment implements Print {
    private String name;
    /**
     * Method ReportDepartment. Конструктор
     * @param name Название
     */
    public ReportDepartment(String name) {
        this.name = name;
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
        text.append("Name; Hired; Fired; Salary");
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        return text.toString();
    }
}
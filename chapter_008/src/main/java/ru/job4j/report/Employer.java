package ru.job4j.report;
import java.util.Calendar;
import java.util.Objects;
/**
 * Class Employer - Сотрудник. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.03.2020
 * @version 1
 */
public class Employer {
    private String name;
    private Calendar hired;
    private Calendar fired;
    private double salary;
    /**
     * Method Employer. Конструктор
     * @param name
     * @param hired
     * @param fired
     * @param salary
     */
    public Employer(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }
    /**
     * Method getName. Получение имени
     * @return Имя
     */
    public String getName() {
        return name;
    }
    /**
     * Method setName Установка имени
     * @param name Имя
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method getHired. Получение имени
     * @return Дата приема
     */
    public Calendar getHired() {
        return hired;
    }
    /**
     * Method setHired. Установка даты приема
     * @param hired Дата приема
     */
    public void setHired(Calendar hired) {
        this.hired = hired;
    }
    /**
     * Method getFired. Получение имени
     * @return Дата увольнения
     */
    public Calendar getFired() {
        return fired;
    }
    /**
     * Method setFired Установка даты увольнения
     * @param fired Дата увольнения
     */
    public void setFired(Calendar fired) {
        this.fired = fired;
    }
    /**
     * Method getSalary. Получение имени
     * @return ЗП
     */
    public double getSalary() {
        return salary;
    }
    /**
     * Method setSalary Установка ЗП
     * @param salary ЗП
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employer employer = (Employer) o;
        return Objects.equals(name, employer.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
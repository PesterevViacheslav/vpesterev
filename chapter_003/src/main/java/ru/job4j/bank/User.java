package ru.job4j.bank;
import java.util.Objects;
/**
 * Class User - Пользователь. Решение задачи Части 003. Collections. Lite.
 * Задача 5.2  Банковские переводы.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.08.2018
 * @version 1
 */
public class User implements Comparable {
    private String name;
    private String passport;
    /**
     * Method User. Конструктор.
     * @param name Имя.
     * @param passport Паспорт.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }
    /**
     * Method getName. Получить значение Имя.
     * @return Имя.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Method getPassport. Получить значение Паспорт.
     * @return Паспорт.
     */
    public String getPassport() {
        return this.passport;
    }
    @Override
    public String toString() {
        return "User{'name='" + name + "'" + ", passport='" + passport + "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return  Objects.equals(name, user.name) && Objects.equals(passport, user.passport);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }
    @Override
    public int compareTo(Object o) {
        int result;
        User user = (User) o;
        result = this.name.compareTo(user.name);
        return result;
    }
}
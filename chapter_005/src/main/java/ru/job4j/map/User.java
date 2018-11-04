package ru.job4j.map;
import java.util.Calendar;
import java.util.Objects;

/**
 * Class User - Пользователь. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.5.1. Создать модель User.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 04.11.2018
 * @version 1
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;
    /**
     * Method User. Конструктор.
     * @param name Имя.
     * @param children Дети.
     * @param birthday Дата рождения.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    /**
     * Method getName. Метод получения имени.
     * @return Имя.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Method setName. Метод установки имени.
     * @param name Имя.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method getChildren. Метод получения признака ребенка.
     * @return Признак.
     */
    public int getChildren() {
        return this.children;
    }
    /**
     * Method setChildren. Метод установки признака ребенка.
     * @param children Признак.
     */
    public void setChildren(int children) {
        this.children = children;
    }
    /**
     * Method getBirthday. Метод получения даты рождения.
     * @return Дата рождения.
     */
    public Calendar getBirthday() {
        return this.birthday;
    }
    /**
     * Method setBirthday. Метод установки даты рождения.
     * @param birthday Дата рождения.
     */
    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }
    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", children=" + children + " HashCode=" + this.hashCode() + '}';
    }
}
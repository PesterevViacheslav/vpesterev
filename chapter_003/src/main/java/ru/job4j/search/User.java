package ru.job4j.search;
import java.util.Objects;
/**
 * Class User - Пользователь. Решение задачи Части 003. Collections. Lite.
 * Задача 2.2  Написать программу преобразования List в Map.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.07.2018
 * @version 1
 */
public class User {
    private int id;
    private String name;
    private String city;
    /**
     * Method User. Конструктор.
     * @param id Идентификатор.
     * @param name Имя.
     * @param city Город.
\     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    /**
     * Method getId. Получить значение id.
     * @return id.
     */
    public int getId() {
        return id;
    }
    /**
     * Method getName. Получить значение имени.
     * @return Имя.
     */
    public String getName() {
        return name;
    }
    /**
     * Method getCity. Получить значение города.
     * @return Город.
     */
    public String getCity() {
        return city;
    }
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", city='" + city + '\'' + '}';
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
        return  id == user.id && Objects.equals(name, user.name) && Objects.equals(city, user.city);
    }
    @Override
    public int hashCode() {

        return Objects.hash(id, name, city);
    }
}
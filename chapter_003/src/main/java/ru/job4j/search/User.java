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
public class User implements Comparable {
    private int id;
    private String name;
    private int age;
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
        this.age = 1;
    }
    /**
     * Method User. Конструктор.
     * @param id Идентификатор.
     * @param name Имя.
     * @param city Город.
     * @param age Возраст
    */
    public User(int id, String name, String city, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }
    /**
     * Method getId. Получить значение id.
     * @return id.
     */
    public int getId() {
        return this.id;
    }
    /**
     * Method getName. Получить значение имени.
     * @return Имя.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Method getCity. Получить значение города.
     * @return Город.
     */
    public int getAge() {
        return this.age;
    }
    /**
     * Method getCity. Получить значение города.
     * @return Город.
     */
    public String getCity() {
        return this.city;
    }
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + "'" + ", city='" + city + "', age=" + age + "}";
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
        return  id == user.id && Objects.equals(name, user.name) && Objects.equals(city, user.city) && age == user.age;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, age);
    }

    @Override
    public int compareTo(Object o) {
        int result;
        User user = (User) o;
        result = this.age - user.age;
        return result != 0 ? result : this.id - user.id;
    }
}
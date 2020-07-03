package ru.job4j.concurrent;
/**
 * Class User - Пользователь. Решение задач уровня Middle. Части 011. Multithreading.
 * 4. Thread без общих ресурсов[#283079]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 03.07.2020
 * @version 1
 */
public class User {
    private int id;
    private String name;
    /**
     * Method of. Создание копии объекта
     * @param name Имя
     * @return Пользователь
     */
    public static User of(String name) {
        User user = new User();
        user.name = name;
        return user;
    }
    /**
     * Method getId. Получение Id
     * @return Id
     */
    public int getId() {
        return this.id;
    }
    /**
     * Method setId. Установка Id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Method getName. Получение имени
     * @return Имя
     */
    public String getName() {
        return this.name;
    }
    /**
     * Method setName. Установка имени
     * @param name Имя
     */
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
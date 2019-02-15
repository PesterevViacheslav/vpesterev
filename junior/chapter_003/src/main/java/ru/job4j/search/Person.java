package ru.job4j.search;
/**
 * Class Person - Персона. Решение задачи Части 003. Collections. Lite Задача 1.1  Телефонный справочник на базе ArrayList.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 09.07.2018
 * @version 1
 */
public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;
    /**
     * Method Person. Конструктор.
     * @param name Имя.
     * @param surname Фамилия.
     * @param phone Телефон.
     * @param address Адрес.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }
    /**
     * Method getName. Получить значение имени.
     * @return Имя.
     */
    public String getName() {
        return name;
    }
    /**
     * Method getSurname. Получить значение фамилии.
     * @return Фамилия.
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Method getPhone. Получить значение телефона.
     * @return Телефон.
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Method getAddress. Получить значение адреса.
     * @return Адрес.
     */
    public String getAddress() {
        return address;
    }
}
package ru.job4j.search;
import java.util.ArrayList;
import java.util.List;
/**
 * Class PhoneDictionary - Телефонный справочник. Решение задачи Части 003. Collections. Lite Задача 1.1  Телефонный справочник на базе ArrayList.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 09.07.2018
 * @version 1
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();
    /**
     * Method add. Добавление в справочник.
     * @param person Абонент.
     */
    public void add(Person person) {
        this.persons.add(person);
    }
    /**
     * Method find. Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : this.persons) {
            if (person.getSurname().contains(key) || person.getName().contains(key) || person.getPhone().contains(key) || person.getAddress().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
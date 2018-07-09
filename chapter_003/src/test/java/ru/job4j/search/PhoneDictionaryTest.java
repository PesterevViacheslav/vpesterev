package ru.job4j.search;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class PhoneDictionaryTest автотесты для задачи Части 003. Collections. Lite Задача 1.1  Телефонный справочник на базе ArrayList.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 09.07.2018
 * @version 1
 */
public class PhoneDictionaryTest {
    /**
     * Тест поиска по имени (записи найдены).
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Name1", "Surname1", "9211111111", "Address1"));
        phones.add(new Person("Name2", "Surname2", "9211111112", "Address2"));
        List<Person> persons = phones.find("Name");
        assertThat(persons.get(0).getSurname(), is("Surname1"));
        assertThat(persons.get(1).getSurname(), is("Surname2"));
    }
    /**
     * Тест поиска по имени (записи не найдены).
     */
    @Test
    public void whenNotFoundByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Name1", "Surname1", "9211111111", "Address1"));
        phones.add(new Person("Name2", "Surname2", "9211111112", "Address2"));
        List<Person> persons = phones.find("Name3");
        assertThat(persons.size(), is(0));
    }
    /**
     * Тест поиска по фамилии (записи найдены).
     */
    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Name1", "Surname1", "9211111111", "Address1"));
        phones.add(new Person("Name2", "Surname2", "9211111112", "Address2"));
        List<Person> persons = phones.find("Surname");
        assertThat(persons.get(0).getSurname(), is("Surname1"));
        assertThat(persons.get(1).getSurname(), is("Surname2"));
    }
    /**
     * Тест поиска по фамилии (записи не найдены).
     */
    @Test
    public void whenNotFoundBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Name1", "Surname1", "9211111111", "Address1"));
        phones.add(new Person("Name2", "Surname2", "9211111112", "Address2"));
        List<Person> persons = phones.find("Surname3");
        assertThat(persons.size(), is(0));
    }
    /**
     * Тест поиска по телефону (записи найдены).
     */
    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Name1", "Surname1", "9211111111", "Address1"));
        phones.add(new Person("Name2", "Surname2", "9211111112", "Address2"));
        List<Person> persons = phones.find("921111");
        assertThat(persons.get(0).getSurname(), is("Surname1"));
        assertThat(persons.get(1).getSurname(), is("Surname2"));
    }
    /**
     * Тест поиска по телефону (записи не найдены).
     */
    @Test
    public void whenNotFoundByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Name1", "Surname1", "9211111111", "Address1"));
        phones.add(new Person("Name2", "Surname2", "9211111112", "Address2"));
        List<Person> persons = phones.find("9211111113");
        assertThat(persons.size(), is(0));
    }
    /**
     * Тест поиска по адресу (записи найдены).
     */
    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Name1", "Surname1", "9211111111", "Address1"));
        phones.add(new Person("Name2", "Surname2", "9211111112", "Address2"));
        List<Person> persons = phones.find("Address");
        assertThat(persons.get(0).getSurname(), is("Surname1"));
        assertThat(persons.get(1).getSurname(), is("Surname2"));
    }
    /**
     * Тест поиска по адресу (записи не найдены).
     */
    @Test
    public void whenNotFoundByAddres() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Name1", "Surname1", "9211111111", "Address1"));
        phones.add(new Person("Name2", "Surname2", "9211111112", "Address2"));
        List<Person> persons = phones.find("Address3");
        assertThat(persons.size(), is(0));
    }
}
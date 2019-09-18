package ru.job4j.jdbc.sql_ru_parser;
/**
 * Class Vacancy - Вакансия SQL.ru. Решение задач уровня Junior. Части 003. SQL, JDBC
 * 7.5.2. Парсер вакансий на sql.ru.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.09.2019
 * @version 1
 */
public class Vacancy {
    private int id;
    private String name;
    private String description;
    private String link;
    /**
     * Method Vacancy. Конструктор.
     * @param name Название вакансии.
     * @param description Описание вакансии.
     * @param link Ссылка.
     * @return Заявка
     */
    public Vacancy(String name, String description, String link) {
        this.name = name;
        this.description = description;
        this.link = link;
    }
    /**
     * Method getName. Получение названия вакансии.
     * @return Значение
     */
    public String getName() {
        return name;
    }
    /**
     * Method getDescription. Получение описания вакансии.
     * @return Значение
     */
    public String getDescription() {
        return description;
    }
    /**
     * Method getLink. Получение ссылки на вакансию.
     * @return Значение
     */
    public String getLink() {
        return link;
    }
    /**
     * Method getId. Получение id вакансии.
     * @return Значение
     */
    public int getId() {
        return id;
    }
    /**
     * Method setID. Установка ID вакансии.
     * @param id ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vacancy{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", link='" + link + '\'' + '}';
    }
}
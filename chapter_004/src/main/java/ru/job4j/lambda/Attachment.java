package ru.job4j.lambda;
/**
 * Class Attachment - Приложенный файл. Решение задач уровня Стажер. Части 04. FP, Lambda, Stream API.
 * 1. Lambda. 1. Анонимные классы [#214142].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 11.05.2020
 * @version 1
 */
public class Attachment {
    private String name;
    private int size;
    /**
     * Method Attachment. Конструктор
     * @param name Имя
     * @param size Размер
     */
    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }
    /**
     * Method getName. Получение имени
     * @return Имя
     */
    public String getName() {
        return this.name;
    }
    /**
     * Method getSize. Получение размера
     * @return Размер
     */
    public int getSize() {
        return this.size;
    }
    @Override
    public String toString() {
        return "{" + "name='" + name + '\'' + ", size=" + size + '}';
    }
}
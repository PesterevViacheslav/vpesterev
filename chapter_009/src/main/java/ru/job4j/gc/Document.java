package ru.job4j.gc;
import java.io.File;
/**
 * Class Document - Документ. Решение задач уровня Junior. Части 005. Garbage Collection.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.04.2020
 * @version 1
 */
public class Document {
    private String name;
    private File file;
    /**
     * Method Document. Конструктор
     * @param name Имя
     * @param file Файл
     */
    public Document(String name, File file) {
        this.name = name;
        this.file = file;
    }
    /**
     * Method getFile. Получение файла
     * @return Файл
     */
    public File getFile() {
        return file;
    }
    @Override
    public String toString() {
        return "Document{name=" + name + " text=" + file.toString() + '}';
    }
}
package ru.job4j.synchronize;
import java.io.*;
/**
 * Class ParseFile - Разбор файла. Решение задач уровня Middle. Части 011. Multithreading.
 * Синхронизация. 1. Visibility. Общий ресурс вне критической секции[#283084]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.07.2020
 * @version 1
 */
public class ParseFile {
    private final Content content;
    private final File file;
    /**
     * Method ParseFile. Конструктор
     * @param content
     * @param file
     */
    public ParseFile(Content content, File file) {
        this.content = content;
        this.file = file;
    }
    /**
     * Method getFile. Получение файла
     */
    public synchronized File getFile() {
        return this.file;
    }
    /**
     * Method getContent. Получение содержимого файла
     * @return Содержимое
     * @throws IOException
     */
    public synchronized String getContent() throws IOException {
        return this.content.get(this.file);
    }
    /**
     * Method saveContent. Сохранение в файл
     * @param content Строка
     * @throws IOException
     */
    public synchronized void saveContent(String content) throws IOException {
        try (OutputStream o = new FileOutputStream(this.file)) {
            o.write(content.getBytes());
        }
    }
}
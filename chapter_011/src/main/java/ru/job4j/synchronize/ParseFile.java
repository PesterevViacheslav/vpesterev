package ru.job4j.synchronize;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Class ParseFile - Разбор файла. Решение задач уровня Middle. Части 011. Multithreading.
 * Синхронизация. 1. Visibility. Общий ресурс вне критической секции[#283084]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.07.2020
 * @version 1
 */
public class ParseFile {
    private File file;
    /**
     * Method ParseFile. Конструктор
     * @param file
     */
    public ParseFile(File file) {
        this.file = file;
    }
    /**
     * Method setFile. Изменения файла
     * @param file Файл
     */
    public synchronized void setFile(File file) {
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
        String output = "";
        if (this.file != null) {
            output = new String(Files.readAllBytes(Paths.get(file.getPath())));
        }
        return output;
    }
    /**
     * Method getContentWithoutUnicode. Содержимое файда без юникода
     * @return Содержимое
     * @throws IOException
     */
    public synchronized String getContentWithoutUnicode() throws IOException {
        return getContent().replaceAll("[^\\x00-\\x79]", "");
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
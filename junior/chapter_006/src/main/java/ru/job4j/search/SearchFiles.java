package ru.job4j.search;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.regex.*;
/**
 * Class SearchFiles - Поиск файлов. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.3.1. Поиск файлов по критерию[#131907].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 09.05.2019
 * @version 1
 */
public class SearchFiles {
    private final File in;
    private final File out;
    private final String searchName;
    private final String searchType;
    /**
     * Method SearchFiles. Конструктор.
     * @param arguments Аргументы
     */
    public SearchFiles(Args arguments) {
        this.in = arguments.getDirectory();
        this.out = new File(String.join("", System.getProperty("java.io.tmpdir"), arguments.getOutput()));
        this.searchName = arguments.getSearchName();
        this.searchType = arguments.getSearchType();
    }
    /**
     * Method search. Поиск файлов.
     */
    public void search() throws IOException {
        Queue<File> fileQueue = new PriorityQueue<>();
        Collections.addAll(fileQueue, Objects.requireNonNull(this.in.listFiles((dir, name) -> checkFile(dir, name))));

        try (Writer fw = new OutputStreamWriter(new FileOutputStream(this.out), StandardCharsets.UTF_8)) {
            while (!fileQueue.isEmpty()) {
                File currentFile = fileQueue.remove();
                if (currentFile.isDirectory()) {
                    Collections.addAll(fileQueue, Objects.requireNonNull(currentFile.listFiles((dir, name) -> checkFile(dir, name))));
                } else {
                    fw.write(String.join("", currentFile.getName(), System.lineSeparator()));
                }
            }
        }
    }
    /**
     * Method checkFile. Фильтрация файлов.
     * @param dir Текущий каталог.
     * @param name Имя файла.
     * @return Удовлетворяет ли условиям фильтрации
     */
    public boolean checkFile(File dir, String name) {
        boolean res = false;
        if (new File(String.join(File.separator, dir.getPath(), name)).isDirectory()
                || (searchType.equals("m") && name.toLowerCase().endsWith(searchName))
                || (searchType.equals("f") && searchName.equals(name))
                || (searchType.equals("r") && Pattern.matches(searchName, name))) {
            res = true;
        }
        return res;
    }
}
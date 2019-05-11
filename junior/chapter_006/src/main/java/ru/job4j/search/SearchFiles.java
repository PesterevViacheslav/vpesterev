package ru.job4j.search;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
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
        Collections.addAll(fileQueue, this.in.listFiles());
        try (Writer fw = new OutputStreamWriter(new FileOutputStream(this.out), StandardCharsets.UTF_8)) {
            while (!fileQueue.isEmpty()) {
                File currentFile = fileQueue.remove();
                if (currentFile.isDirectory()) {
                    Collections.addAll(fileQueue, currentFile.listFiles());
                } else {
                    if (this.searchType.equals("m") && this.searchName.substring(this.searchName.indexOf(".") + 1, this.searchName.length()).equals(currentFile.getName().substring(currentFile.getName().indexOf(".") + 1, currentFile.getName().length()))) {
                        fw.write(String.join("", currentFile.getName(), System.lineSeparator()));
                    } else if (this.searchType.equals("f") && this.searchName.equals(currentFile.getName())) {
                        fw.write(String.join("", currentFile.getName(), System.lineSeparator()));
                    } else if (this.searchType.equals("r") && Pattern.matches(this.searchName, currentFile.getName())) {
                        fw.write(String.join("", currentFile.getName(), System.lineSeparator()));
                    }
                }
            }
        }
    }
}
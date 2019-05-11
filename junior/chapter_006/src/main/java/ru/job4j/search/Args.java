package ru.job4j.search;
import java.io.File;
/**
 * Class Args - Аргументы для метода поиска файлов. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.3.1. Поиск файлов по критерию[#131907].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 08.05.2019
 * @version 1
 */
public class Args {
    private String directory;
    private String searchName;
    private String searchType;
    private String output;
    /**
     * Method Args. Конструктор.
     *
     * @param directory Директория для поиска.
     * @param searchName Строка поиска
     * @param searchType Тип поиска: m - по маске, f - полное совпадение имени, r - регулярное выражение.
     * @param output Файл для вывода.
     */
    public Args(String directory, String searchName, String searchType, String output) {
        this.directory = directory;
        this.searchName = searchName;
        this.searchType = searchType;
        this.output = output;
    }
    /**
     * Method getSearchName. Получение поисковой строки.
     *
     * @return Строка для поиска.
     */
    public String getSearchName() {
        return this.searchName;
    }
    /**
     * Method directory. Получение директории поиска.
     *
     * @return Файл.
     */
    public File getDirectory() {
        return new File(this.directory);
    }
    /**
     * Method getSearchType. Получение типа поиска.
     *
     * @return Тип поиска.
     */
    public String getSearchType() {
        return this.searchType;
    }
    /**
     * Method getFileOutput. Получение признака записи в файл.
     *
     * @return Тип вывода.
     */
    public String getOutput() {
        return this.output;
    }
    @Override
    public String toString() {
        return String.join("", "Args{", "directory=", this.directory, ", searchName=", this.searchName, ", searchType=", this.searchType, ", fileOutput=", this.output, "}");
    }
}
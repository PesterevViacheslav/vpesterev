package ru.job4j.search;
import java.io.IOException;
/**
 * Class RunSearchFiles - Запуск jar поиска. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.3.1. Поиск файлов по критерию[#131907].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 09.05.2019
 * @version 1
 */
public class RunSearchFiles {
    public static void main(String[] args) throws IOException {
        String directory = "";
        String searchName = "";
        String searchType = "";
        String output = "";
        String prev = "";
        for (String s : args) {
            if (prev.equals("-d")) {
                directory = s;
            } else if (prev.equals("-n")) {
                searchName = s;
            } else if (prev.equals("-m")) {
                searchType = s;
            } else if (prev.equals("-o")) {
                output = s;
            } else {
                System.out.println("Not a valid parameter entered, see example below");
                System.out.println("java -jar find.jar -d C:\\Users\\VPESTEREV\\AppData\\Local\\Temp\\search_root -n *.txt -m m -o result.txt\n");
                System.out.println("-d input directory, -n search string, -m search type(m - mask, а - full name, r - regular expression), -o output file");
            }
            prev = s;
        }
        Args arguments = new Args(directory, searchName, searchType, output);
        SearchFiles searchFiles = new SearchFiles(arguments);
        searchFiles.search();
    }
}

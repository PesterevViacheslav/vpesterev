package ru.job4j.inout;
import java.io.File;
import java.util.*;
/**
 * Class FileSearch - Сканирование файловой системы. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.1.3. Сканирование файловой системы.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.03.2019
 * @version 1
 */
public class FileSearch {
    /**
     * Method files. Получение списка файлов с конкретным расширением.
     * @param parent Путь до каталога, с которого нужно осуществлять поиск.
     * @param exts Расширения файлов, которые мы ходим получить.
     * @return Список файлов с конкретным расширением.
     */
    public List<File> files(String parent, List<String> exts) {
        List<File> res = new ArrayList<>();
        File files = new File(parent);
        Queue<File> fileQueue = new PriorityQueue<>();
        Collections.addAll(fileQueue, files.listFiles());
        while (!fileQueue.isEmpty()) {
            File currentFile = fileQueue.remove();
            if (currentFile.isDirectory()) {
                Collections.addAll(fileQueue, currentFile.listFiles());
            } else {
                if (exts.contains(currentFile.getName().substring(currentFile.getName().indexOf(".") + 1, currentFile.getName().length()))) {
                    res.add(currentFile);
                }
            }
        }
        return res;
    }
}
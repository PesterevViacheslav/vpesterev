package ru.job4j.search;
import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class TestSearchFiles - Автотест архивирования проекта. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.3.1. Поиск файлов по критерию[#131907].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 22.03.2019
 * @version 1
 */
public class TestSearchFiles {
    private final String fileSeparator = System.getProperty("file.separator");
    private final String dir = System.getProperty("java.io.tmpdir");
    /**
     * Method deleteFile. Удаление дерева каталогов с файлами.
     * @param root Корневой каталог
     */
    public static void deleteFile(File root) {
        if (root.isDirectory()) {
            for (File sub : root.listFiles()) {
                deleteFile(sub);
            }
        }
        root.delete();
    }
    public List<String> getSearchResult() throws FileNotFoundException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(dir + this.fileSeparator + "result.txt"), StandardCharsets.UTF_8))
                .lines()
                .flatMap((p) -> Arrays.asList(p.split(" ")).stream())
                .collect(Collectors.toList());
    }
    /**
     * Тест поиска.
     */
/*
    @Test
    public void testFileSearch() throws Exception {
        System.out.println(dir);
        List<String> result = new ArrayList<>();
        File rootDir = new File(String.join(this.fileSeparator, dir, "search_root"));
        rootDir.mkdirs();
        File folder01 = new File(String.join(this.fileSeparator, rootDir.getPath(), "folder01"));
        folder01.mkdirs();
        File file011 = new File(String.join(this.fileSeparator, folder01.getPath(), "file011.txt"));
        file011.createNewFile();
        File file012 = new File(String.join(this.fileSeparator, folder01.getPath(), "file012.java"));
        file012.createNewFile();
        File folder013 = new File(String.join(this.fileSeparator, folder01.getPath(), "folder013"));
        folder013.mkdirs();
        File file021 = new File(String.join(this.fileSeparator, folder013.getPath(), "file021.txt"));
        file021.createNewFile();
        Args args = new Args(String.join(this.fileSeparator, dir, "search_root"), ".txt", "m", "result.txt");
        SearchFiles searchFiles = new SearchFiles(args);
        searchFiles.search();
        result.add("file011.txt");
        result.add("file021.txt");
        assertThat(Arrays.asList(result), is(Arrays.asList(getSearchResult())));
        result.remove(1);
        Args args2 = new Args(String.join("", dir, this.fileSeparator, "search_root"), "file011.txt", "f", "result.txt");
        SearchFiles searchFiles2 = new SearchFiles(args2);
        searchFiles2.search();
        assertThat(Arrays.asList(result), is(Arrays.asList(getSearchResult())));
        Args args3 = new Args(String.join("", dir, this.fileSeparator, "search_root"), "..le011.txt", "r", "result.txt");
        SearchFiles searchFiles3 = new SearchFiles(args3);
        searchFiles3.search();
        assertThat(Arrays.asList(result), is(Arrays.asList(getSearchResult())));
        deleteFile(rootDir);
    }
*/
}
package ru.job4j.inout;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class TestFileSearch - Сканирование файловой системы. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.1.3. Сканирование файловой системы.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.03.2019
 * @version 1
 */
public class TestFileSearch {
    private String fileSeparator = System.getProperty("file.separator");
    private FileSearch fileSearch = new FileSearch();
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
    /**
     * Тест Получение списка файлов с конкретным расширением.
     */
    @Test
    public void testGetFiles() throws IOException {
        List<File> result = new ArrayList<>();
        String dir = System.getProperty("java.io.tmpdir");
        File rootDir = new File(dir + this.fileSeparator + "search_root");
        rootDir.mkdirs();
        File folder01 = new File(rootDir + this.fileSeparator + "folder01");
        folder01.mkdirs();
        File file011 = new File(folder01 + this.fileSeparator + "file011.txt");
        file011.createNewFile();
        File file012 = new File(folder01 + this.fileSeparator + "file012.doc");
        file012.createNewFile();
        File folder02 = new File(rootDir + this.fileSeparator + "folder02");
        folder02.mkdirs();
        File file021 = new File(folder02 + this.fileSeparator + "file021.txt");
        file021.createNewFile();
        File file022 = new File(folder02 + this.fileSeparator + "file022.pdf");
        file022.createNewFile();
        File folder11 = new File(folder01, this.fileSeparator + "folder11");
        folder11.mkdirs();
        File file111 = new File(folder11 + this.fileSeparator + "file111.txt");
        file111.createNewFile();
        File file112 = new File(folder11 + this.fileSeparator + "file112.doc");
        file112.createNewFile();
        File folder12 = new File(folder02, this.fileSeparator + "folder12");
        folder12.mkdirs();
        File file121 = new File(folder12 + this.fileSeparator + "file121.jpeg");
        file121.createNewFile();
        File file122 = new File(folder12 + this.fileSeparator + "file122.doc");
        file122.createNewFile();
        File folder13 = new File(folder02, this.fileSeparator + "folder13");
        folder13.mkdirs();
        File file131 = new File(folder13 + this.fileSeparator + "file131.txt");
        file131.createNewFile();
        File file132 = new File(folder13 + this.fileSeparator + "file132.doc");
        file132.createNewFile();
        File folder21 = new File(folder12, this.fileSeparator + "folder21");
        folder21.mkdirs();
        File file211 = new File(folder21 + this.fileSeparator + "file211.bmp");
        file211.createNewFile();
        File file212 = new File(folder21 + this.fileSeparator + "file212.doc");
        file212.createNewFile();
        List<File> list;
        List<String> ext = new ArrayList<>();
        ext.add("txt");
        ext.add("doc");
        result.add(file011);
        result.add(file012);
        result.add(file111);
        result.add(file112);
        result.add(file021);
        result.add(file122);
        result.add(file212);
        result.add(file131);
        result.add(file132);
        assertThat(this.fileSearch.files(rootDir.getAbsolutePath(), ext).toArray(), is(result.toArray()));
        deleteFile(rootDir);
    }
}
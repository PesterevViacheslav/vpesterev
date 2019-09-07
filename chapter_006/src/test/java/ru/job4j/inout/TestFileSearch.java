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
        List<String> ext = new ArrayList<>();
        ext.add("txt");
        result.add(file011);
        assertThat(this.fileSearch.files(rootDir.getAbsolutePath(), ext).toArray(), is(result.toArray()));
        deleteFile(rootDir);
    }
}
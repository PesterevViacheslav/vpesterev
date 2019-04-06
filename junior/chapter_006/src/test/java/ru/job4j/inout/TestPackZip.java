package ru.job4j.inout;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class TestFileSearch - Автотест архивирования проекта. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.1.4. Архивировать проект.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 22.03.2019
 * @version 1
 */
public class TestPackZip {
    private String fileSeparator = System.getProperty("file.separator");
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
     * Тест архивирования.
     */
    @Test
    public void testZipDir() throws IOException {
        String dir = System.getProperty("java.io.tmpdir");
        System.out.println(dir);
        File rootDir = new File(dir + this.fileSeparator + "search_root");
        rootDir.mkdirs();
        File folder01 = new File(rootDir + this.fileSeparator + "folder01");
        folder01.mkdirs();
        File file011 = new File(folder01 + this.fileSeparator + "file011.txt");
        file011.createNewFile();
        File file012 = new File(folder01 + this.fileSeparator + "file012.java");
        file012.createNewFile();
        ArrayList<String> exclude = new ArrayList<>();
        exclude.add(".xml");
        exclude.add(".java");
        PackZip packZip = new PackZip();
        Args args = new Args(dir + this.fileSeparator + "search_root", exclude, dir);
        packZip.zipDir(args);
        File checkZip = new File(dir + this.fileSeparator + "search_root.zip");
        assertThat(checkZip.getName(), is("search_root.zip"));
        deleteFile(rootDir);
        deleteFile(checkZip);
    }
}
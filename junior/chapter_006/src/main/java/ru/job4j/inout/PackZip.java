package ru.job4j.inout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * Class PackZip - Архиватор. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.1.4. Архивировать проект.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 22.03.2019
 * @version 1
 */
public class PackZip {
    /**
     * Method zipDir. Метод архивации.
     * @param arguments Аргументы.
     */
    public void zipDir(Args arguments) {
        File in = arguments.directory();
        File out = arguments.output();
        ArrayList<String> exclude = arguments.exclude();
        try (FileOutputStream dest = new FileOutputStream(new File(out, in.getName() + ".zip"));
             ZipOutputStream zipOut = new ZipOutputStream(dest)) {
            zipDirTree(in, in, zipOut, exclude);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Method zipDirTree. Рекурсивный метод архивации.
     * @param root Корневой каталог.
     * @param current Текущий каталог.
     * @param out Выходной поток.
     * @param exclude Список исключаемых расширений.
     */
    private void zipDirTree(File root, File current, ZipOutputStream out, ArrayList<String> exclude) throws Exception {
        byte[] data = new byte[2048];
        File[] files = current.listFiles();
        boolean check = false;
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    for (File f : file.listFiles()) {
                        if (!f.isDirectory() && !exclude.contains(f.getName().substring(f.getName().indexOf(".")))) {
                            check = true;
                            break;
                        }
                    }
                    if (!check) {
                        out.putNextEntry(new ZipEntry(file.getAbsolutePath().replace(root.getAbsolutePath() + "\\", "") + "\\"));
                        out.closeEntry();
                    }
                    zipDirTree(root, file, out, exclude);
                } else {
                    try (FileInputStream fi = new FileInputStream(file);
                         BufferedInputStream origin = new BufferedInputStream(fi, 2048)) {
                        if (!exclude.contains(file.getName().substring(file.getName().indexOf(".")))) {
                            String name = file.getAbsolutePath().replace(root.getAbsolutePath() + "\\", "");
                            ZipEntry entry = new ZipEntry(name);
                            out.putNextEntry(entry);
                            int count;
                            while ((count = origin.read(data, 0, 2048)) != -1) {
                                out.write(data, 0, count);
                            }
                        }
                    } catch (java.lang.StringIndexOutOfBoundsException e) {
                        System.out.println(file.getName());
                    }
                }
            }
        }
    }
}
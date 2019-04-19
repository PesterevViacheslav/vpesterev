package ru.job4j.inout;
import java.io.*;
import java.util.*;
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
    private final File in;
    private final File out;
    private final ArrayList<String> exclude;
    /**
     * Method PackZip. Конструктор.
     * @param arguments Аргументы
     */
    public PackZip(Args arguments) {
        this.in = arguments.directory();
        this.out = arguments.output();
        this.exclude = arguments.exclude();
    }
    /**
     * Method pack. Метод архивации.
     * @param zipOut Архив
     * @param currentFile Текущий файл
     */
    private void pack(ZipOutputStream zipOut, File currentFile) throws IOException {
        byte[] data = new byte[2048];
        try (BufferedInputStream origin = new BufferedInputStream(new FileInputStream(currentFile), 2048)) {
            if (!this.exclude.contains(currentFile.getName().substring(currentFile.getName().indexOf(".")))) {
                zipOut.putNextEntry(new ZipEntry(currentFile.getAbsolutePath().replace(this.out.getAbsolutePath() + "\\", "")));
                int count;
                while ((count = origin.read(data, 0, 2048)) != -1) {
                    zipOut.write(data, 0, count);
                }
            }
        }
    }
    /**
     * Method zipProject. Метод архивации без рекурсии.
     */
    public void zipProject() throws IOException {
        Queue<File> fileTree = new PriorityQueue<>();
        Collections.addAll(fileTree, in.listFiles());
        try (FileOutputStream dest = new FileOutputStream(new File(this.out, this.in.getName() + ".zip"));
             ZipOutputStream zipOut = new ZipOutputStream(dest)) {
            while (!fileTree.isEmpty()) {
                boolean check = false;
                File currentFile = fileTree.remove();
                if (currentFile.isDirectory()) {
                    for (File f : currentFile.listFiles()) {
                        if (!f.isDirectory() && !this.exclude.contains(f.getName().substring(f.getName().indexOf(".")))) {
                            check = true;
                            break;
                        }
                    }
                    if (!check) {
                        zipOut.putNextEntry(new ZipEntry(currentFile.getAbsolutePath().replace(this.out.getAbsolutePath() + "\\", "") + "\\"));
                        zipOut.closeEntry();
                    }
                    Collections.addAll(fileTree, currentFile.listFiles());
                } else {
                    pack(zipOut, currentFile);
                }
            }
        }
    }
    /**
     * Method zipDir. Метод архивации.
     */
    public void zipDir() throws Exception {
        try (FileOutputStream dest = new FileOutputStream(new File(this.out, this.in.getName() + ".zip"));
             ZipOutputStream zipOut = new ZipOutputStream(dest)) {
            zipDirTree(this.in, this.in, zipOut, this.exclude);
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
                    pack(out, file);
                }
            }
        }
    }
}
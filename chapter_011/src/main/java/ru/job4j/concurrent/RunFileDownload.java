package ru.job4j.concurrent;
/**
 * Class RunFileDownload - Запуск закачки файла. Решение задач уровня Middle. Блок 1. Multithreading
 * 1. Threads. 4. Скачивание файла с ограничением.[#283069].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 28.05.2020
 * @version 1
 */
public class RunFileDownload {
    public static void main(String[] args) throws Exception {
        //java -jar download.jar -url https://raw.githubusercontent.com/peterarsentev/course_test/master/pom.xml -speed 1
        String url = "";
        int downloadSpeedKB = 1;
        String prev = "";
        for (String s : args) {
            if (prev.equals("-url")) {
                url = s;
            } else if (prev.equals("-speed")) {
                downloadSpeedKB = Integer.valueOf(s);
            }
            prev = s;
        }
        FileDownload fileDownload = new FileDownload(new Args(url, downloadSpeedKB));
        fileDownload.download();
    }
}
package ru.job4j.concurrent;
import java.io.*;
import java.net.URL;
/**
 * Class FileDownload - Закачка файла. Решение задач уровня Middle. Блок 1. Multithreading
 * 1. Threads. 4. Скачивание файла с ограничением.[#283069].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 28.05.2020
 * @version 1
 */
public class FileDownload {
    public static void main(String[] args) throws Exception {
        //java -jar download.jar -url https://raw.githubusercontent.com/peterarsentev/course_test/master/pom.xml -speed 1
        String url = "";
        int downloadSpeedKB = 1;
        long st, en;
        String prev = "";
        for (String s : args) {
            if (prev.equals("-url")) {
                url = s;
            } else if (prev.equals("-speed")) {
                downloadSpeedKB = Integer.valueOf(s);
            }
            prev = s;
        }
        String file = url;
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[downloadSpeedKB * 1024];
            float speedLimit = (float) downloadSpeedKB * 1024 / 1000;
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, downloadSpeedKB * 1024)) != -1) {
                st = System.nanoTime();
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                en = System.nanoTime();
                float currentSpeed = (float) bytesRead * 1000 / ((en - st));
                System.out.print("\rCurrent download speed " + (int) currentSpeed);
                if (currentSpeed > speedLimit) {
                    System.out.print(" pause " + (long) (currentSpeed * 100 / speedLimit) + "ms");
                    Thread.sleep((long) (currentSpeed * 100 / speedLimit));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" Download completed");
    }
}
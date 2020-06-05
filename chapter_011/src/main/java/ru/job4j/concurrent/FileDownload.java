package ru.job4j.concurrent;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private Args args;
    /**
     * Method FileDownload. Конструктор
     * @param args
     */
    public FileDownload(Args args) {
        this.args = args;
    }
    /**
     * Method download. Закачка файла
     * @throws InterruptedException
     */
    public void download() throws InterruptedException {
        long st;
        long en;
        try (BufferedInputStream in = new BufferedInputStream(new URL(this.args.getUrl()).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[this.args.getSpeed() * 1024];
            float speedLimit = (float) this.args.getSpeed() * 1024 / 1000;
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, this.args.getSpeed() * 1024)) != -1) {
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
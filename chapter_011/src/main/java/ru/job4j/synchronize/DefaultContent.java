package ru.job4j.synchronize;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Class DefaultContent - Контент по умолчанию. Решение задач уровня Middle. Части 011. Multithreading.
 * Синхронизация. 1. Visibility. Общий ресурс вне критической секции[#283084]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.07.2020
 * @version 1
 */
public class DefaultContent implements Content {
    @Override
    public String get(File file) throws IOException {
        String output = "";
        if (file != null) {
            output = new String(Files.readAllBytes(Paths.get(file.getPath())));
        }
        return output;
    }
}


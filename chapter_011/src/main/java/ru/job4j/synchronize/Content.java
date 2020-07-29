package ru.job4j.synchronize;
import java.io.File;
import java.io.IOException;
/**
 * Interface Content - Контент. Решение задач уровня Middle. Части 011. Multithreading.
 * Синхронизация. 1. Visibility. Общий ресурс вне критической секции[#283084]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.07.2020
 * @version 1
 */
public interface Content {
    String get(File file) throws IOException;
}

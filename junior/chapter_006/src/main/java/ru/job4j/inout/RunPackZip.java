package ru.job4j.inout;
import java.util.ArrayList;
/**
 * Class RunPackZip - Запуск jar архиватора. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.1.4. Архивировать проект.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 22.03.2019
 * @version 1
 */
public class RunPackZip {
    public static void main(String[] args) {
        String directory = "";
        ArrayList<String> exclude = new ArrayList<>();
        String output = "";
        String prev = "";
        for (String s : args) {
            if (prev.equals("-d")) {
                directory = s;
            } else if (prev.equals("-e")) {
                exclude.add(s);
            } else if (prev.equals("-o")) {
                output = s;
            }
            prev = s;
        }
        Args arguments = new Args(directory, exclude, output);
        PackZip pack = new PackZip();
        pack.zipDir(arguments);
        //java -jar pack.jar -d C:\projects\vpesterev\junior\chapter_006 -e .java -o C:\Temp
    }
}

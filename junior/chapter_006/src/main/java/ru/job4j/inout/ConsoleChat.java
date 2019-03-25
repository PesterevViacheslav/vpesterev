package ru.job4j.inout;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 * Class ConsoleChat - Консольный чат. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.1.5. Создать программу 'Консольный чат'.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.05.2018
 * @version 1
 */
public class ConsoleChat {
    public static void chat() throws IOException {
        String answer = "";
        boolean chatBotOn = true;
        String path = new File("").getAbsolutePath();
        FileWriter fw = new FileWriter(path + "\\junior\\chapter_006\\src\\main\\resources\\chat_log.txt");
        String[] text = Files.lines(Paths.get(path + "\\junior\\chapter_006\\src\\main\\resources\\for_chat.txt"), StandardCharsets.UTF_8)
                .flatMap((p) -> Arrays.asList(p.split(" ")).stream())
                .toArray(String[]::new);
        Scanner in = new Scanner(System.in);
        System.out.println("Для остановки бота напишите «стоп», для продолжения общения с ботом - «продолжить», для выхода из чата - «закончить»");
        while (!answer.equals("закончить")) {
            answer = in.nextLine();
            fw.write("ОПЕРАТОР -> " + answer + System.lineSeparator());
            if (answer.equals("стоп")) {
                chatBotOn = false;
            } else if (answer.equals("продолжить")) {
                chatBotOn = true;
            } else if (answer.equals("закончить")) {
                System.out.println("ЧАТ ЗАВЕРШЕН, ДО СВИДАНИЯ.");
                chatBotOn = false;
            }
            if (chatBotOn) {
                int rnd = new Random().nextInt(text.length);
                System.out.println(text[rnd]);
                fw.write("БОТ -> " + text[rnd] + System.lineSeparator());
            }
        }
        fw.close();
    }
    public static void main(String[] args) throws IOException {
        chat();
    }
}
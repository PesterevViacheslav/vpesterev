package ru.job4j.inout;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
/**
 * Class ConsoleChat - Консольный чат. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.1.5. Создать программу 'Консольный чат'.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.05.2019
 * @version 1
 */
public class ConsoleChat {
    private static final String STOP_BOT = "стоп";
    private static final String FINISH_BOT = "закончить";
    private static final String CONTINUE_BOT = "продолжить";
    private Scanner in;
    /**
     * Method ConsoleChat. Конструктор.
     */
    public ConsoleChat() {
        this.in = new Scanner(System.in);
    }
    /**
     * Method ConsoleChat. Конструктор.
     * @param in Входной поток
     */
    public ConsoleChat(Scanner in) {
        this.in = in;
    }
    /**
     * Method chat. Чат.
     */
    public void chat() throws IOException {
        String answer = "";
        boolean chatBotOn = true;
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream resource = loader.getResourceAsStream("for_chat.txt");
        String path = System.getProperty("java.io.tmpdir");
        List<String> text = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))
                .lines()
                .flatMap((p) -> Arrays.asList(p.split(" ")).stream())
                .collect(Collectors.toList());
        try (Writer fw = new OutputStreamWriter(new FileOutputStream(path + "chat_log.txt"), StandardCharsets.UTF_8)) {
            System.out.println("Для остановки бота напишите «стоп», для продолжения общения с ботом - «продолжить», для выхода из чата - «закончить»");
            while (!FINISH_BOT.equals(answer)) {
                answer = in.nextLine();
                fw.write("ОПЕРАТОР -> " + answer + System.lineSeparator());
                if (STOP_BOT.equals(answer)) {
                    chatBotOn = false;
                } else if (CONTINUE_BOT.equals(answer)) {
                    chatBotOn = true;
                } else if (FINISH_BOT.equals(answer)) {
                    System.out.println("ЧАТ ЗАВЕРШЕН, ДО СВИДАНИЯ.");
                    chatBotOn = false;
                }
                if (chatBotOn) {
                    int rnd = new Random().nextInt(text.size());
                    System.out.println(text.get(rnd));
                    fw.write("БОТ -> " + text.get(rnd) + System.lineSeparator());
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.chat();
    }
}
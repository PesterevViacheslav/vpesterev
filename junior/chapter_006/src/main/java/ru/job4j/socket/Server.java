package ru.job4j.socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Class Server - Сервер. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.2.1. Бот.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.05.2019
 * @version 1
 */
public class Server {
    public static final String START = "Привет, Оракл";
    public static final String EXIT = "стоп";
    private final Socket socket;
    /**
     * Method Server. Конструктор.
     * @param socket Сокет.
     */
    public Server(Socket socket)  {
        this.socket = socket;
    }
    /**
     * Method start. Запуск сервера.
     */
    public void start() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String ask;
        String[] answers = {"Вот это поворот...",
                            "Ваш вопрос очень важен для нас, ждите...",
                            "Снова ты...",
                            "Спасение утопающих дело рук самих утопающих...",
                            "Иди туда не знаю куда...",
                            "И это пройдет...",
                            "Все будет хорошо...",
                            "С тобой сила...",
                            "Приходи завтра...",
                            "Вопрос не понятен..."
                           };
        do {
            System.out.println("Ожидание команды...");
            ask = in.readLine();
            System.out.println(ask);
            if (START.equals(ask)) {
                out.println("Привет, собеседник. Я Оракл");
                out.println();
            } else if (!EXIT.equals(ask)) {
                int rnd = (int) (Math.random() * answers.length);
                out.println(answers[rnd]);
                out.println();
            } else if (EXIT.equals(ask)) {
                out.println(EXIT);
                out.println();
            }
            out.flush();
        } while (!EXIT.equals(ask));
    }
    /**
     * Method main.
     */
    public static void main(String[] args) throws IOException {
        try (final Socket socket = new ServerSocket(1111).accept()) {
            new Server(socket).start();
        }
    }
}
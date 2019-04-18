package ru.job4j.socket;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
/**
 * Class Client - Клиент. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.2.1. Бот.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.05.2019
 * @version 1
 */
public class Client {
    public static final String EXIT = "стоп";
    private final Socket socket;
    private Scanner input = new Scanner(System.in);
    /**
     * Method Client. Конструктор.
     * @param socket Сокет.
     */
    public Client(Socket socket) {
        this.socket = socket;
    }
    /**
     * Method start. Запуск клиента.
     */
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String str;
        System.out.println("Введите сообщение Ораклу:");
        do {
            str = this.input.nextLine();
            System.out.println(str);
            out.println(str);
            out.flush();
            str = reader.readLine();
            if (str != null && str.isEmpty()) {
                str = reader.readLine();
            }
            if (!EXIT.equals(str)) {
                System.out.println(String.format("Оракл прислал в ответ -> %s", str));
                System.out.println("Введите сообщение Ораклу:");
            }
        } while (!EXIT.equals(str));
    }
    /**
     * Method main.
     */
    public static void main(String[] args) throws IOException {
        try (final Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 1111)) {
            new Client(socket).start();
        }
    }
}
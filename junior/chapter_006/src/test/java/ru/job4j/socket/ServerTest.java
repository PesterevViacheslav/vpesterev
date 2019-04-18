package ru.job4j.socket;
import com.google.common.base.Joiner;
import org.junit.Test;
import java.io.*;
import java.net.Socket;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Class ServerTest - Тест сервера. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.2.1. Бот.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.05.2019
 * @version 1
 */
public class ServerTest {
    private static final String SEPARATOR = System.getProperty("line.separator");
    public void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        if (expected.equals("Не пусто")) {
            assertNotNull(out.toString());
        } else {
            assertThat(out.toString(), is(expected));
        }
        socket.close();
    }
    /**
     * Тест приветствия.
     */
    @Test
    public void whenSendHelloToServerThenReceiveHelloBack() throws IOException {
        testServer(Joiner.on(SEPARATOR).join("Привет, Оракл", "стоп"),
                   Joiner.on(SEPARATOR).join("Привет, собеседник. Я Оракл", "", "стоп", "", "")
                  );
    }
    /**
     * Тест рандомного ответа.
     */
    @Test
    public void whenSendPhraseToServerThenReceiveRandomBack() throws IOException {
        testServer(Joiner.on(SEPARATOR).join("Быть или не быть?", "стоп"), "Не пусто");
    }
}
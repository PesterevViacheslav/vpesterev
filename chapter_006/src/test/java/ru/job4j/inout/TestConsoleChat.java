package ru.job4j.inout;
import com.google.common.base.Joiner;
import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;
/**
 * Class TestConsoleChat - Консольный чат. Автотесты для решения задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.1.5. Создать программу 'Консольный чат'.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.05.2019
 * @version 1
 */
public class TestConsoleChat {
    private static final String SEPARATOR = System.getProperty("line.separator");
    @Test
    public void testConsoleChat() throws IOException {
        String[] in = new String[] {"Тест1", "Тест2", "Тест3", "стоп", "Тест4", "Тест5", "продолжить", "Тест6", "Тест7", "закончить"};
        String inList = Joiner.on(SEPARATOR).join(in);
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(inList.getBytes()))) {
            ConsoleChat consoleChat = new ConsoleChat(scanner);
            consoleChat.chat();
            File file = new File(String.join("", System.getProperty("java.io.tmpdir"), "chat_log.txt"));
            List<String> chatLog = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))
                    .lines()
                    .flatMap((p) -> Arrays.asList(p.split(SEPARATOR)).stream())
                    .collect(Collectors.toList());
            assertThat("ОПЕРАТОР -> Тест1", is(chatLog.get(0)));
            assertTrue(chatLog.get(1).contains("БОТ -> "));
            assertThat("ОПЕРАТОР -> Тест2", is(chatLog.get(2)));
            assertTrue(chatLog.get(3).contains("БОТ -> "));
            assertThat("ОПЕРАТОР -> Тест3", is(chatLog.get(4)));
            assertTrue(chatLog.get(5).contains("БОТ -> "));
            assertThat("ОПЕРАТОР -> стоп", is(chatLog.get(6)));
            assertThat("ОПЕРАТОР -> Тест4", is(chatLog.get(7)));
            assertThat("ОПЕРАТОР -> Тест5", is(chatLog.get(8)));
            assertThat("ОПЕРАТОР -> продолжить", is(chatLog.get(9)));
            assertTrue(chatLog.get(10).contains("БОТ -> "));
            assertThat("ОПЕРАТОР -> Тест6", is(chatLog.get(11)));
            assertTrue(chatLog.get(12).contains("БОТ -> "));
            assertThat("ОПЕРАТОР -> Тест7", is(chatLog.get(13)));
            assertTrue(chatLog.get(14).contains("БОТ -> "));
            assertThat("ОПЕРАТОР -> закончить", is(chatLog.get(15)));
        }
    }
}
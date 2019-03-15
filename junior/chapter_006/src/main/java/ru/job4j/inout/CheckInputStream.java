package ru.job4j.inout;
import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class CheckInputStream - Проверка байтового потока. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.1.1. Проверить байтовый поток.
 * 6.1.2. Удаление запрещенных слов.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 08.03.2019
 * @version 1
 */
public class CheckInputStream {
    /**
     * Method isEvenNumber. Проверка байтового потока на целые числа.
     * @param in Входной поток.
     * @return Только целые числа - true
     */
    public boolean isEvenNumber(InputStream in) throws IOException {
        boolean res = true;
        int check;
        int last = -1;
        while ((check = in.read()) >= 0) {
            last = check;
            if (!(Character.getType(check) == 9)) {
                res = false;
                break;
            }
        }
        if (!(last % 2 == 0)) {
            res = false;
        }
        return res;
    }
    /**
     * Method dropAbuses. Удаление запрещенных слов.
     * @param in Входной поток.
     * @param out Выходной поток.
     * @param abuse Запрещенные слова
     */
    void dropAbuses(Reader in, Writer out, String[] abuse) throws IOException {
        List<String> abuseList = new ArrayList();
        for (String s : abuse) {
            abuseList.add(s);
        }
        Stream.of(new BufferedReader(in).readLine())
                .flatMap((p) -> Arrays.asList(p.split(" ")).stream())
                .filter(s -> !abuseList.contains(s))
                .peek(s -> {
                    try {
                        out.write(s + " ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
                .forEach(String::new);
    }
}
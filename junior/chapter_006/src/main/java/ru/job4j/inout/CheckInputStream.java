package ru.job4j.inout;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
        int i;
        String str = "";
        while ((i = in.read()) >= 0) {
            if (Character.valueOf((char) i).equals(' ')) {
                if (!abuseList.contains(str)) {
                    out.write(str + " ");
                }
                str = "";
            } else {
                str += (char) i;
            }
        }
        if (!abuseList.contains(str)) {
            out.write(str);
        }
    }

}
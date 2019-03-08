package ru.job4j.inout;
import java.io.IOException;
import java.io.InputStream;
/**
 * Class CheckInputStream - Проверка байтового потока. Решение задач уровня Junior. Части 002. Ввод-Вывод.
 * 6.1.1. Проверить байтовый поток.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 08.03.2019
 * @version 1
 */
public class CheckInputStream {
    public boolean isEvenNumber(InputStream in) throws IOException {
        boolean res = true;
        int check;
        while ((check = in.read()) >= 0) {
            if (!(check % 2 == 0 && (Character.getType(check) == 9 || Character.getType(check) == 15))) {
                res = false;
                break;
            }
        }
        return res;
    }
}
package ru.job4j.search;
import java.util.Comparator;
/**
 * Class ListCompare - Решение задачи Части 003. Collections. Lite.
 * Задача 3.3. Компаратор для строк
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 28.07.2018
 * @version 1
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            result = Character.compare(o1.charAt(i), o2.charAt(i));
            if (result != 0) {
                break;
            }
        }
        return result;
    }
}

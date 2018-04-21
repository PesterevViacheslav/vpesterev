package ru.job4j.array;
import java.util.Arrays;
/**
 * Class ArrayDuplicate решение задачи Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 07.04.2018
 * @version 1
 */
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int ln = array.length;
        String tmp;
        for (int i = 0; i != ln; i++) {
            for (int j = i + 1; j != ln; j++) {
                if (array[i].equals(array[j])) {
                    ln--;
                    tmp = array[j];
                    array[j] = array[ln];
                    array[ln] = tmp;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, ln);
    }
}
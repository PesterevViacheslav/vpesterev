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
        int shift = 0;
        String tmp;
        int makeShift = 0;

        for (int i = 0; i < array.length; i++) {
            if (i > 0 && makeShift == 1) {
                i--;
            }
            makeShift = 0;
            for (int j = i + 1; j < array.length - shift; j++) {
                if (array[j].equals(array[i])) {
                    shift++;
                    tmp = array[j];
                    array[j] = array[array.length - shift];
                    array[array.length - shift] = tmp;
                    makeShift = 1;
                }
            }

        }
        return Arrays.copyOf(array, array.length - shift);
    }
}

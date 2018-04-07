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
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length - 1 - shift; j++) {
                if (array[j + 1].equals(array[i])) {
                    for (int k = j + 1; k < array.length - 1 - shift; k++) {
                        array[k] = array[k + 1];
                    }
                    shift++;
                }
            }
        }
        if (array.length > 1) {
            if (array[0].equals(array[1])) {
                array[0] = array[1];
                shift++;
            }
        }
        return Arrays.copyOf(array, array.length - shift);
    }
}

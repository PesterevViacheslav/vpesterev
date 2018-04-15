package ru.job4j.array;
/**
 * Class ArrayMerge решение задачи Части 001. Базовый синтаксис урок 7.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 14.04.2018
 * @version 1
 */
public class ArrayMerge {
    /**
     * Method merge. Слияние двух отсортированных массивов.
     * @param arrayA Первый отсортированный массив.
     * @param arrayB Второй отсортированный массив.
     * @return Результирующий отсортированный массив
     */
    public int[] merge(int[] arrayA, int[] arrayB) {
        int lengthA = arrayA.length;
        int lengthB = arrayB.length;
        int lengthC = lengthA + lengthB;
        int[] arrayC = new int[lengthC];
        int j = -1;
        int tmp;
        int tail;
        for (int i = 0; i < Math.max(lengthA, lengthB); i++) {
            if (i < Math.min(lengthA, lengthB)) {
                if (j >= 0) {
                    if (arrayC[j] < Math.min(arrayA[i], arrayB[i])) {
                        j++;
                        arrayC[j] = Math.min(arrayA[i], arrayB[i]);
                        j++;
                        arrayC[j] = Math.max(arrayA[i], arrayB[i]);
                    } else {
                        tmp = arrayC[j];
                        arrayC[j] = Math.min(arrayA[i], arrayB[i]);
                        j++;
                        arrayC[j] = tmp;
                        j++;
                        arrayC[j] = Math.max(arrayA[i], arrayB[i]);
                    }
                } else {
                    j++;
                    arrayC[j] = Math.min(arrayA[i], arrayB[i]);
                    j++;
                    arrayC[j] = Math.max(arrayA[i], arrayB[i]);
                }
            } else {
                if (lengthA < lengthB) {
                    tail = arrayB[i];
                } else {
                    tail = arrayA[i];
                }
                if (arrayC[j] < tail) {
                    j++;
                    arrayC[j] = tail;
                } else {
                    tmp = arrayC[j];
                    arrayC[j] = tail;
                    j++;
                    arrayC[j] = tmp;
                }
            }
        }
        return arrayC;
    }
}
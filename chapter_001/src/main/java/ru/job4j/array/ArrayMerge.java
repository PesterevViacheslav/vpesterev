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
        int idxC = 0;
        int shift = 0;
        int idxA = 0;
        int idxB = 0;
        for (int i = 0; i < lengthA; i++) {
            for (int j = shift; j < lengthB; j++) {
                if (arrayA[i] <= arrayB[j]) {
                    arrayC[idxC] = arrayA[i];
                    idxC++;
                    idxA = i;
                    break;
                } else {
                    arrayC[idxC] = arrayB[j];
                    idxC++;
                    shift++;
                    idxB = j;
                }
            }
        }
        if (idxA < lengthA - 1) {
            for (int i = idxA + 1; i < lengthA; i++) {
                arrayC[idxC] = arrayA[i];
                idxC++;
            }
        } else if (idxB < lengthB - 1) {
            for (int i = idxB + 1; i < lengthB; i++) {
                arrayC[idxC] = arrayB[i];
                idxC++;
            }
        }
        return arrayC;
    }
}
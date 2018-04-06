package ru.job4j.array;
/**
 * Class ArrayChar решение задачи Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.04.2018
 * @version 1
 */
public class ArrayChar {
    private char[] dataArray;

    /**
     * Method ArrayChar. Конструктор.
     * @param line Строка.
     */
    public ArrayChar(String line) {
        this.dataArray = line.toCharArray();
    }

    /**
     * Method startWith. Проверка начала массива с префикса.
     * @param prefix Префикс.
     * @return Наличие совпадения начала массива с префиксом.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] prefixArray = prefix.toCharArray();
        if (prefixArray.length <= this.dataArray.length) {
            for (int i = 0; i < prefixArray.length; i++) {
                if (prefixArray[i] != this.dataArray[i]) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}
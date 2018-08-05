package ru.job4j.parsing;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Class Parse - Парсинг. Решение задачи Части 002. ООП. Задача 8.3 Распарсить скобки.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.08.2018
 * @version 1
 */
public class Parse {
    HashMap<Character, Delimiter> availablePairs = new HashMap<>();
    /**
     * Method add. Добавление допустимого разделителя.
     * @param value Ключ.
     * @param delimiter Разделитель.
     */
    public void add(Character value, Delimiter delimiter) {
        this.availablePairs.put(value, delimiter);
    }
    /**
     * Method parsing. Разбор строки.
     * @param str Строка.
     * @return Результат разбора.
     */
    public ArrayList<ParsingResult> parsing(String str) throws WrongFormatException {
        ArrayList<Character> left = new ArrayList<>();
        ArrayList<Character> right = new ArrayList<>();
        Delimiter delimiter;
        Delimiter delimiterRight;
        ArrayList<ParsingResult> result = new ArrayList<>();
        int shift = 0;
        for (int i = 0; i < str.length(); i++) {
            delimiter = this.availablePairs.get(str.charAt(i));
            if (delimiter != null && str.length() > 1) {
                if (!delimiter.isLeft()) {
                    if (i + shift > str.length() || shift == 0) {
                        throw new WrongFormatException("Wrong format");
                    }
                    for (int j = i + shift - 1; j >= i; j--) {
                        delimiterRight = this.availablePairs.get(str.charAt(j));
                        if (delimiterRight != null) {
                            right.add(delimiterRight.getPairValue());
                        } else {
                            throw new WrongFormatException("Wrong format");
                        }
                    }
                    if (!left.equals(right)) {
                        throw new WrongFormatException("Wrong format");
                    }
                    i = i + shift - 1;
                    for (int k = 0; k < left.size(); k++) {
                        result.add(new ParsingResult(left.get(k).charValue(), this.availablePairs.get(left.get(k).charValue()).getPairValue(), i - left.size() * 2 + k + 1, i - k));
                    }
                    left.clear();
                    right.clear();
                    shift = 0;
                } else {
                    left.add(delimiter.getValue());
                    shift++;
                }
            } else {
                throw new WrongFormatException("Wrong format");
            }
        }
        return result;
    }
    @Override
    public String toString() {
        return "availablePairs=" + availablePairs;
    }
}
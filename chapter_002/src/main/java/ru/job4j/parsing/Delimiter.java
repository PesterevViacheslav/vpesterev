package ru.job4j.parsing;
import java.util.Objects;
/**
 * Class Delimiter - Разделитель. Решение задачи Части 002. ООП. Задача 8.3 Распарсить скобки.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.08.2018
 * @version 1
 */
public class Delimiter {
    private Character value;
    private boolean isLeft;
    private Character pairValue;
    /**
     * Method Delimiter. Конструктор.
     * @param value Символ.
     * @param isLeft Признак левого символа.
     * @param pairValue Противоположный символ.
     */
    public Delimiter(Character value, boolean isLeft, Character pairValue) {
        this.value = value;
        this.isLeft = isLeft;
        this.pairValue = pairValue;
    }
    /**
     * Method getValue. Получение значения символа.
     * @return Символ.
     */
    public Character getValue() {
        return value;
    }
    /**
     * Method getPairValue. Получение значения противоположного символа.
     * @return Символ.
     */
    public Character getPairValue() {
        return pairValue;
    }
    /**
     * Method isLeft. Получение признака левого символа.
     * @return Признак.
     */
    public boolean isLeft() {
        return isLeft;
    }
    @Override
    public String toString() {
        return "Delimiter{" + "value='" + value + '\'' + ", isLeft=" + isLeft + ", pairValue='" + pairValue + '\'' + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Delimiter delimiter = (Delimiter) o;
        return isLeft == delimiter.isLeft && Objects.equals(value, delimiter.value) && Objects.equals(pairValue, delimiter.pairValue);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value, isLeft, pairValue);
    }
}
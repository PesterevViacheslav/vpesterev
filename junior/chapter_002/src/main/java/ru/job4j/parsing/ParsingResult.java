package ru.job4j.parsing;
import java.util.Objects;
/**
 * Class ParsingResult - Результат парсинга. Решение задачи Части 002. ООП. Задача 8.3 Распарсить скобки.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.08.2018
 * @version 1
 */
public class ParsingResult {
    private Character leftSymbol;
    private Character rightSymbol;
    private int leftSymbolPosition;
    private int rightSymbolPosition;
    /**
     * Method ParsingResult. Конструктор.
     * @param leftSymbol Левый символ.
     * @param rightSymbol Правый символ.
     * @param leftSymbolPosition Левый символ - позиция.
     * @param rightSymbolPosition Правый символ - позиция.
     */
    public ParsingResult(Character leftSymbol, Character rightSymbol, int leftSymbolPosition, int rightSymbolPosition) {
        this.leftSymbol = leftSymbol;
        this.rightSymbol = rightSymbol;
        this.leftSymbolPosition = leftSymbolPosition;
        this.rightSymbolPosition = rightSymbolPosition;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParsingResult that = (ParsingResult) o;
        return leftSymbolPosition == that.leftSymbolPosition && rightSymbolPosition == that.rightSymbolPosition && Objects.equals(leftSymbol, that.leftSymbol) && Objects.equals(rightSymbol, that.rightSymbol);
    }
    @Override
    public int hashCode() {
        return Objects.hash(leftSymbol, rightSymbol, leftSymbolPosition, rightSymbolPosition);
    }
    @Override
    public String toString() {
        return "ParsingResult{" + "leftSymbol=" + leftSymbol + ", rightSymbol=" + rightSymbol + ", leftSymbolPosition=" + leftSymbolPosition + ", rightSymbolPosition=" + rightSymbolPosition + '}';
    }
}
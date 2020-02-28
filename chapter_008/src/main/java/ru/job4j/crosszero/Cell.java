package ru.job4j.crosszero;
/**
 * Class Cell - Ячейка доски. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.02.2019
 * @version 1
 */
public class Cell {
    private int x;
    private int y;
    private Symbol symbol;
    /**
     * Method Cell. Конструктор
     * @param x Координата X
     * @param y Координата Y
     * @param symbol Символ
     */
    public Cell(int x, int y, Symbol symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }
    /**
     * Method getSymbol. Получение значения символа ячейки
     * @return Значение
     */
    public Symbol getSymbol() {
        return symbol;
    }
    /**
     * Method setSymbol. Установка значения символа ячейки
     * @param symbol
     */
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    @Override
    public String toString() {
        return symbol.toString();
    }
}

package ru.job4j.crosszero;
/**
 * Class Board - Доска. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.02.2019
 * @version 1
 */
public class Board {
    private int size;
    private Cell[][] cells;
    /**
     * Method Board. Конструктор
     * @param size
     */
    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];
    }
    /**
     * Method init. Инициализация доски
     */
    public void init() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells[i][j] = new Cell(i, j, new Symbol("_"));
            }
        }
    }
    /**
     * Method clear. Очистка доски
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells[i][j].getSymbol().setType("_");
            }
        }
    }
    /**
     * Method print. Печать доски
     */
    public void print() {
        StringBuilder result = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                result.append(this.cells[i][j] + " ");
            }
            result.append(ln);
        }
        System.out.println(result.toString());
    }
    /**
     * Method setSymbol. Установка значения символа
     * @param x Координата X
     * @param y Координата Y
     * @param symbol Символ
     * @return Успешность установки
     */
    public boolean setSymbol(int x, int y, Symbol symbol) {
        boolean res = false;
        if (!(x < 0 || x >= this.size || y < 0 || y >= this.size || !"_".equals(this.cells[x][y].getSymbol().getType()))) {
            this.cells[x][y].setSymbol(symbol);
            res = true;
        }
        return res;
    }
    /**
     * Method checkGameOver. Проверка окончания игры
     * @return Признак окончания
     */
    public int checkGameOver() {
        int res = -1;
        boolean resCheck = false;
        boolean freeExists = false;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size - 1; j++) {
                if ("_".equals(this.cells[i][j].getSymbol().getType())) {
                    freeExists = true;
                    break;
                }
            }
        }
        for (int i = 0; i < this.size; i++) {
            int eqRow = 1;
            int eqCol = 1;
            int eqDiagLeft = 1;
            int eqDiagRight = 1;
            for (int j = 0; j < this.size - 1; j++) {
                if (this.cells[i][j].getSymbol().getType().equals(this.cells[i][j + 1].getSymbol().getType())) {
                    if (!("_".equals(this.cells[i][j].getSymbol().getType()) || "_".equals(this.cells[i][j + 1].getSymbol().getType()))) {
                        eqRow++;
                    }
                } else if (this.cells[j][i].getSymbol().getType().equals(this.cells[j + 1][i].getSymbol().getType())) {
                    if (!("_".equals(this.cells[j][i].getSymbol().getType()) || "_".equals(this.cells[j + 1][i].getSymbol().getType()))) {
                        eqCol++;
                    }
                } else if (this.cells[j][j].getSymbol().getType().equals(this.cells[j + 1][j + 1].getSymbol().getType())) {
                    if (!("_".equals(this.cells[j][j].getSymbol().getType()) || "_".equals(this.cells[j + 1][j + 1].getSymbol().getType()))) {
                        eqDiagLeft++;
                    }
                } else if (this.cells[j][this.size - 1 - j].getSymbol().getType().equals(this.cells[j + 1][this.size - 2 - j].getSymbol().getType())) {
                    if (!("_".equals(this.cells[j][this.size - 1 - j].getSymbol().getType()) || "_".equals(this.cells[j + 1][this.size - 2 - j].getSymbol().getType()))) {
                        eqDiagRight++;
                    }
                }
            }
            if (eqRow == this.size || eqCol == this.size || eqDiagLeft == this.size || eqDiagRight == this.size) {
                resCheck = true;
                break;
            }
            if (resCheck) {
                break;
            }
        }
        if (!freeExists) {
            res = 0;
        } else if (resCheck) {
            res = 1;
        }
        return res;
    }
}
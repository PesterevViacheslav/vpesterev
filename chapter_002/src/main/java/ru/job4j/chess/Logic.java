package ru.job4j.chess;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * Class Logic - Логика реализации шахматной доски. Решение задачи Части 002. ООП. Задача 8.1 Каркас шахматной доски.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.06.2018
 * @version 1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;
    /**
     * Method add. Добавление фигуры.
     * @param figure Фигура.
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }
    /**
     * Method move. Ход фигуры.
     * @param source Исходная клетка.
     * @param dest Конечная клетка.
     * @return Возможен ли ход
     */
    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (dest != null && index != -1 && this.findBy(dest) == -1) {
            try {
                Cell[] steps = this.figures[index].way(source, dest);
                for (int i = 0; i < steps.length; i++) {
                    if (steps[i] != null) {
                        if (!steps[i].equals(source) && this.findBy(steps[i]) != -1) {
                            throw new OccupiedWayException("OccupiedWayException");
                        }
                    }
                    if (steps[i] != null && steps[i].equals(dest)) {
                        rst = true;
                        this.figures[index] = this.figures[index].copy(dest);
                        break;
                    }
                }
            } catch (ImpossibleMoveException | OccupiedWayException ime) {
                rst = false;
            }
        }
        return rst;
    }
    /**
     * Method clean. Очистка массива фигур.
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }
    /**
     * Method findBy. Поиск позиции клетки в массиве.
     * @param cell Клетка.
     * @return Индекс
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
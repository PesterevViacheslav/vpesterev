package ru.job4j.chess.figures.white;
import ru.job4j.chess.Chess;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.*;
/**
 * Class RookWhite - Фигура - белая ладья. Решение задачи Части 002. ООП. Задача 8.1 Каркас шахматной доски.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.06.2018
 * @version 1
 */
public class RookWhite implements Figure {
    private final Cell position;

    public RookWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps;
        if (source.y == dest.y || source.x == dest.x) {
            steps = Chess.fillWay(source, dest);
        } else {
            throw new ImpossibleMoveException("Raise ImpossibleMoveException");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}

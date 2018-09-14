package ru.job4j.chess.figures.white;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.*;
/**
 * Class PawnWhite - Фигура - белая пешка. Решение задачи Части 002. ООП. Задача 8.1 Каркас шахматной доски.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.06.2018
 * @version 1
 */
public class PawnWhite implements Figure {
    private final Cell position;

    public PawnWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps;
        if (((source.y == 1 && (source.y == dest.y - 1 || source.y == dest.y - 2)) || (source.y > 1 && (source.y == dest.y - 1))) && source.x == dest.x && source.y < dest.y) {
            steps = source.fillWay(dest);
        } else {
            throw new ImpossibleMoveException("Raise ImpossibleMoveException");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
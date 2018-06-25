package ru.job4j.chess.figures.black;
import ru.job4j.chess.*;
import ru.job4j.chess.figures.*;
/**
 * Class PawnBlack - Фигура - черная пешка. Решение задачи Части 002. ООП. Задача 8.1 Каркас шахматной доски.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.06.2018
 * @version 1
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps;
        if (((source.y == 6 && (source.y == dest.y + 1 || source.y == dest.y + 2)) || (source.y < 6 && (source.y == dest.y + 1))) && source.x == dest.x && source.y > dest.y) {
            steps = Chess.fillWay(source, dest);
        } else {
            throw new ImpossibleMoveException("Raise ImpossibleMoveException");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}

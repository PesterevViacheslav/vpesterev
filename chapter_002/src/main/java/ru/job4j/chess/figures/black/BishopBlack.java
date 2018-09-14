package ru.job4j.chess.figures.black;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.figures.*;
/**
 * Class BishopBlack - Фигура - черный слон. Решение задачи Части 002. ООП. Задача 8.1 Каркас шахматной доски.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.06.2018
 * @version 1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps;
        if (Math.abs(source.y - dest.y) == Math.abs(source.x - dest.x)) {
            steps = source.fillWay(dest);
        } else {
            throw new ImpossibleMoveException("Raise ImpossibleMoveException");
        }
        return steps;
    }
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
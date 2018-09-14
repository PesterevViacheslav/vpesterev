package ru.job4j.chess.figures;
import ru.job4j.chess.ImpossibleMoveException;
/**
 * Interface Figure - Фигура шахматной доски. Решение задачи Части 002. ООП. Задача 8.1 Каркас шахматной доски.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.06.2018
 * @version 1
 */
public interface Figure {
    /**
     * Method position. Позиция на доске.
     * @return Клетка.
     */
    Cell position();
    /**
     * Method way. Путь фигуры.
     * @param source Исходная клетка.
     * @param dest Конечная клетка.
     */
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;
    /**
     * Method icon. Путь к картинке.
     * @return Путь.
     */
    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }
    /**
     * Method copy. Копирование фигуры.
     * @return Фигура.
     */
    Figure copy(Cell dest);
}
package ru.job4j.chess;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.*;
import ru.job4j.chess.figures.white.*;
/**
 * Пекет для решение задачи Части 002. ООП. Задача 8.1 Каркас шахматной доски.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.06.2018
 * @version 1
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }
    /**
     * Попытка перейти на доступную для перехода клетку
     */
    public void testMoveOnAvailableCell() {
        Logic board = new Logic();
        //Пешка
        board.add(new PawnBlack(Cell.E7));
        board.add(new PawnWhite(Cell.B3));
        assertTrue(board.move(Cell.E7, Cell.E5));
        assertTrue(board.move(Cell.B3, Cell.B4));
        //Ладья
        board.add(new RookBlack(Cell.A7));
        assertTrue(board.move(Cell.A7, Cell.G7));
        assertTrue(board.move(Cell.G7, Cell.G8));
        //Ферзь
        board.add(new QueenWhite(Cell.A1));
        assertTrue(board.move(Cell.A1, Cell.A7));
        assertTrue(board.move(Cell.A7, Cell.C5));
        //Король
        board.add(new KingWhite(Cell.G1));
        assertTrue(board.move(Cell.G1, Cell.G2));
        assertTrue(board.move(Cell.G2, Cell.H1));
        //Конь
        board.add(new KnightBlack(Cell.B1));
        assertTrue(board.move(Cell.B1, Cell.A3));
        assertTrue(board.move(Cell.A3, Cell.C2));
        //Слон
        board.add(new BishopBlack(Cell.C1));
        //assertTrue(board.move(Cell.C1, Cell.A3));
    }
    /**
     * Попытка перейти на занятую клетку
     */
    public void testMoveOnReservedCell() {
        Logic board = new Logic();
        //Пешка
        board.add(new PawnBlack(Cell.E7));
        board.move(Cell.E7, Cell.E5);
        board.move(Cell.E5, Cell.E4);
        board.add(new PawnWhite(Cell.E2));
        assertFalse(board.move(Cell.E2, Cell.E4));
        //Ладья
        board.add(new RookBlack(Cell.E7));
        assertFalse(board.move(Cell.E7, Cell.E4));
        //Ферзь
        board.add(new QueenWhite(Cell.D3));
        assertFalse(board.move(Cell.D3, Cell.E4));
        //Король
        board.add(new KingWhite(Cell.E3));
        assertFalse(board.move(Cell.E3, Cell.E4));
        //Конь
        board.add(new KnightBlack(Cell.D2));
        assertFalse(board.move(Cell.D2, Cell.E4));
        //Слон
        board.add(new BishopBlack(Cell.F3));
        assertFalse(board.move(Cell.F3, Cell.E4));
    }
    /**
     * Попытка перескочить через занятую клетку
     */
    public void testMoveOverReservedCell() {
        Logic board = new Logic();
        //Пешка
        board.add(new PawnBlack(Cell.E7));
        board.move(Cell.E7, Cell.E5);
        board.move(Cell.E5, Cell.E4);
        board.move(Cell.E4, Cell.E3);
        board.add(new PawnWhite(Cell.E2));
        assertFalse(board.move(Cell.E2, Cell.E4));
        //Ладья
        board.add(new RookBlack(Cell.E7));
        assertFalse(board.move(Cell.E7, Cell.E1));
        //Ферзь
        board.add(new QueenWhite(Cell.E6));
        assertFalse(board.move(Cell.E6, Cell.E1));
        //Конь
        board.add(new KnightBlack(Cell.D3));
        assertTrue(board.move(Cell.D3, Cell.F4));
        //Слон
        board.add(new BishopBlack(Cell.F3));
        assertFalse(board.move(Cell.F3, Cell.D5));
    }
    /**
     * Попытка сходить в запрещенном направлении
     */
    public void testMoveToRestrictedWay() {
        Logic board = new Logic();
        //Пешка
        board.add(new PawnBlack(Cell.E7));
        assertFalse(board.move(Cell.E7, Cell.F7));
        assertFalse(board.move(Cell.E7, Cell.E8));
        //Ладья
        board.add(new RookBlack(Cell.E7));
        assertFalse(board.move(Cell.E7, Cell.G5));
        //Ферзь
        board.add(new QueenWhite(Cell.D1));
        assertFalse(board.move(Cell.D1, Cell.F2));
        //Король
        board.add(new KingWhite(Cell.F2));
        assertFalse(board.move(Cell.F2, Cell.H2));
        //Конь
        board.add(new KnightBlack(Cell.H3));
        assertFalse(board.move(Cell.H3, Cell.H6));
        //Слон
        board.add(new BishopBlack(Cell.C6));
        assertFalse(board.move(Cell.C6, Cell.C5));
    }
}
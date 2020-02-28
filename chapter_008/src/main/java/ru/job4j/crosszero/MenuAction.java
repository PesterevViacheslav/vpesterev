package ru.job4j.crosszero;
import java.util.Scanner;
/**
 * Interface MenuAction - Действия меню. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.02.2019
 * @version 1
 */
public interface MenuAction {
    /**
     * Method key Пункт меню
     * @return Ключ к пункту меню
     */
    String key();
    /**
     * Method execute Действие пункта меню
     * @param input Входной поток
     * @param board Доска
     */
    boolean execute(Scanner input, Board board, Symbol symbol);
}

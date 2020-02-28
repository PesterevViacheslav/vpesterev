package ru.job4j.crosszero;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Class DisplayMenu - Дерево меню. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.02.2019
 * @version 1
 */
public class DisplayMenu {
    private Board board;
    private Scanner in;
    protected HashMap<String, MenuAction> actions = new HashMap<>();
    /**
     * Method DisplayMenu Конструктор
     * @param in Входной поток
     * @param board Дерево меню
     */
    public DisplayMenu(Scanner in, Board board) {
        this.in = in;
        this.board = board;
    }
    /**
     * Method showMenu Отображение меню
     */

    public void showMenu() {
        System.out.println("MENU");
        System.out.println("Enter S for next step, EXIT for game interruption");
        System.out.println("---------");
    }
    /**
     * Method select. Выбор операции.
     * @param key Код операции.
     */
    public boolean select(String key, Symbol symbol) {
        boolean res = false;
        if (this.actions.containsKey(key.toLowerCase())) {
            res = this.actions.get(key.toLowerCase()).execute(this.in, this.board, symbol);
        } else {
            System.out.println("Wrong menu key");
        }
        return res;
    }
    /**
     * Method addActions. Добавление действия.
     */
    public void addActions(MenuAction menuAction) {
        this.actions.put(menuAction.key(), menuAction);
    }
}
package ru.job4j.isp;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Class DisplayMenu - Дерево меню. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.01.2019
 * @version 1
 */
public class DisplayMenu {
    private Tree tree;
    private Scanner in;
    protected HashMap<String, MenuAction> actions = new HashMap<>();
    /**
     * Method DisplayMenu Конструктор
     * @param in Входной поток
     * @param tree Дерево меню
     */
    public DisplayMenu(Scanner in, Tree tree) {
        this.in = in;
        this.tree = tree;
    }
    /**
     * Method showMenu Отображение меню
     */
    public void showMenu() {
        System.out.println("TREE MENU");
        System.out.println("---------");
        String separator = "";
        for (Node node : this.tree.getTree().values()) {
            for (int i = 1; i < node.getLevel(); i++) {
                separator += "    ";
            }
            System.out.println(separator + node.getTitle());
            separator = "";
        }
        System.out.println("---------");
    }
    /**
     * Method select. Выбор операции.
     * @param key Код операции.
     */
    public void select(String key) {
        if (this.actions.containsKey(key)) {
            this.actions.get(key).execute(this.in, this.tree);
        } else {
            System.out.println("Wrong menu key");
        }
    }
    /**
     * Method addActions. Добавление действия.
     */
    public void addActions(MenuAction menuAction) {
        this.actions.put(menuAction.key(), menuAction);
    }
}
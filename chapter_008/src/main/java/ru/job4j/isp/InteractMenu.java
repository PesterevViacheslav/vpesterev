package ru.job4j.isp;
import java.util.Scanner;
/**
 * Class InteractMenu - Взаимодействие с меню. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.01.2019
 * @version 1
 */
public class InteractMenu {
    private Tree tree;
    private Scanner in;
    private boolean work = true;
    /**
     * Method InteractMenu. Конструктор.
     * @param tree
     */
    public InteractMenu(Tree tree) {
        this.tree = tree;
        this.in = new Scanner(System.in);
    }
    /**
     * Method InteractMenu. Конструктор.
     * @param tree Дерево меню
     * @param in Входной поток
     */
    public InteractMenu(Tree tree, Scanner in) {
        this.tree = tree;
        this.in = in;
    }
    /**
     * Method getIn. Получение потока ввода/вывода
     * @return Поток ввода/вывода.
     */
    public Scanner getIn() {
        return in;
    }
    /**
     * Method stop. Прекращение работы.
     */
    public void stop() {
        this.work = false;
    }
    /**
     * Method start. Запуск интерфейса калькулятора
     * @param menu Меню
     */
    public void start(DisplayMenu menu) {
        String key;
        menu.showMenu();
        do {
            System.out.println("Enter operation:");
            key = in.next();
            menu.select(key);
        } while (this.work);
    }
    /**
     * Method main. Интерактив с меню
     */
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(new Node("1", "", "Root", 1));
        tree.add(new Node("1.1", "1", "1.1 Level 2", 2));
        tree.add(new Node("1.1.1", "1.1", "1.1.1 Press 1", 3));
        tree.add(new Node("1.2", "1", "1.2 Level 2", 2));
        InteractMenu interactMenu = new InteractMenu(tree);
        DisplayMenu menu = new DisplayMenu(interactMenu.getIn(), tree);
        menu.addActions(new MenuAction() {
            @Override
            public String key() {
                return "1";
            }
            @Override
            public void execute(Scanner in, Tree tree) {
                System.out.println("Call Action 1");
            }
        });
        menu.addActions(new Exit("exit", interactMenu));
        interactMenu.start(menu);
    }
    /**
     * Class Exit - Выход из программы.
     */
    private static class Exit extends TreeUserAction {
        private final InteractMenu interactMenu;
        /**
         * Method Exit. Конструктор.
         * @param key Значение ключа меню.
         * @param interactMenu
         */
        public Exit(String key, InteractMenu interactMenu) {
            super(key);
            this.interactMenu = interactMenu;
        }
        /**
         * Method execute. Выполнение действия.
         * @param in Ввод-вывод.
         * @param tree Меню.
         */
        @Override
        public void execute(Scanner in, Tree tree) {
            System.out.println("EXIT");
            this.interactMenu.stop();
        }
    }
}
package ru.job4j.crosszero;
import java.util.Scanner;
/**
 * Class CrossZero - Крестики-нолики. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.02.2019
 * @version 1
 */
public class CrossZero {
    private Board board;
    private Scanner in;
    private boolean work = true;
    private int winCount;

    public CrossZero(Board board, int winCount) {
        this.board = board;
        this.in = new Scanner(System.in);
        this.winCount = winCount;
    }
    public CrossZero(Board board, Scanner in, int winCount) {
        this.board = board;
        this.in = in;
        this.winCount = winCount;
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
    public String start(DisplayMenu menu) {
        String res = "";
        String key;
        int userWinCount = 0;
        int compWinCount = 0;
        int gameOver;
        Symbol prevSymbol = new Symbol("X");
        menu.showMenu();
        do {
            Symbol symbol = new Symbol("X");
            if ("O".equals(prevSymbol.getType())) {
                symbol.setType("X");
            } else {
                symbol.setType("O");
            }
            this.board.print();
            System.out.println(symbol.getType() + " turn, print S for next step");
            key = in.next();
            if (menu.select(key.toLowerCase(), symbol)) {
                prevSymbol.setType(symbol.getType());
            } else {
                System.out.println("wrong cell, try again...");
            }
            gameOver = this.board.checkGameOver();
            if (gameOver >= 0) {
                System.out.println("Game over!");
                board.print();
                if (gameOver > 0) {
                    res = symbol.getType();
                    if ("O".equals(res)) {
                        userWinCount++;
                    } else if ("X".equals(res)) {
                        compWinCount++;
                    }
                }
                prevSymbol.setType("X");
                board.clear();
                if (userWinCount == this.winCount || compWinCount == this.winCount) {
                    break;
                }
            }
        } while (this.work);
        return res;
    }
    /**
     * Method main. Интерактив с меню
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter board size:");
        int size = in.nextInt();
        Board board = new Board(size);
        board.init();
        CrossZero crossZero = new CrossZero(board, 2);
        DisplayMenu menu = new DisplayMenu(crossZero.getIn(), board);
        menu.addActions(new MenuAction() {
            @Override
            public String key() {
                return "s";
            }
            @Override
            public boolean execute(Scanner in, Board board, Symbol symbol) {
                System.out.println("Enter cell coordinate X:");
                int x = in.nextInt();
                System.out.println("Enter cell coordinate Y:");
                int y = in.nextInt();
                return board.setSymbol(x, y, symbol);
            }
        });
        menu.addActions(new Exit("exit", crossZero));
        crossZero.start(menu);
    }
    /**
     * Class Exit - Выход из программы.
     */
    private static class Exit extends UserAction {
        private final CrossZero crossZero;
        /**
         * Method Exit. Конструктор.
         * @param key Значение ключа меню.
         * @param crossZero
         */
        public Exit(String key, CrossZero crossZero) {
            super(key);
            this.crossZero = crossZero;
        }
        /**
         * Method execute. Выполнение действия.
         * @param in Ввод-вывод.
         * @param board Меню.
         */
        @Override
        public boolean execute(Scanner in, Board board, Symbol symbol) {
            System.out.println("EXIT");
            this.crossZero.stop();
            return true;
        }
    }
}
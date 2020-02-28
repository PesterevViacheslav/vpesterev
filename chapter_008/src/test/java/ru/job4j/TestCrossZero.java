package ru.job4j;
import com.google.common.base.Joiner;
import org.junit.Test;
import ru.job4j.crosszero.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
/**
 * Class TestCrossZero - Автотесты для игру Крестики-нолики. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.02.2020
 * @version 1
 */
public class TestCrossZero {
    private static final String SEPARATOR = System.getProperty("line.separator");
    /**
     * Тест крестиков-ноликов - нолики выигрывают
     */
    @Test
    public void testCrossZeroWin() {
        String[] in = new String[] {"s", "1", "1", "s", "0", "0", "s", "0", "1"};
        String inList = Joiner.on(SEPARATOR).join(in);
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(inList.getBytes()))) {
            Board board = new Board(2);
            board.init();
            CrossZero crossZero = new CrossZero(board, scanner, 1);
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
            assertThat(crossZero.start(menu), is("O"));
        }
    }
    /**
     * Тест крестиков-ноликов - ничья
     */
    @Test
    public void testCrossZeroNobodyWin() {
        String[] in = new String[] {"s", "0", "0", "s", "0", "2", "s", "0", "1", "s", "1", "0", "s", "1", "2", "s", "1", "1", "s", "2", "0", "s", "2", "2", "s", "2", "1", "exit"};
        String inList = Joiner.on(SEPARATOR).join(in);
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(inList.getBytes()))) {
            Board board = new Board(3);
            board.init();
            CrossZero crossZero = new CrossZero(board, scanner, 1);
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
            assertThat(crossZero.start(menu), is(""));
        }
    }
    /**
     * Тест крестиков-ноликов - нолики выигрывают
     */
    @Test
    public void testCrossZeroWinFiveGames() {
        String[] in = new String[] {"s", "1", "1", "s", "0", "0", "s", "0", "1",
                                    "s", "1", "1", "s", "0", "0", "s", "0", "1",
                                    "s", "1", "1", "s", "0", "0", "s", "0", "1",
                                    "s", "1", "1", "s", "0", "0", "s", "0", "1",
                                    "s", "1", "1", "s", "0", "0", "s", "0", "1"};
        String inList = Joiner.on(SEPARATOR).join(in);
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(inList.getBytes()))) {
            Board board = new Board(2);
            board.init();
            CrossZero crossZero = new CrossZero(board, scanner, 5);
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
            assertThat(crossZero.start(menu), is("O"));
        }
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
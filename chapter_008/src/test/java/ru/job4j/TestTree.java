package ru.job4j;
import com.google.common.base.Joiner;
import org.junit.Test;
import ru.job4j.isp.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TestTree - Автотесты к дереву меню. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.01.2019
 * @version 1
 */
public class TestTree {
    private static final String SEPARATOR = System.getProperty("line.separator");
    /**
     * Тест дерева меню.
     */
    @Test
    public void testTree() {
        String[] in = new String[] {"1", "exit"};
        String inList = Joiner.on(SEPARATOR).join(in);
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(inList.getBytes()))) {
            Tree tree = new Tree();
            tree.add(new Node("1", "", "Root", 1));
            tree.add(new Node("1.1", "1", "1.1 Level 2", 2));
            tree.add(new Node("1.1.1", "1.1", "1.1.1 Press 1", 3));
            tree.add(new Node("1.2", "1", "1.2 Level 2", 2));
            InteractMenu interactMenu = new InteractMenu(tree, scanner);
            DisplayMenu displayMenu = new DisplayMenu(scanner, tree);
            displayMenu.addActions(new MenuAction() {
                @Override
                public String key() {
                    return "1";
                }
                @Override
                public void execute(Scanner in, Tree tree) {
                    System.out.println("Call Action 1");
                }
            });
            displayMenu.addActions(new Exit("exit", interactMenu));
            interactMenu.start(displayMenu);
            assertThat(tree.getTree().size(), is(4));
        }
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
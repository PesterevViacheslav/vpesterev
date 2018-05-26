package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.After;
import org.junit.Before;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Class StartUITest Автотесты для задач Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.05.2018
 * @version 1
 */
public class StartUITest {
    private Tracker tracker = new Tracker();
    private StubInput input = new StubInput(new String[] {"0", "TestName", "TestDsc", "0", "TestName2", "TestDsc2", "6"});
    private PrintStream stdout = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private void loadOut() {
        System.setOut(new PrintStream(this.out));
    }
    private void backOut() {
        System.setOut(this.stdout);
    }

    @Before
    public void runInit() {
        new StartUI(this.input, this.tracker).init();
    }
    /**
     * Тест метода добавления заявки.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item("TestName", "TestDsc");
        assertThat(tracker.findAll()[0], is(item));
    }
    /**
     * Тест метода изменения заявки.
     */
    @Test
    public void whenReplaceItemThenReturnNewItem() {
        input = new StubInput(new String[] {"2", tracker.findAll()[0].getId(), "TestName2", "TestDsc2", "6"});
        new StartUI(input, tracker).init();
        Item item = new Item("TestName2", "TestDsc2");
        assertThat(tracker.findAll()[0], is(item));
    }
    /**
     * Тест метода удаления заявки.
     */
    @Test
    public void whenDeleteItemThenDeletedItemNotFound() {
        assertThat(tracker.findAll()[0].getName(), is("TestName"));
        assertThat(tracker.findAll()[0].getDescription(), is("TestDsc"));
        assertThat(tracker.findAll()[1].getName(), is("TestName2"));
        assertThat(tracker.findAll()[1].getDescription(), is("TestDsc2"));
        input = new StubInput(new String[] {"3", tracker.findAll()[0].getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(1, is(tracker.size()));
    }
    /**
     * Тест метода поиска заявки по ID.
     */
    @Test
    public void checkFindItemById() {
        input = new StubInput(new String[] {"4", tracker.findAll()[0].getId(), "6"});
        loadOut();
        new StartUI(input, tracker).init();
        backOut();
        StringBuilder tst = new StringBuilder();
        tst.append("TRACKER MENU\n");
        tst.append("0. Add new Item\n");
        tst.append("1. Show all items\n");
        tst.append("2. Edit item\n");
        tst.append("3. Delete item\n");
        tst.append("4. Find item by Id\n");
        tst.append("5. Find items by name\n");
        tst.append("6. Exit Program\r\n");
        tst.append("***Find item by ID Start***\r\n");
        tst.append("Item found ID=" + tracker.findAll()[0].getId() + " Name=TestName Description=TestDsc\r\n");
        tst.append("TRACKER MENU\n");
        tst.append("0. Add new Item\n");
        tst.append("1. Show all items\n");
        tst.append("2. Edit item\n");
        tst.append("3. Delete item\n");
        tst.append("4. Find item by Id\n");
        tst.append("5. Find items by name\n");
        tst.append("6. Exit Program\r\n");
        tst.append("***EXIT***\r\n");
        assertThat(new String(out.toByteArray()), is(tst.toString()));
   }
    /**
     * Тест метода поиска заявки по имени.
     */
    @Test
    public void checkFindItemsByName() {
        input = new StubInput(new String[] {"5", "TestName2", "6"});
        loadOut();
        new StartUI(input, tracker).init();
        backOut();
        StringBuilder tst = new StringBuilder();
        tst.append("TRACKER MENU\n");
        tst.append("0. Add new Item\n");
        tst.append("1. Show all items\n");
        tst.append("2. Edit item\n");
        tst.append("3. Delete item\n");
        tst.append("4. Find item by Id\n");
        tst.append("5. Find items by name\n");
        tst.append("6. Exit Program\r\n");
        tst.append("***Find items by Name Start***\r\n");
        tst.append("Item found ID=" + tracker.findAll()[1].getId() + " Name=TestName2 Description=TestDsc2\r\n");
        tst.append("TRACKER MENU\n");
        tst.append("0. Add new Item\n");
        tst.append("1. Show all items\n");
        tst.append("2. Edit item\n");
        tst.append("3. Delete item\n");
        tst.append("4. Find item by Id\n");
        tst.append("5. Find items by name\n");
        tst.append("6. Exit Program\r\n");
        tst.append("***EXIT***\r\n");
        assertThat(new String(out.toByteArray()), is(tst.toString()));
    }
    /**
     * Тест метода поиска заявки по имени.
     */
    @Test
    public void checkFindAllItems() {
        input = new StubInput(new String[] {"1", "6"});
        loadOut();
        new StartUI(input, tracker).init();
        backOut();
        StringBuilder tst = new StringBuilder();
        tst.append("TRACKER MENU\n");
        tst.append("0. Add new Item\n");
        tst.append("1. Show all items\n");
        tst.append("2. Edit item\n");
        tst.append("3. Delete item\n");
        tst.append("4. Find item by Id\n");
        tst.append("5. Find items by name\n");
        tst.append("6. Exit Program\r\n");
        tst.append("***Items list:***\r\n");
        tst.append("Item ID=" + tracker.findAll()[0].getId() + " Name=TestName Description=TestDsc\r\n");
        tst.append("Item ID=" + tracker.findAll()[1].getId() + " Name=TestName2 Description=TestDsc2\r\n");
        tst.append("TRACKER MENU\n");
        tst.append("0. Add new Item\n");
        tst.append("1. Show all items\n");
        tst.append("2. Edit item\n");
        tst.append("3. Delete item\n");
        tst.append("4. Find item by Id\n");
        tst.append("5. Find items by name\n");
        tst.append("6. Exit Program\r\n");
        tst.append("***EXIT***\r\n");
        assertThat(new String(out.toByteArray()), is(tst.toString()));
    }
}
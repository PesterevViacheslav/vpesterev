package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.List;

import static org.mockito.Mockito.*;
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
        Item item = new Item("TestName", "TestDsc", new Timestamp(System.currentTimeMillis()));
        item.setId(tracker.findAll().get(0).getId());
        assertThat(tracker.findAll().get(0), is(item));
    }
    /**
     * Тест метода замены заявки.
     */
//    @Test
/*
    public void whenReplaceItemThenReturnNewItem() {
        input = new StubInput(new String[] {"2", tracker.findAll().get(0).getId(), "TestName2", "TestDsc2", "6"});
        new StartUI(input, tracker).init();
        Item item = new Item("TestName2", "TestDsc2");
        item.setId(tracker.findAll().get(0).getId());
        assertThat(tracker.findAll().get(0), is(item));
    }
*/
    /**
     * Тест метода замены заявки. Mock
     */
 /*   @Test
    public void whenReplaceItemThenReturnNewItemMock() {
        Input input = mock(Input.class);
        when(input.ask(any(String.class), any(List.class))).thenReturn(2).thenReturn(6);
        when(input.ask(any(String.class))).thenReturn(tracker.findAll().get(0).getId()).thenReturn("TestName2").thenReturn("TestDsc2");
        new StartUI(input, tracker).init();
        Item item = new Item("TestName2", "TestDsc2");
        item.setId(tracker.findAll().get(0).getId());
        assertThat(tracker.findAll().get(0), is(item));
    }
 */   /**
     * Тест метода изменения заявки.
     */
/*
    @Test
    public void whenChangeItemThenReturnNewItem() {
        input = new StubInput(new String[] {"7", tracker.findAll().get(0).getId(), "TestName2", "TestDsc2", "6"});
        new StartUI(input, tracker).init();
        Item item = new Item("TestName2", "TestDsc2");
        item.setId(tracker.findAll().get(0).getId());
        assertThat(tracker.findAll().get(0).getName(), is("TestName2"));
        assertThat(tracker.findAll().get(0).getDescription(), is("TestDsc2"));
    }
*/
    /**
     * Тест метода изменения заявки. Mock
     */
/*
    @Test
    public void whenChangeItemThenReturnNewItemMock() {
        Input input = mock(Input.class);
        when(input.ask(any(String.class), any(List.class))).thenReturn(7).thenReturn(6);
        when(input.ask(any(String.class))).thenReturn(tracker.findAll().get(0).getId()).thenReturn("TestName2").thenReturn("TestDsc2");
        new StartUI(input, tracker).init();
        Item item = new Item("TestName2", "TestDsc2");
        item.setId(tracker.findAll().get(0).getId());
        assertThat(tracker.findAll().get(0).getName(), is("TestName2"));
        assertThat(tracker.findAll().get(0).getDescription(), is("TestDsc2"));
    }
*/
    /**
     * Тест метода удаления заявки.
     */
/*
    @Test
    public void whenDeleteItemThenDeletedItemNotFound() {
        assertThat(tracker.findAll().get(0).getName(), is("TestName"));
        assertThat(tracker.findAll().get(0).getDescription(), is("TestDsc"));
        assertThat(tracker.findAll().get(1).getName(), is("TestName2"));
        assertThat(tracker.findAll().get(1).getDescription(), is("TestDsc2"));
        input = new StubInput(new String[] {"3", tracker.findAll().get(0).getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(1, is(tracker.size()));
    }
*/
    /**
     * Тест метода удаления заявки. Mock
     */
/*
    @Test
    public void whenDeleteItemThenDeletedItemNotFoundMock() {
        assertThat(tracker.findAll().get(0).getName(), is("TestName"));
        assertThat(tracker.findAll().get(0).getDescription(), is("TestDsc"));
        assertThat(tracker.findAll().get(1).getName(), is("TestName2"));
        assertThat(tracker.findAll().get(1).getDescription(), is("TestDsc2"));
        Input input = mock(Input.class);
        when(input.ask(any(String.class), any(List.class))).thenReturn(3).thenReturn(6);
        when(input.ask(any(String.class))).thenReturn(tracker.findAll().get(0).getId());
        new StartUI(input, tracker).init();
        assertThat(1, is(tracker.size()));
    }
*/
    /**
     * Тест метода поиска заявки по ID.
     */
/*    @Test
    public void checkFindItemByIdMock() {
        Input input = mock(Input.class);
        when(input.ask(any(String.class), any(List.class))).thenReturn(4).thenReturn(6);
        when(input.ask(any(String.class))).thenReturn(tracker.findAll().get(0).getId());
        //input = new StubInput(new String[] {"4", tracker.findAll().get(0).getId(), "6"});
        loadOut();
        new StartUI(input, tracker).init();
        backOut();
        StringBuilder tst = new StringBuilder();
        tst.append("TRACKER MENU");
        tst.append(System.lineSeparator());
        tst.append("0. Add new Item");
        tst.append(System.lineSeparator());
        tst.append("1. Show all items");
        tst.append(System.lineSeparator());
        tst.append("2. Edit item");
        tst.append(System.lineSeparator());
        tst.append("3. Delete item");
        tst.append(System.lineSeparator());
        tst.append("4. Find item by Id");
        tst.append(System.lineSeparator());
        tst.append("5. Find items by name");
        tst.append(System.lineSeparator());
        tst.append("6. Exit Program");
        tst.append(System.lineSeparator());
        tst.append("7. Change item");
        tst.append(System.lineSeparator());
        tst.append("***Find item by ID Start***");
        tst.append(System.lineSeparator());
        tst.append("Item found ID=" + tracker.findAll().get(0).getId() + " Name=TestName Description=TestDsc");
        tst.append(System.lineSeparator());
        tst.append("TRACKER MENU");
        tst.append(System.lineSeparator());
        tst.append("0. Add new Item");
        tst.append(System.lineSeparator());
        tst.append("1. Show all items");
        tst.append(System.lineSeparator());
        tst.append("2. Edit item");
        tst.append(System.lineSeparator());
        tst.append("3. Delete item");
        tst.append(System.lineSeparator());
        tst.append("4. Find item by Id");
        tst.append(System.lineSeparator());
        tst.append("5. Find items by name");
        tst.append(System.lineSeparator());
        tst.append("6. Exit Program");
        tst.append(System.lineSeparator());
        tst.append("7. Change item");
        tst.append(System.lineSeparator());
        tst.append("***EXIT***");
        tst.append(System.lineSeparator());
        assertThat(new String(out.toByteArray()), is(tst.toString()));
   }*/
    /**
     * Тест метода поиска заявки по имени.
     */
    @Test
    public void checkFindItemsByNameMock() {
        //input = new StubInput(new String[] {"5", "TestName2", "6"});
        Input input = mock(Input.class);
        when(input.ask(any(String.class), any(List.class))).thenReturn(5).thenReturn(6);
        when(input.ask(any(String.class))).thenReturn("TestName2");
        loadOut();
        new StartUI(input, tracker).init();
        backOut();
        StringBuilder tst = new StringBuilder();
        tst.append("TRACKER MENU");
        tst.append(System.lineSeparator());
        tst.append("0. Add new Item");
        tst.append(System.lineSeparator());
        tst.append("1. Show all items");
        tst.append(System.lineSeparator());
        tst.append("2. Edit item");
        tst.append(System.lineSeparator());
        tst.append("3. Delete item");
        tst.append(System.lineSeparator());
        tst.append("4. Find item by Id");
        tst.append(System.lineSeparator());
        tst.append("5. Find items by name");
        tst.append(System.lineSeparator());
        tst.append("6. Exit Program");
        tst.append(System.lineSeparator());
        tst.append("7. Change item");
        tst.append(System.lineSeparator());
        tst.append("***Find items by Name Start***");
        tst.append(System.lineSeparator());
        tst.append("Item found ID=" + tracker.findAll().get(1).getId() + " Name=TestName2 Description=TestDsc2");
        tst.append(System.lineSeparator());
        tst.append("TRACKER MENU");
        tst.append(System.lineSeparator());
        tst.append("0. Add new Item");
        tst.append(System.lineSeparator());
        tst.append("1. Show all items");
        tst.append(System.lineSeparator());
        tst.append("2. Edit item");
        tst.append(System.lineSeparator());
        tst.append("3. Delete item");
        tst.append(System.lineSeparator());
        tst.append("4. Find item by Id");
        tst.append(System.lineSeparator());
        tst.append("5. Find items by name");
        tst.append(System.lineSeparator());
        tst.append("6. Exit Program");
        tst.append(System.lineSeparator());
        tst.append("7. Change item");
        tst.append(System.lineSeparator());
        tst.append("***EXIT***");
        tst.append(System.lineSeparator());
        assertThat(new String(out.toByteArray()), is(tst.toString()));
    }
    /**
     * Тест ввода несуществующего пункта меню.
     */
    @Test
    public void checkWrongMenuKeyMock() {
        //input = new StubInput(new String[] {"10", "6"});
        Input input = mock(Input.class);
        when(input.ask(any(String.class), any(List.class))).thenReturn(10).thenReturn(6);
        loadOut();
        new StartUI(input, tracker).init();
        backOut();
        StringBuilder tst = new StringBuilder();
        tst.append("TRACKER MENU");
        tst.append(System.lineSeparator());
        tst.append("0. Add new Item");
        tst.append(System.lineSeparator());
        tst.append("1. Show all items");
        tst.append(System.lineSeparator());
        tst.append("2. Edit item");
        tst.append(System.lineSeparator());
        tst.append("3. Delete item");
        tst.append(System.lineSeparator());
        tst.append("4. Find item by Id");
        tst.append(System.lineSeparator());
        tst.append("5. Find items by name");
        tst.append(System.lineSeparator());
        tst.append("6. Exit Program");
        tst.append(System.lineSeparator());
        tst.append("7. Change item");
        tst.append(System.lineSeparator());
        tst.append("Wrong menu key");
        tst.append(System.lineSeparator());
        tst.append("TRACKER MENU");
        tst.append(System.lineSeparator());
        tst.append("0. Add new Item");
        tst.append(System.lineSeparator());
        tst.append("1. Show all items");
        tst.append(System.lineSeparator());
        tst.append("2. Edit item");
        tst.append(System.lineSeparator());
        tst.append("3. Delete item");
        tst.append(System.lineSeparator());
        tst.append("4. Find item by Id");
        tst.append(System.lineSeparator());
        tst.append("5. Find items by name");
        tst.append(System.lineSeparator());
        tst.append("6. Exit Program");
        tst.append(System.lineSeparator());
        tst.append("7. Change item");
        tst.append(System.lineSeparator());
        tst.append("***EXIT***");
        tst.append(System.lineSeparator());
        assertThat(new String(out.toByteArray()), is(tst.toString()));
    }
    /**
     * Тест ввода пункта меню в некорректном формате.
     */
    @Test
    public void checkWrongFormatMenuKey() {
        input = new StubInput(new String[] {"wrong", "6"});
        loadOut();
        new StartUI(input, tracker).init();
        backOut();
        StringBuilder tst = new StringBuilder();
        tst.append("TRACKER MENU");
        tst.append(System.lineSeparator());
        tst.append("0. Add new Item");
        tst.append(System.lineSeparator());
        tst.append("1. Show all items");
        tst.append(System.lineSeparator());
        tst.append("2. Edit item");
        tst.append(System.lineSeparator());
        tst.append("3. Delete item");
        tst.append(System.lineSeparator());
        tst.append("4. Find item by Id");
        tst.append(System.lineSeparator());
        tst.append("5. Find items by name");
        tst.append(System.lineSeparator());
        tst.append("6. Exit Program");
        tst.append(System.lineSeparator());
        tst.append("7. Change item");
        tst.append(System.lineSeparator());
        tst.append("Wrong format menu key");
        tst.append(System.lineSeparator());
        tst.append("***EXIT***");
        tst.append(System.lineSeparator());
        assertThat(new String(out.toByteArray()), is(tst.toString()));
    }
}
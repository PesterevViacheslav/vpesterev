package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class StartUITest Автотесты для задач Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.05.2018
 * @version 1
 */
public class StartUITest {
    /**
     * Тест метода добавления заявки.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        StubInput input = new StubInput(new String[] {"0", "TestName", "TestDsc", "6"});
        Item item = new Item("TestName", "TestDsc");
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(item));
    }
    /**
     * Тест метода изменения заявки.
     */
    @Test
    public void whenReplaceItemThenReturnNewItem() {
        Tracker tracker = new Tracker();
        StubInput input = new StubInput(new String[] {"0", "TestName", "TestDsc", "6"});
        new StartUI(input, tracker).init();
        input = new StubInput(new String[] {"2", tracker.findAll()[0].getId(), "TestName2", "TestDsc2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("TestName2"));
        assertThat(tracker.findAll()[0].getDescription(), is("TestDsc2"));
    }
    /**
     * Тест метода удаления заявки.
     */
    @Test
    public void whenDeleteItemThenDeletedItemNotFound() {
        Tracker tracker = new Tracker();
        StubInput input = new StubInput(new String[] {"0", "TestName", "TestDsc", "0", "TestName2", "TestDsc2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("TestName"));
        assertThat(tracker.findAll()[0].getDescription(), is("TestDsc"));
        assertThat(tracker.findAll()[1].getName(), is("TestName2"));
        assertThat(tracker.findAll()[1].getDescription(), is("TestDsc2"));
        input = new StubInput(new String[] {"3", tracker.findAll()[0].getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(1, is(tracker.size()));
    }
}
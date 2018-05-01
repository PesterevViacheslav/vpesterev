package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TrackerTest Автотесты для задач Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.04.2018
 * @version 1
 */
public class TrackerTest {
    /**
     * Тест метода добавления заявки.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
        Item item2 = new Item("test2", "dsc2");
        tracker.add(item2);
        assertThat(tracker.findAll()[1], is(item2));
    }
    /**
     * Тест метода замены заявки.
     */
    @Test
    public void whenReplaceItemThenReturnNewItem() {
        Tracker tracker = new Tracker();
        Item prev = new Item("test1", "dsc1");
        tracker.add(prev);
        Item next = new Item("test2", "dsc2");
        tracker.replace(prev.getId(), next);
        assertThat(tracker.findById(prev.getId()), is(next));
    }
    /**
     * Тест метода удаления заявки.
     */
    @Test
    public void whenDeleteItemThenDeletedItemNotFound() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1");
        tracker.add(item);
        Item item2 = new Item("test2", "dsc1");
        tracker.add(item2);
        tracker.delete(item.getId());
        assertThat(new Item(), is(tracker.findById(item.getId())));
        assertThat(1, is(tracker.size()));
    }
    /**
     * Тест метода поиска заявки по ID (Найдено).
     */
    @Test
    public void whenFindedById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1");
        tracker.add(item);
        assertThat(item, is(tracker.findById(item.getId())));
    }
    /**
     * Тест метода поиска заявки по ID (Не найдено).
     */
    @Test
    public void whenNotFindedById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1");
        tracker.add(item);
        assertThat(new Item(), is(tracker.findById("111111")));
    }
    /**
     * Тест метода поиска заявки по названию (Найдено).
     */
    @Test
    public void whenFindedByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1");
        tracker.add(item);
        Item item2 = new Item("test1", "dsc2");
        tracker.add(item2);
        Item item3 = new Item("test2", "dsc3");
        tracker.add(item3);
        Item[] items = new Item[2];
        items[0] = item;
        items[1] = item2;
        assertThat(items, is(tracker.findByName("test1")));
    }
    /**
     * Тест метода поиска заявки по названию (Не найдено).
     */
    @Test
    public void whenNotFindedByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1");
        tracker.add(item);
        Item item2 = new Item("test1", "dsc2");
        tracker.add(item2);
        Item item3 = new Item("test2", "dsc3");
        tracker.add(item3);
        assertThat(new Item[0], is(tracker.findByName("test5")));
    }
    /**
     * Тест метода поиска заявки по названию (Не найдено).
     */
    @Test
    public void whenFindedAllItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1");
        tracker.add(item);
        Item item2 = new Item("test1", "dsc2");
        tracker.add(item2);
        Item item3 = new Item("test2", "dsc3");
        tracker.add(item3);
        Item[] items = new Item[3];
        items[0] = item;
        items[1] = item2;
        items[2] = item3;
        assertThat(items, is(tracker.findAll()));
    }
}

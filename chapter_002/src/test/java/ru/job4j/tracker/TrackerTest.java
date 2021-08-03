package ru.job4j.tracker;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;

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
        Item item = new Item("test1", "dsc", new Timestamp(System.currentTimeMillis()));
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
        Item item2 = new Item("test2", "dsc2", new Timestamp(System.currentTimeMillis()));
       tracker.add(item2);
        assertThat(tracker.findAll().get(1), is(item2));
    }
    /**
     * Тест метода замены заявки.
     */
    @Test
    public void whenReplaceItemThenReturnNewItem() {
        Tracker tracker = new Tracker();
        Item prev = new Item("test1", "dsc1", new Timestamp(System.currentTimeMillis()));
        tracker.add(prev);
        Item next = new Item("test2", "dsc2", new Timestamp(System.currentTimeMillis()));
        tracker.replace(prev.getId(), next);
        assertThat(tracker.findById(prev.getId()), is(next));
    }
    /**
     * Тест метода изменения заявки.
     */
    @Test
    public void whenChangeItemThenReturnNewItem() {
        Tracker tracker = new Tracker();
        Item prev = new Item("test1", "dsc1", new Timestamp(System.currentTimeMillis()));
        tracker.add(prev);
        Item next = new Item("test2", "dsc2", new Timestamp(System.currentTimeMillis()));
        tracker.change(prev.getId(), next);
        assertThat(tracker.findById(prev.getId()).getName(), is("test2"));
        assertThat(tracker.findById(prev.getId()).getDescription(), is("dsc2"));
    }
    /**
     * Тест метода удаления заявки.
     */
    @Test
    public void whenDeleteItemThenDeletedItemNotFound() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1", new Timestamp(System.currentTimeMillis()));
        tracker.add(item);
        Item item2 = new Item("test2", "dsc1", new Timestamp(System.currentTimeMillis()));
        tracker.add(item2);
        tracker.delete(item.getId());
        assertThat(new Item(), is(tracker.findById(item.getId())));
        assertThat(1, is(tracker.size()));
    }
    /**
     * Тест метода повторного удаления той же самой заявки.
     */
    @Test
    public void whenDeleteTwiceItemThenDeletedOnce() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1", new Timestamp(System.currentTimeMillis()));
        tracker.add(item);
        Item item2 = new Item("test2", "dsc1", new Timestamp(System.currentTimeMillis()));
        tracker.add(item2);
        tracker.delete(item.getId());
        tracker.delete(item.getId());
        assertThat(new Item(), is(tracker.findById(item.getId())));
        assertThat(1, is(tracker.size()));
    }
    /**
     * Тест метода поиска заявки по ID (Найдено).
     */
    @Test
    public void whenFoundById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1", new Timestamp(System.currentTimeMillis()));
        tracker.add(item);
        assertThat(item, is(tracker.findById(item.getId())));
    }
    /**
     * Тест метода поиска заявки по ID (Не найдено).
     */
    @Test
    public void whenNotFoundById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1", new Timestamp(System.currentTimeMillis()));
        tracker.add(item);
        assertThat(new Item(), is(tracker.findById(111111)));
    }
    /**
     * Тест метода поиска заявки по названию (Найдено).
     */
    @Test
    public void whenFoundByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1", new Timestamp(System.currentTimeMillis()));
        tracker.add(item);
        Item item2 = new Item("test1", "dsc2", new Timestamp(System.currentTimeMillis()));
        tracker.add(item2);
        Item item3 = new Item("test2", "dsc3", new Timestamp(System.currentTimeMillis()));
        tracker.add(item3);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        assertThat(items, is(tracker.findByName("test1")));
    }
    /**
     * Тест метода поиска заявки по названию (Не найдено).
     */
    @Test
    public void whenNotFoundByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1", new Timestamp(System.currentTimeMillis()));
        tracker.add(item);
        Item item2 = new Item("test1", "dsc2", new Timestamp(System.currentTimeMillis()));
        tracker.add(item2);
        Item item3 = new Item("test2", "dsc3", new Timestamp(System.currentTimeMillis()));
        tracker.add(item3);
        assertThat(new ArrayList<Item>(), is(tracker.findByName("test5")));
    }
    /**
     * Тест метода поиска заявки по названию (Не найдено).
     */
    @Test
    public void whenFoundAllItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "dsc1", new Timestamp(System.currentTimeMillis()));
        tracker.add(item);
        Item item2 = new Item("test1", "dsc2", new Timestamp(System.currentTimeMillis()));
        tracker.add(item2);
        Item item3 = new Item("test2", "dsc3", new Timestamp(System.currentTimeMillis()));
        tracker.add(item3);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        items.add(item3);
        assertThat(items, is(tracker.findAll()));
    }
}
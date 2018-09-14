package ru.job4j.hierarchy;
/**
 * Class HierarchyTest. Автотесты для задач Части 003. Collections. Lite.
 * Задача 5.4 Отсортировать департаменты.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.09.2018
 * @version 1
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class HierarchyTest {
    /**
     * Тест сортировки по возрастанию
     */
    @Test
    public void testSortAsc() {
        String[] list = new String[] {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        String[] expect = new String[] {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        Hierarchy hierarchy = new Hierarchy();
        assertThat(hierarchy.sortAsc(list), is(expect));
    }
    /**
     * Тест сортировки по убыванию
     */
    @Test
    public void testSortDesc() {
        String[] list = new String[] {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        String[] expect = new String[] {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        Hierarchy hierarchy = new Hierarchy();
        assertThat(hierarchy.sortDesc(list), is(expect));
    }
}
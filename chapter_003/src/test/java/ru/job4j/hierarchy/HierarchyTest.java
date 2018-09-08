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
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class HierarchyTest {
    @Test
    /**
     * Тест сортировки по возрастанию
     */
    public void testSortAsc() {
        ArrayList<String> list = new ArrayList<>();
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");
        ArrayList<String> expect = new ArrayList<>();
        expect.add("K1");
        expect.add("K1\\SK1");
        expect.add("K1\\SK1\\SSK1");
        expect.add("K1\\SK1\\SSK2");
        expect.add("K1\\SK2");
        expect.add("K2");
        expect.add("K2\\SK1");
        expect.add("K2\\SK1\\SSK1");
        expect.add("K2\\SK1\\SSK2");
        Hierarchy hierarchy = new Hierarchy(list);
        assertThat(hierarchy.sortAsc().toArray(), is(expect.toArray()));
    }
    @Test
    /**
     * Тест сортировки по убыванию
     */
    public void testSortDesc() {
        ArrayList<String> list = new ArrayList<>();
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");
        ArrayList<String> expect = new ArrayList<>();
        expect.add("K2");
        expect.add("K2\\SK1");
        expect.add("K2\\SK1\\SSK2");
        expect.add("K2\\SK1\\SSK1");
        expect.add("K1");
        expect.add("K1\\SK2");
        expect.add("K1\\SK1");
        expect.add("K1\\SK1\\SSK2");
        expect.add("K1\\SK1\\SSK1");
        Hierarchy hierarchy = new Hierarchy(list);
        assertThat(hierarchy.sortDesc().toArray(), is(expect.toArray()));
    }

}

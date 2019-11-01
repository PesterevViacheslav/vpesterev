package ru.job4j;
import org.junit.Test;
import ru.job4j.lsp.*;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TestControlQuality - Автотест Контроль качества продуктов. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.11.2019
 * @version 1
 */
public class TestControlQuality {
    /**
     * Тест контроля качества.
     */
    @Test
    public void testControlQuality() {
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Bread("Батон", 5, 0, LocalDate.now().plusDays(5), LocalDate.now(), 1.5, "Белый"));
        foods.add(new Bread("Дарницкий", 7, 0, LocalDate.now(), LocalDate.now().minusDays(7), 1.7, "Черный"));
        foods.add(new Pizza("Маргарита", 27, 0, LocalDate.now().plusDays(1), LocalDate.now().minusDays(2), 30));
        foods.add(new Pizza("Альфредо", 30, 0, LocalDate.now().plusDays(2), LocalDate.now(), 42));
        foods.add(new Spaghetti("Каннелоне", 30, 0, LocalDate.now().plusDays(30), LocalDate.now().minusDays(50), 20));
        foods.add(new Spaghetti("Макароны", 30, 0, LocalDate.now().plusDays(40), LocalDate.now().minusDays(70), 30));
        Warehouse warehouse = new Warehouse("Москва");
        Shop shop = new Shop("Серпухов", "Дисконт");
        Trash trash = new Trash(LocalDate.now().plusDays(30));
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.check(foods, warehouse, shop, trash);
        assertThat(warehouse.size(), is(2));
        assertThat(shop.size(), is(3));
        assertThat(trash.size(), is(1));
    }
}
package ru.job4j.lsp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Class ControlQuality - Контроль качества продуктов. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class ControlQuality {
    /**
     * Method check. Сортировка продуктов
     * @param foods Продукты.
     * @param stores Хранилища.
     */
    public void check(List<Food> foods, List<Store> stores) {
        for (Food food : foods) {
            for (Store store: stores) {
                if (store.accept(food, getExpirePercent(food))) {
                    store.add(food);
                    break;
                }
            }
        }
    }
    /**
     * Method getExpirePercent Получение срока годности.
     * @param food Продукт.
     * @return
     */
    private double getExpirePercent(Food food) {
        LocalDate now = LocalDate.now();
        long daysToExpire = ChronoUnit.DAYS.between(now, food.getExpireDate());
        long daysFromCreateToExpire = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpireDate());
        return (double) daysToExpire / daysFromCreateToExpire;
    }
    /**
     * Method resort. Перераспределение продуктов
     * @param storages Хранилища.
     * @param stores Магазины
     */
    public void resort(List<Storage> storages, List<Store> stores) {
        for (Storage s : storages) {
                ArrayList<Food> foodList = new ArrayList<>();
                foodList.addAll(s.getFoodList());
                s.clear();
                check(foodList, stores);
            }
    }
}
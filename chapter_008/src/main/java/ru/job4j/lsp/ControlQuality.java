package ru.job4j.lsp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
/**
 * Class ControlQuality - Контроль качества продуктов. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class ControlQuality {
    public void check(ArrayList<Food> foods, Warehouse warehouse, Shop shop, Trash trash) {
        LocalDate now = LocalDate.now();
        for (Food food : foods) {
            long daysToExpire = ChronoUnit.DAYS.between(now, food.getExpireDate());
            long daysFromCreateToExpire = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpireDate());
            double expirePercent = (double) daysToExpire / daysFromCreateToExpire;
            if (expirePercent > 0.75) {
                warehouse.add(food);
            } else if (expirePercent <= 0.75 && expirePercent > 0.25) {
                shop.add(food);
            } else if (expirePercent >= 0.25 && expirePercent > 0.01) {
                food.setDiscount(1);
                shop.add(food);
            } else {
                trash.add(food);
            }
        }
    }
}
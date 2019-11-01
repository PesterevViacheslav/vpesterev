package ru.job4j.lsp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ControlQuality {
    public void check(ArrayList<Food> foods, Warehouse warehouse, Shop shop, Trash trash) {
        LocalDate now = LocalDate.now();
        for (Food food : foods) {
            long expireDays = ChronoUnit.DAYS.between(now, food.getExpireDate());
/*            if () {

            }*/
        }
    }
}

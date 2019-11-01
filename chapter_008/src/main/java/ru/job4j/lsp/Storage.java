package ru.job4j.lsp;
import java.util.ArrayList;
/**
 * Class Storage - Хранилище. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 31.10.2019
 * @version 1
 */
public class Storage {
    private ArrayList<Food> foodList;
    /**
     * Method Storage. Конструктор.
     */
    public Storage() {
        this.foodList = new ArrayList<>();
    }
    /**
     * Method add. Добавление продукта.
     * @param food Продукт
     */
    public void add(Food food) {
        this.foodList.add(food);
    }
    /**
     * Method size. Количество пордуктов в хранилище.
     * @return Количество
     */
    public int size() {
        return this.foodList.size();
    }
}
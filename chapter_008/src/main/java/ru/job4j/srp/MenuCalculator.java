package ru.job4j.srp;
import ru.job4j.calculator.Calculator;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Class MenuCalculator - Меню калькулятора. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.10.2019
 * @version 1
 */
public class MenuCalculator {
    private Calculator calculator;
    private Scanner in;
    protected Double number;
    protected HashMap<String, UserAction> actions = new HashMap<>();
    /**
     * Method MenuCalculator. Конструктор
     * @param in
     * @param calculator
     */
    public MenuCalculator(Scanner in, Calculator calculator) {
        this.in = in;
        this.calculator = calculator;
    }
    /**
     * Method show. Заполнение информация об операции.
     */
    public void show() {
        System.out.println("TRACKER MENU");
        System.out.println("------------");
        this.actions.entrySet().forEach(entry -> System.out.println(entry.getValue().info()));
        System.out.println("------------");
    }
    /**
     * Method select. Выбор операции.
     * @param key Код операции.
     */
    public Double select(String key, Double n) {
        this.number = n;
        if (this.actions.containsKey(key)) {
            this.actions.get(key).execute(this.in, this.calculator);
        } else {
            System.out.println("Wrong menu key");
        }
        return this.number;
    }
    /**
     * Method getNumber Получение результата
     * @return Текущий результат
     */
    public Double getNumber() {
        return number;
    }
    /**
     * Method setNumber Установка результата
     * @param number Значение.
     */
    public void setNumber(Double number) {
        this.number = number;
    }
    /**
     * Method addActions. Добавление действия.
     */
    public void addActions(UserAction userAction) {
        this.actions.put(userAction.key(), userAction);
    }
}
package ru.job4j.tracker;
/**
 * Class StartUI - Точка входа (интерфейс). Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.05.2018
 * @version 1
 */
public class StartUI {
    private Input input;
    private Tracker tracker;
    /**
     * Method StartUI. Конструктор.
     * @param input Ввод с консоли.
     * @param tracker Стек заявок.
     * @return ID заявки
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Method Init. Запуск на выполнение.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            int key = 0;
            menu.show();
            key = Integer.valueOf(this.input.ask("Select:"));
            if (key > 6) {
                System.out.println("Wrong key");
            } else {
                menu.select(key);
            }
            if (key == 6) {
                break;
            }
        } while (!"y".equals(this.input.ask("Exit? (y/n):")));
    }
    /**
     * Method main.
     * @param args Параметры.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
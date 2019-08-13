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
    private final ITracker tracker;
    private boolean work = true;
    /**
     * Method StartUI. Конструктор.
     * @param input Ввод с консоли.
     * @param tracker Стек заявок.
     * @return ID заявки
     */
    public StartUI(Input input, ITracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Method stop. Прекращение работы.
     */
    public void stop() {
        this.work = false;
    }
    /**
     * Method Init. Запуск на выполнение.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, tracker);
        int key = 0;
        menu.fillActions(this);
        do {
            menu.show();
            key = this.input.ask("Select:", menu.getKeyInAvailableList());
            menu.select(key);
        } while (this.work);
    }
    /**
     * Method main.
     * @param args Параметры.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
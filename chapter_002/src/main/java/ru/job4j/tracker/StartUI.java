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
            try {
                key = this.input.ask("Select:", menu.AVAILABLE_RANGE_LIST);
                menu.select(key);
            } catch (MenuOutException moe) {
                System.out.println("Wrong menu key");
            } catch (NumberFormatException nfe) {
                System.out.println("Wrong format menu key");
            }
            if (key == 6) {
                break;
            }
        } while (!"6".equals(this.input.ask("Enter 6 for Exit, 7 for show menu:", menu.AVAILABLE_RANGE_LIST)));
    }
    /**
     * Method main.
     * @param args Параметры.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
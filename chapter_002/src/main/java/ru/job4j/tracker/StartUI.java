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
    private boolean work = true;
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
        menu.fillActions(this);
        UserAction changeItem = new UserAction() {
            @Override
            public int key() {
                return 7;
            }
            @Override
            public void execute(Input input, Tracker tracker) {
                System.out.println("***Change item Start***");
                String id = input.ask("Input Item ID:");
                String name = input.ask("Input New Item Name:");
                String description = input.ask("Input New Item Description:");
                Item item = new Item(name, description);
                if (!tracker.change(id, item)) {
                    System.out.println("***Item not found***");
                }
                System.out.println("***Item changed successfully***");
            }
            @Override
            public String info() {
                return String.format("%s%s", this.key(), ". Change item");
            }
        };
        menu.addAction(changeItem);
        try {
            do {
                int key = 0;
                menu.show();
                try {
                    key = this.input.ask("Select:", menu.getKeyInAvailableList());
                    menu.select(key);
                } catch (MenuOutException moe) {
                    System.out.println("Wrong menu key");
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong format menu key");
                }
                if (key == 6) {
                    break;
                }
            } while (this.work);
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong format menu key");
        }
    }
    /**
     * Method main.
     * @param args Параметры.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
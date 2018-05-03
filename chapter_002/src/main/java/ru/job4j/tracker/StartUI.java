package ru.job4j.tracker;
/**
 * Class StartUI - Точка входа (интерфейс). Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.05.2018
 * @version 1
 */
public class StartUI {
    private static final String ADD_NEW_ITEM = "0";
    private static final String SHOW_ALL_ITEMS = "1";
    private static final String EDIT_ITEM = "2";
    private static final String DELETE_ITEM = "3";
    private static final String FIND_ITEM_BY_ID = "4";
    private static final String FIND_ITEMS_BY_NAME = "5";
    private static final String EXIT = "6";
    private ConsoleInput consoleInput = new ConsoleInput();
    private Tracker tracker = new Tracker();
    /**
     * Method StartUI. Конструктор.
     * @param consoleInput Ввод с консоли.
     * @param tracker Стек заявок.
     * @return ID заявки
     */
    public StartUI(ConsoleInput consoleInput, Tracker tracker) {
        this.consoleInput = consoleInput;
        this.tracker = tracker;
    }
    /**
     * Method addItem. Добавление заявки в стек.
     */
    private void showMenu() {
        System.out.println("TRACKER MENU\n"
                         + "0. Add new Item\n"
                         + "1. Show all items\n"
                         + "2. Edit item\n"
                         + "3. Delete item\n"
                         + "4. Find item by Id\n"
                         + "5. Find items by name\n"
                         + "6. Exit Program");
    }
    /**
     * Method addItem. Добавление заявки в стек.
     */
    private void addItem() {
        System.out.println("***Add new item Start***");
        String name = consoleInput.ask("Input Item Name:");
        String description = consoleInput.ask("Input Item Description:");
        Item item = new Item(name, description);
        this.tracker.add(item);
        System.out.println("Item created, ID=" + item.getId());
    }
    /**
     * Method showAllItems. Отображение списка заявок в стеке.
     */
    private void showAllItems() {
        System.out.println("***Items list:***");
        Item[] items = this.tracker.findAll();
        if (items.length == 0) {
            System.out.println("Items not found");
        } else {
            for (Item item : items) {
                System.out.println("Item ID=" + item.getId() + " Name=" + item.getName() + " Description=" + item.getDescription());
            }
        }
    }
    /**
     * Method editItem. Редактирование заявки.
     */
    private void editItem() {
        System.out.println("***Edit item Start***");
        String id = consoleInput.ask("Input Item ID:");
        if (this.tracker.findById(id).equals(new Item())) {
            System.out.println("Item not found");
        } else {
            String name = consoleInput.ask("Input New Item Name:");
            String description = consoleInput.ask("Input New Item Description:");
            Item item = new Item(name, description);
            this.tracker.replace(id, item);
            System.out.println("***Item edited successfully***");
        }
    }
    /**
     * Method deleteItem. Удаление заявки из стека.
     */
    private void deleteItem() {
        System.out.println("***Delete item Start***");
        String id = consoleInput.ask("Input Item ID:");
        if (this.tracker.findById(id).equals(new Item())) {
            System.out.println("Item not found");
        } else {
            this.tracker.delete(id);
            System.out.println("***Item deleted successfully***");
        }
    }
    /**
     * Method findItemById. Поиск заявки по ID.
     */
    private void findItemById() {
        System.out.println("***Find item by ID Start***");
        String id = consoleInput.ask("Input Item ID:");
        Item item = this.tracker.findById(id);
        if (item.equals(new Item())) {
            System.out.println("Item not found");
        } else {
            System.out.println("Item found ID=" + item.getId() + " Name=" + item.getName() + " Description=" + item.getDescription());
        }
    }
    /**
     * Method findItemsByName. Поиск заявок по имени.
     */
    private void findItemsByName() {
        System.out.println("***Find items by Name Start***");
        String name = consoleInput.ask("Input Item name:");
        Item[] items = this.tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("Items not found");
        } else {
            for (Item item : items) {
                System.out.println("Item found ID=" + item.getId() + " Name=" + item.getName() + " Description=" + item.getDescription());
            }
        }
    }
    /**
     * Method wrongMenuOption. Обработка несуществующего пункта меню.
     */
    private void wrongMenuOption() {
        System.out.println("***Wrong option, input another from list:***");
    }
    /**
     * Method exit. Выход из меню.
     */
    private void exit() {
        System.out.println("***EXIT***");
    }
    /**
     * Method Init. Запуск на выполнение.
     */
    private void init() {
        boolean exit = false;

        while (!exit) {
            this.showMenu();
            String answer = this.consoleInput.ask("Select:");
            if (ADD_NEW_ITEM.equals(answer)) {
                this.addItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
                exit();
            } else if (SHOW_ALL_ITEMS.equals(answer)) {
                this.showAllItems();
            } else if (EDIT_ITEM.equals(answer)) {
                this.editItem();
            } else if (DELETE_ITEM.equals(answer)) {
                this.deleteItem();
            } else if (FIND_ITEM_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_ITEMS_BY_NAME.equals(answer)) {
                this.findItemsByName();
            } else {
                this.wrongMenuOption();
            }
        }
    }
    /**
     * Method main.
     * @param args Параметры.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
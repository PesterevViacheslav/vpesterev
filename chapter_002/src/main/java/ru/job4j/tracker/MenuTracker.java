package ru.job4j.tracker;

/**
 * Class EditItem - Внешний класс - Редактирование заявки в трекере.
 */
class EditItem implements UserAction {
    /**
     * Method key. Возврат номера операции.
     * @return Номер операции.
     */
    public int key() {
        return 2;
    }
    /**
     * Method execute. Выполнение действия.
     * @param input Ввод-вывод.
     * @param tracker Трекер.
     */
    public void execute(Input input, Tracker tracker) {
        System.out.println("***Edit item Start***");
        String id = input.ask("Input Item ID:");
        if (tracker.findById(id).equals(new Item())) {
            throw new ItemNotFoundException("Item not found");
        } else {
            String name = input.ask("Input New Item Name:");
            String description = input.ask("Input New Item Description:");
            Item item = new Item(name, description);
            tracker.replace(id, item);
            System.out.println("***Item edited successfully***");
        }
    }
    /**
     * Method info. Отображение информации об операции.
     * @return Информация об операции.
     */
    public String info() {
        return String.format("%s%s", this.key(), ". Edit item");
    }
}
/**
 * Class DeleteItem - Внешний класс - Удаление заявки из трекера.
 */
class DeleteItem implements UserAction {
    /**
     * Method key. Возврат номера операции.
     * @return Номер операции.
     */
    public int key() {
        return 3;
    }
    /**
     * Method execute. Выполнение действия.
     * @param input Ввод-вывод.
     * @param tracker Трекер.
     */
    public void execute(Input input, Tracker tracker) {
        System.out.println("***Delete item Start***");
        String id = input.ask("Input Item ID:");
        if (tracker.findById(id).equals(new Item())) {
            throw new ItemNotFoundException("Item not found");
        } else {
            tracker.delete(id);
            System.out.println("***Item deleted successfully***");
        }
    }
    /**
     * Method info. Отображение информации об операции.
     * @return Информация об операции.
     */
    public String info() {
        return String.format("%s%s", this.key(), ". Delete item");
    }
}
/**
 * Class MenuTracker - Меню трекера. Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 28.05.2018
 * @version 1
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private int[] availableRangeList = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
    /**
     * Method MenuTracker. Конструктор.
     * @param input Ввод-вывод.
     * @param tracker Трекер.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Method getAvailableRangeList. Список допустимых кодов меню.
     * @return Список кодов меню.
     */
    public int[] getAvailableRangeList() {
        return this.availableRangeList;
    }
    /**
     * Method fillActions. Заполнение стека операций трекера.
     */
    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = this.new ShowAllItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = this.new FindItemById();
        this.actions[5] = this.new FindItemsByName();
        this.actions[6] = this.new Exit();
    }
    /**
     * Method show. Заполнение информация об операции.
     */
    public void show() {
        System.out.println("TRACKER MENU");
        for (int i = 0; i < this.actions.length; i++) {
            if (this.actions[i] != null) {
                System.out.println(this.actions[i].info());
            }
        }
    }
    /**
     * Method select. Выбор операции.
     * @param key Код операции.
     */
    public void select(int key) {
        if (this.actions[key] != null) {
            this.actions[key].execute(this.input, this.tracker);
        }
    }
    /**
     * Class AddItem - Внутренний класс - Добавление заявки в трекер.
     */
    private class AddItem implements UserAction {
        /**
         * Method key. Возврат номера операции.
         * @return Номер операции.
         */
        public int key() {
            return 0;
        }
        /**
         * Method execute. Выполнение действия.
         * @param input Ввод-вывод.
         * @param tracker Трекер.
         */
        public void execute(Input input, Tracker tracker) {
            System.out.println("***Add new item Start***");
            String name = input.ask("Input Item Name:");
            String description = input.ask("Input Item Description:");
            tracker.add(new Item(name, description));
        }
        /**
         * Method info. Отображение информации об операции.
         * @return Информация об операции.
         */
        public String info() {
            return String.format("%s%s", this.key(), ". Add new Item");
        }
    }
    /**
     * Class ShowAllItems - Внутренний класс - Отображение всех заявок трекера.
     */
    private class ShowAllItems implements UserAction {
        /**
         * Method key. Возврат номера операции.
         * @return Номер операции.
         */
        public int key() {
            return 1;
        }
        /**
         * Method execute. Выполнение действия.
         * @param input Ввод-вывод.
         * @param tracker Трекер.
         */
        public void execute(Input input, Tracker tracker) {
            System.out.println("***Items list:***");
            Item[] items = tracker.findAll();
            if (items.length == 0) {
                throw new ItemNotFoundException("Items not found");
            } else {
                for (Item item : items) {
                    System.out.println(String.format("%s%s %s%s %s%s", "Item ID=", item.getId(), "Name=", item.getName(), "Description=", item.getDescription()));
                }
            }
        }
        /**
         * Method info. Отображение информации об операции.
         * @return Информация об операции.
         */
        public String info() {
            return String.format("%s%s", this.key(), ". Show all items");
        }
    }
    /**
     * Class FindItemById - Внутренний класс - Поиск заявки по ID.
     */
    private class FindItemById implements UserAction {
        /**
         * Method key. Возврат номера операции.
         * @return Номер операции.
         */
        public int key() {
            return 4;
        }
        /**
         * Method execute. Выполнение действия.
         * @param input Ввод-вывод.
         * @param tracker Трекер.
         */
        public void execute(Input input, Tracker tracker) {
            System.out.println("***Find item by ID Start***");
            String id = input.ask("Input Item ID:");
            Item item = tracker.findById(id);
            if (item.equals(new Item())) {
                throw new ItemNotFoundException("Item not found");
            } else {
                System.out.println(String.format("%s%s %s%s %s%s", "Item found ID=", item.getId(), "Name=", item.getName(), "Description=", item.getDescription()));
            }
        }
        /**
         * Method info. Отображение информации об операции.
         * @return Информация об операции.
         */
        public String info() {
            return String.format("%s%s", this.key(), ". Find item by Id");
        }
    }
    /**
     * Class FindItemsByName - Внутренний класс - Поиск заявок по названию.
     */
    private class FindItemsByName implements UserAction {
        /**
         * Method key. Возврат номера операции.
         * @return Номер операции.
         */
        public int key() {
            return 5;
        }
        /**
         * Method execute. Выполнение действия.
         * @param input Ввод-вывод.
         * @param tracker Трекер.
         */
        public void execute(Input input, Tracker tracker) {
            System.out.println("***Find items by Name Start***");
            String name = input.ask("Input Item name:");
            Item[] items = tracker.findByName(name);
            if (items.length == 0) {
                throw new ItemNotFoundException("Items not found");
            } else {
                for (Item item : items) {
                    System.out.println(String.format("%s%s %s%s %s%s", "Item found ID=", item.getId(), "Name=", item.getName(), "Description=", item.getDescription()));
                }
            }
        }
        /**
         * Method info. Отображение информации об операции.
         * @return Информация об операции.
         */
        public String info() {
            return String.format("%s%s", this.key(), ". Find items by name");
        }
    }
    /**
     * Class Exit - Внутренний класс - Выход из трекера.
     */
    private class Exit implements UserAction {
        /**
         * Method key. Возврат номера операции.
         * @return Номер операции.
         */
        public int key() {
            return 6;
        }
        /**
         * Method execute. Выполнение действия.
         * @param input Ввод-вывод.
         * @param tracker Трекер.
         */
        public void execute(Input input, Tracker tracker) {
            System.out.println("***EXIT***");
        }
        /**
         * Method info. Отображение информации об операции.
         * @return Информация об операции.
         */
        public String info() {
            return String.format("%s%s", this.key(), ". Exit Program");
        }
    }
}
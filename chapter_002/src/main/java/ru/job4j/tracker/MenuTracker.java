package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;
/**
 * Class ReplaceItem - Внешний класс - Редактирование заявки в трекере.
 */
class ReplaceItem extends BaseAction {
    /**
     * Method ReplaceItem. Конструктор.
     * @param key Значение ключа меню.
     * @param name Название действия меню.
     */
    public ReplaceItem(int key, String name) {
        super(key, name);
    }
    /**
     * Method execute. Выполнение действия.
     * @param input Ввод-вывод.
     * @param tracker Трекер.
     */
    @Override
    public void execute(Input input, ITracker tracker) {
        System.out.println("***Edit item Start***");
        String id = input.ask("Input Item ID:");
        String name = input.ask("Input New Item Name:");
        String description = input.ask("Input New Item Description:");
        Item item = new Item(name, description);
        if (!tracker.replace(id, item)) {
            System.out.println("***Item not found***");
        } else {
            System.out.println("***Item edited successfully***");
        }
    }
}
/**
 * Class DeleteItem - Внешний класс - Удаление заявки из трекера.
 */
class DeleteItem extends BaseAction {
    /**
     * Method DeleteItem. Конструктор.
     * @param key Значение ключа меню.
     * @param name Название действия меню.
     */
    public DeleteItem(int key, String name) {
        super(key, name);
    }
    /**
     * Method execute. Выполнение действия.
     * @param input Ввод-вывод.
     * @param tracker Трекер.
     */
    public void execute(Input input, ITracker tracker) {
        System.out.println("***Delete item Start***");
        String id = input.ask("Input Item ID:");
        if (!tracker.delete(id)) {
            System.out.println("***Item not found***");
        } else {
            System.out.println("***Item deleted successfully***");
        }
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
    private ITracker tracker;
    private ArrayList<UserAction> actions = new ArrayList<>();
    private int position = 0;
    /**
     * Method MenuTracker. Конструктор.
     * @param input Ввод-вывод.
     * @param tracker Трекер.
     */
    public MenuTracker(Input input, ITracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Method getKeyInAvailableList. Получение списка доступных ключей.
     * @return Массив доступных ключей
     */
    public List<Integer> getKeyInAvailableList() {
        ArrayList<Integer> result = new ArrayList<>();
        for (UserAction key : this.actions) {
            result.add(key.key());
        }
        return result;
    }
    /**
     * Method fillActions. Заполнение стека операций трекера.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(this.position++, this.new AddItem(0, ". Add new Item"));
        this.actions.add(this.position++, this.new ShowAllItems(1, ". Show all items"));
        this.actions.add(this.position++, new ReplaceItem(2, ". Edit item"));
        this.actions.add(this.position++, new DeleteItem(3, ". Delete item"));
        this.actions.add(this.position++, this.new FindItemById(4, ". Find item by Id"));
        this.actions.add(this.position++, this.new FindItemsByName(5, ". Find items by name"));
        this.actions.add(this.position++, this.new Exit(6, ". Exit Program", ui));
        this.actions.add(this.position++, new UserAction() {
            @Override
            public int key() {
                return 7;
            }
            @Override
            public void execute(Input input, ITracker tracker) {
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
        });
    }
    /**
     * Method show. Заполнение информация об операции.
     */
    public void show() {
        System.out.println("TRACKER MENU");
        for (int i = 0; i < this.actions.size(); i++) {
            if (this.actions.get(i) != null) {
                System.out.println(this.actions.get(i).info());
            }
        }
    }
    /**
     * Method select. Выбор операции.
     * @param key Код операции.
     */
    public void select(int key) {
        int checkedKey = -1;
        if (getKeyInAvailableList().contains(key)) {
            checkedKey = key;
        } else {
            System.out.println("Wrong menu key");
        }
        if (this.actions.get(checkedKey) != null && checkedKey != -1) {
            this.actions.get(checkedKey).execute(this.input, this.tracker);
        }
    }
    /**
     * Class AddItem - Внутренний класс - Добавление заявки в трекер.
     */
    private class AddItem extends BaseAction {
        /**
         * Method AddItem. Конструктор.
         * @param key Значение ключа меню.
         * @param name Название действия меню.
         */
        public AddItem(int key, String name) {
            super(key, name);
        }
        /**
         * Method execute. Выполнение действия.
         * @param input Ввод-вывод.
         * @param tracker Трекер.
         */
        public void execute(Input input, ITracker tracker) {
            System.out.println("***Add new item Start***");
            String name = input.ask("Input Item Name:");
            String description = input.ask("Input Item Description:");
            tracker.add(new Item(name, description));
        }
    }
    /**
     * Class ShowAllItems - Внутренний класс - Отображение всех заявок трекера.
     */
    private class ShowAllItems extends BaseAction {
        /**
         * Method ShowAllItems. Конструктор.
         * @param key Значение ключа меню.
         * @param name Название действия меню.
         */
        public ShowAllItems(int key, String name) {
            super(key, name);
        }
        /**
         * Method execute. Выполнение действия.
         * @param input Ввод-вывод.
         * @param tracker Трекер.
         */
        public void execute(Input input, ITracker tracker) {
            System.out.println("***Items list:***");
            ArrayList<Item> items = tracker.findAll();
            if (items.size() == 0) {
                System.out.println("Items not found");
            } else {
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i) != null) {
                        System.out.println(String.format("%s%s %s%s %s%s", "Item ID=", items.get(i).getId(), "Name=", items.get(i).getName(), "Description=", items.get(i).getDescription()));
                    }
                }
            }
        }
    }
    /**
     * Class FindItemById - Внутренний класс - Поиск заявки по ID.
     */
    private class FindItemById extends BaseAction {
        /**
         * Method FindItemById. Конструктор.
         * @param key Значение ключа меню.
         * @param name Название действия меню.
         */
        public FindItemById(int key, String name) {
            super(key, name);
        }
        /**
         * Method execute. Выполнение действия.
         * @param input Ввод-вывод.
         * @param tracker Трекер.
         */
        public void execute(Input input, ITracker tracker) {
            System.out.println("***Find item by ID Start***");
            String id = input.ask("Input Item ID:");
            Item item = tracker.findById(id);
            if (item.equals(new Item())) {
                System.out.println("Item not found");
            } else {
                System.out.println(String.format("%s%s %s%s %s%s", "Item found ID=", item.getId(), "Name=", item.getName(), "Description=", item.getDescription()));
            }
        }
    }
    /**
     * Class FindItemsByName - Внутренний класс - Поиск заявок по названию.
     */
    private class FindItemsByName extends BaseAction {
        /**
         * Method FindItemsByName. Конструктор.
         * @param key Значение ключа меню.
         * @param name Название действия меню.
         */
        public FindItemsByName(int key, String name) {
            super(key, name);
        }
        /**
         * Method execute. Выполнение действия.
         * @param input Ввод-вывод.
         * @param tracker Трекер.
         */
        public void execute(Input input, ITracker tracker) {
            System.out.println("***Find items by Name Start***");
            String name = input.ask("Input Item name:");
            ArrayList<Item> items = tracker.findByName(name);
            if (items.size() == 0) {
                System.out.println("Items not found");
            } else {
                for (Item item : items) {
                    System.out.println(String.format("%s%s %s%s %s%s", "Item found ID=", item.getId(), "Name=", item.getName(), "Description=", item.getDescription()));
                }
            }
        }
    }
    /**
     * Class Exit - Внутренний класс - Выход из трекера.
     */
    private class Exit extends BaseAction {
        private final StartUI su;
        //public Exit(StartUI su) {
        //    this.su = su;
        //}
        /**
         * Method Exit. Конструктор.
         * @param key Значение ключа меню.
         * @param name Название действия меню.
         */
        public Exit(int key, String name, StartUI su) {
            super(key, name);
            this.su = su;
        }
        /**
         * Method execute. Выполнение действия.
         * @param input Ввод-вывод.
         * @param tracker Трекер.
         */
        public void execute(Input input, ITracker tracker) {
            System.out.println("***EXIT***");
            this.su.stop();
        }
    }
}
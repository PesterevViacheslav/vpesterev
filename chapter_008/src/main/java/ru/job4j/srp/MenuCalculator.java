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
    private Double number;
    private HashMap<String, UserAction> actions = new HashMap<>();
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
     * Method fillActions. Заполнение стека операций.
     */
    public void fillActions(InteractCalc ui) {
        this.actions.put("+", new UserAction() {
            @Override
            public String key() {
                return "+";
            }
            @Override
            public void execute(Scanner in, Calculator calculator) {
                System.out.println("Input digit");
                Double d = in.nextDouble();
                calculator.add(number, d);
                number = calculator.getResult();
            }
            @Override
            public String info() {
                return String.format("%s%s", this.key(), " => Add");
            }
        });
        this.actions.put("-", new UserAction() {
            @Override
            public String key() {
                return "-";
            }
            @Override
            public void execute(Scanner in, Calculator calculator) {
                System.out.println("Input digit");
                Double d = in.nextDouble();
                calculator.minus(number, d);
                number = calculator.getResult();
            }
            @Override
            public String info() {
                return String.format("%s%s", this.key(), " => Minus");
            }
        });
        this.actions.put("*", new UserAction() {
            @Override
            public String key() {
                return "*";
            }
            @Override
            public void execute(Scanner in, Calculator calculator) {
                System.out.println("Input digit");
                Double d = in.nextDouble();
                calculator.multiply(number, d);
                number = calculator.getResult();
            }
            @Override
            public String info() {
                return String.format("%s%s", this.key(), " => Multiply");
            }
        });
        this.actions.put("/", new UserAction() {
            @Override
            public String key() {
                return "/";
            }
            @Override
            public void execute(Scanner in, Calculator calculator) {
                System.out.println("Input digit");
                Double d = in.nextDouble();
                calculator.divide(number, d);
                number = calculator.getResult();
            }
            @Override
            public String info() {
                return String.format("%s%s", this.key(), " => Divide");
            }
        });
        this.actions.put("=", new UserAction() {
            @Override
            public String key() {
                return "=";
            }
            @Override
            public void execute(Scanner in, Calculator calculator) {
                System.out.println(String.format("%s%s", "=", number.toString()));
            }
            @Override
            public String info() {
                return String.format("%s%s", this.key(), " => Result");
            }
        });
        this.actions.put("exit", new Exit("exit", ui));
    }
    /**
     * Class Exit - Выход из программы.
     */
    private class Exit extends BaseUserAction {
        private final InteractCalc calc;
        /**
         * Method Exit. Конструктор.
         * @param key Значение ключа меню.
         */
        public Exit(String key, InteractCalc calc) {
            super(key);
            this.calc = calc;
        }
        /**
         * Method execute. Выполнение действия.
         * @param in Ввод-вывод.
         * @param calculator Калькулятор.
         */
        @Override
        public void execute(Scanner in, Calculator calculator) {
            System.out.println("EXIT");
            this.calc.stop();
        }
        @Override
        public String info() {
            return String.format("%s%s", this.key(), " => Exit");
        }
    }
}
package ru.job4j.srp;
import ru.job4j.calculator.Calculator;
import java.util.Scanner;
/**
 * Class InteractCalc - Интерфейс с калькулятором. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.10.2019
 * @version 1
 */
public class InteractCalc {

    private Calculator calculator;
    private Scanner in;
    private boolean work = true;
    /**
     * Method InteractCalc. Конструктор.
     * @param calculator
     */
    public InteractCalc(Calculator calculator) {
        this.calculator = calculator;
        this.in = new Scanner(System.in);
    }
    /**
     * Method InteractCalc. Конструктор.
     * @param calculator
     * @param in Входной поток
     */
    public InteractCalc(Calculator calculator, Scanner in) {
        this.calculator = calculator;
        this.in = in;
    }

    /**
     * Method getIn. Получение потока ввода/вывода
     * @return Поток ввода/вывода.
     */
    public Scanner getIn() {
        return in;
    }
    /**
     * Method stop. Прекращение работы.
     */
    public void stop() {
        this.work = false;
    }
    /**
     * Method start. Запуск интерфейса калькулятора
     */
    public void start(MenuCalculator menu) {
        String key;
        Double n;
        //menu.fillActions(this);
        menu.show();
        System.out.println("Enter digit:");
        n = in.nextDouble();
        do {
            System.out.println("Enter operation:");
            key = in.next();
            n = menu.select(key, n);
        } while (this.work);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        InteractCalc interactCalc = new InteractCalc(calculator);
        MenuCalculator menu = new MenuCalculator(interactCalc.getIn(), calculator);
        menu.addActions(new UserAction() {
            @Override
            public String key() {
                return "+";
            }
            @Override
            public void execute(Scanner in, Calculator calculator) {
                System.out.println("Input digit");
                Double d = in.nextDouble();
                calculator.add(menu.number, d);
                menu.number = calculator.getResult();
            }
            @Override
            public String info() {
                return String.format("%s%s", this.key(), " => Add");
            }
        });
        menu.addActions(new UserAction() {
            @Override
            public String key() {
                return "=";
            }
            @Override
            public void execute(Scanner in, Calculator calculator) {
                System.out.println(String.format("%s%s", "=", menu.number.toString()));
            }
            @Override
            public String info() {
                return String.format("%s%s", this.key(), " => Result");
            }
        });
        menu.addActions(new Exit("exit", interactCalc));
        interactCalc.start(menu);
    }
    /**
     * Class Exit - Выход из программы.
     */
    private static class Exit extends BaseUserAction {
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
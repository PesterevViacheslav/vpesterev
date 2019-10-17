package ru.job4j;
import com.google.common.base.Joiner;
import org.junit.Test;
import ru.job4j.calculator.Calculator;
import ru.job4j.srp.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TestInteractCalc - Автотест Интерфейс с калькулятором. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.10.2019
 * @version 1
 */
public class TestInteractCalc {
    private static final String SEPARATOR = System.getProperty("line.separator");
    /**
     * Тест калькулятора.
     */
    @Test
    public void testCalculator() {
        String[] in = new String[] {"1", "+", "5", "-", "2", "*", "10", "/", "4", "=", "exit"};
        String inList = Joiner.on(SEPARATOR).join(in);
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(inList.getBytes()))) {
            Calculator calculator = new Calculator();
            InteractCalc interactCalc = new InteractCalc(calculator, scanner);
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
                    calculator.add(menu.getNumber(), d);
                    menu.setNumber(calculator.getResult());
                }
                @Override
                public String info() {
                    return String.format("%s%s", this.key(), " => Add");
                }
            });
            menu.addActions(new UserAction() {
                @Override
                public String key() {
                    return "-";
                }
                @Override
                public void execute(Scanner in, Calculator calculator) {
                    System.out.println("Input digit");
                    Double d = in.nextDouble();
                    calculator.minus(menu.getNumber(), d);
                    menu.setNumber(calculator.getResult());
                }
                @Override
                public String info() {
                    return String.format("%s%s", this.key(), " => Minus");
                }
            });
            menu.addActions(new UserAction() {
                @Override
                public String key() {
                    return "/";
                }
                @Override
                public void execute(Scanner in, Calculator calculator) {
                    System.out.println("Input digit");
                    Double d = in.nextDouble();
                    calculator.divide(menu.getNumber(), d);
                    menu.setNumber(calculator.getResult());
                }
                @Override
                public String info() {
                    return String.format("%s%s", this.key(), " => Divide");
                }
            });
            menu.addActions(new UserAction() {
                @Override
                public String key() {
                    return "*";
                }
                @Override
                public void execute(Scanner in, Calculator calculator) {
                    System.out.println("Input digit");
                    Double d = in.nextDouble();
                    calculator.multiply(menu.getNumber(), d);
                    menu.setNumber(calculator.getResult());
                }
                @Override
                public String info() {
                    return String.format("%s%s", this.key(), " => Multiply");
                }
            });
            menu.addActions(new UserAction() {
                @Override
                public String key() {
                    return "=";
                }
                @Override
                public void execute(Scanner in, Calculator calculator) {
                    System.out.println(String.format("%s%s", "=", menu.getNumber().toString()));
                }
                @Override
                public String info() {
                    return String.format("%s%s", this.key(), " => Result");
                }
            });
            menu.addActions(new Exit("exit", interactCalc));
            interactCalc.start(menu);
            double result = calculator.getResult();
            double expected = 10D;
            assertThat(result, is(expected));
        }
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
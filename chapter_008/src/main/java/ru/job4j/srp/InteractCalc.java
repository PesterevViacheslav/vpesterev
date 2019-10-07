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
     * Method stop. Прекращение работы.
     */
    public void stop() {
        this.work = false;
    }
    /**
     * Method start. Запуск интерфейса калькулятора
     */
    public void start() {
        MenuCalculator menu = new MenuCalculator(this.in, this.calculator);
        String key;
        Double n;
        menu.fillActions(this);
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
        interactCalc.start();
    }
}
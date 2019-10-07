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
    Calculator calculator;
    Scanner in;
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
     * Method start. Запуск интерфейса калькулятора
     */
    public void start() {
        String operation = "START";
        System.out.println("OPERATIONS: +,-,*,/,=,stop - to stop calculation");
        System.out.println("Enter number:");
        double x = in.nextDouble();
        while (!operation.equals("stop")) {
            System.out.println("Enter operation:");
            operation = this.in.next();
            if (operation.equals("+")) {
                System.out.println("Enter number:");
                this.calculator.add(x, in.nextDouble());
                x = calculator.getResult();
            } else if (operation.equals("-")) {
                System.out.println("Enter number:");
                this.calculator.minus(x, in.nextDouble());
                x = calculator.getResult();
            } else if (operation.equals("*")) {
                System.out.println("Enter number:");
                this.calculator.multiply(x, in.nextDouble());
                x = calculator.getResult();
            } else if (operation.equals("/")) {
                System.out.println("Enter number:");
                this.calculator.divide(x, in.nextDouble());
                x = calculator.getResult();
            } else if (operation.equals("=")) {
                System.out.println(this.calculator.getResult());
            } else if (operation.equals("stop")) {
                System.out.println("STOP calculation");
            } else {
                System.out.println("Wrong operation:");
            }
        }
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        InteractCalc interactCalc = new InteractCalc(calculator);
        interactCalc.start();
    }
}
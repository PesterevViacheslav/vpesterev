package ru.job4j.srp;
import ru.job4j.calculator.Calculator;
/**
 * Class EngineerCalculator - Инженерный калькулятор. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 17.10.2019
 * @version 1
 */
public class EngineerCalculator extends Calculator {
    /**
     * Method sin. Значение Sin.
     */
    public void sin() {
        super.result = Math.sin(super.result);
    }
    /**
     * Method cos. Значение Cos.
     */
    public void cos() {
        super.result = Math.cos(super.result);
    }
    /**
     * Method tan. Значение Tan.
     */
    public void tan() {
        super.result = Math.tan(super.result);
    }
}
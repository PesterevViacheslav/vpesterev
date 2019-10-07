package ru.job4j.srp;
import ru.job4j.calculator.Calculator;
import java.util.Scanner;
/**
 * Interface UserAction - Действия пользователя. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.10.2019
 * @version 1
 */
public interface UserAction {
    String key();
    void execute(Scanner input, Calculator calculator);
    String info();
}
package ru.job4j;
import com.google.common.base.Joiner;
import org.junit.Test;
import ru.job4j.calculator.Calculator;
import ru.job4j.srp.InteractCalc;
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
        String[] in = new String[] {"1", "+", "5", "-", "2", "*", "10", "/", "4", "=", "stop"};
        String inList = Joiner.on(SEPARATOR).join(in);
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(inList.getBytes()))) {
            Calculator calculator = new Calculator();
            InteractCalc interactCalc = new InteractCalc(calculator, scanner);
            interactCalc.start();
            double result = calculator.getResult();
            double expected = 10D;
            assertThat(result, is(expected));
        }
    }
}
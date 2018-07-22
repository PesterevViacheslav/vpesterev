package ru.job4j.tracker;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Class TrackerTest Автотесты для задач Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 10.06.2018
 * @version 1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }
    @After
    public void loadSys() {
        System.setOut(this.out);
    }
    @Test
    public void whenInvalidDataFormatInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"wrong", "key"}));
        input.ask("Test question", new ArrayList<>());
        assertThat(this.mem.toString(), is(String.format("Wrong format menu key" + System.lineSeparator() + "Wrong menu key entered, try again..." + System.lineSeparator())));
    }
    @Test
    public void whenInvalidMenuKeyInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"10", "12"}));
        ArrayList<Integer> range = new ArrayList<>();
        input.ask("Test question", range);
        assertThat(this.mem.toString(), is("Wrong menu key" + System.lineSeparator() + "Wrong menu key entered, try again..." + System.lineSeparator()));
    }
}

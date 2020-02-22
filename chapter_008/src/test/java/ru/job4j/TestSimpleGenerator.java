package ru.job4j;
import org.junit.Test;
import ru.job4j.tdd.KeyNotFoundException;
import ru.job4j.tdd.NotAllKeysReplacedException;
import ru.job4j.tdd.SimpleGenerator;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TestSimpleGenerator - Автотест Генератор строки. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.11.2019
 * @version 1
 */
public class TestSimpleGenerator {
    SimpleGenerator simpleGenerator = new SimpleGenerator();
    /**
     * Тест генератора строки - все ключи использованы, лишних нет.
     */
    @Test
    public void whenAllKeysReplacedThenSuccess() {
        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("name", "Viacheslav");
        keyMap.put("subject", "you");
        assertThat(this.simpleGenerator.generate("I am a ${name}, Who are ${subject}?", keyMap), is("I am a Viacheslav, Who are you?"));
        keyMap.clear();
        keyMap.put("sos", "Ааа");
        assertThat(this.simpleGenerator.generate("Help, ${sos}, ${sos}, ${sos}", keyMap), is("Help, Ааа, Ааа, Ааа"));
    }
    /**
     * Тест генератора строки - все ключи использованы, лишних нет.
     */
    @Test(expected = NotAllKeysReplacedException.class)
    public void whenNotAllKeysReplacedThenException() {
        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("name", "Viacheslav");
        keyMap.put("subject", "you");
        keyMap.put("sos", "Ааа");
        assertThat(simpleGenerator.generate("I am a ${name}, Who are ${subject}?", keyMap), is("I am a Viacheslav, Who are you?"));
    }
    /**
     * Тест генератора строки - все ключи использованы, лишних нет.
     */
    @Test(expected = KeyNotFoundException.class)
    public void whenKeysRemainedThenException() {
        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("name", "Viacheslav");
        assertThat(simpleGenerator.generate("I am a ${name}, Who are ${subject}?", keyMap), is("I am a Viacheslav, Who are you?"));
    }
}
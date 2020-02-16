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
     /**
     * Тест генератора строки - все ключи использованы, лишних нет.
     */
    @Test
    public void whenAllKeysReplacedThenSuccess() {
        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("name", "Viacheslav");
        keyMap.put("subject", "you");
        SimpleGenerator simpleGenerator = new SimpleGenerator("I am a ${name}, Who are ${subject}?", keyMap);
        assertThat(simpleGenerator.generate(), is("I am a Viacheslav, Who are you?"));
        //keyMap.clear();
        //keyMap.put("sos", "Ааа");
        //SimpleGenerator simpleGenerator2 = new SimpleGenerator("Help, ${sos}, ${sos}, ${sos}", keyMap);
        //assertThat(simpleGenerator2.generate(), is("Help, Ааа, Ааа, Ааа"));
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
        SimpleGenerator simpleGenerator = new SimpleGenerator("I am a ${name}, Who are ${subject}?", keyMap);
        assertThat(simpleGenerator.generate(), is("I am a Viacheslav, Who are you?"));
    }
    /**
     * Тест генератора строки - все ключи использованы, лишних нет.
     */
    @Test(expected = KeyNotFoundException.class)
    public void whenKeysRemainedThenException() {
        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("name", "Viacheslav");
        SimpleGenerator simpleGenerator = new SimpleGenerator("I am a ${name}, Who are ${subject}?", keyMap);
        assertThat(simpleGenerator.generate(), is("I am a Viacheslav, Who are you?"));
    }
}
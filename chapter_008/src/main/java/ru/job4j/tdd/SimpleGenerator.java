package ru.job4j.tdd;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class SimpleGenerator - Генератор строки. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 11.02.2020
 * @version 1
 */
public class SimpleGenerator {
    private final Pattern keys = Pattern.compile("\\$\\{(.*?)\\}");
    /**
     * Method generate. Генерация строки
     * @return Собранная строка
     */
    public String generate(String template, Map<String, String> keysMap) {
        Matcher matcher = this.keys.matcher(template);
        Set<String> keys = new HashSet<>();
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String key = template.substring(start + 2, end - 1);
            if (!keysMap.containsKey(key)) {
                throw new KeyNotFoundException("Key not found");
            }
            template = matcher.replaceFirst(keysMap.get(key));
            keys.add(key);
            matcher = this.keys.matcher(template);
        }
        for (String s : keys) {
            keysMap.remove(s);
        }
        if (keysMap.size() > 0) {
            throw new NotAllKeysReplacedException("Not all keys used");
        }
        return template;
    }
}
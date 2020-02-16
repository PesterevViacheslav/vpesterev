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
    private String template;
    private Map<String, String> keysMap;
    private final Pattern keys;
    /**
     * Method SimpleGenerator. Конструктор
     * @param template Строка с ключами
     * @param keysMap Ключи
     */
    public SimpleGenerator(String template, Map<String, String> keysMap) {
        this.template = template;
        this.keysMap = keysMap;
        this.keys = Pattern.compile("\\$\\{(.*?)\\}");
    }
    /**
     * Method generate. Генерация строки
     * @return Собранная строка
     */
    public String generate() {
        Matcher matcher = this.keys.matcher(this.template);
        Set<String> keys = new HashSet<>();
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String key = this.template.substring(start + 2, end - 1);
            if (!this.keysMap.containsKey(key)) {
                throw new KeyNotFoundException("Key not found");
            }
            this.template = matcher.replaceFirst(this.keysMap.get(key));
            keys.add(key);
            matcher = this.keys.matcher(this.template);
        }
        for (String s : keys) {
            this.keysMap.remove(s);
        }
        if (this.keysMap.size() > 0) {
            throw new NotAllKeysReplacedException("Not all keys used");
        }
        return this.template;
    }
}
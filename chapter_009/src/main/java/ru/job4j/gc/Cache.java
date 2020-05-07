package ru.job4j.gc;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/**
 * Class Cache - Кеш на SoftReference. Решение задач уровня Junior. Части 005. Garbage Collection.
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.04.2020
 * @version 1
 */
public class Cache {
    private HashMap<String, SoftReference<Document>> map = new HashMap<>();
    /**
     * Method get. Получение из кеша
      * @param key Ключ
     * @return Документ
     */
    public Document get(String key) {
        SoftReference<Document> softRef = map.get(key);
        if (softRef == null) {
            return null;
        }
        if (softRef.get() == null) {
            put(key, new Document(key, new File(getClass().getClassLoader().getResource(key).getFile())));
            softRef = map.get(key);
        }
        return softRef.get();
    }
    /**
     * Method size. Получение размера кеша
     * @return Размер
     */
    public int size() {
        return map.size();
    }
    /**
     * Method put. Добавление в кеш
     * @param key Ключ
     * @param value Значение
     * @return Документ
     */
    public Document put(String key, Document value) {
        SoftReference<Document> softRef = map.put(key, new SoftReference(value));
        if (softRef == null) {
            return null;
        }
        Document oldValue = softRef.get();
        softRef.clear();
        return oldValue;
    }
    /**
     * Method remove. Удаление из кеша
     * @param key Ключ
     * @return Документ
     */
    public Document remove(String key) {
        SoftReference<Document> softRef = map.remove(key);
        if (softRef == null) {
            return null;
        }
        Document oldValue = softRef.get();
        softRef.clear();
        return oldValue;
    }
}
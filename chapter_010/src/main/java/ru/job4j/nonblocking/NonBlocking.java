package ru.job4j.nonblocking;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Class NonBlocking - Неблокирующий кеш. Решение задач уровня Middle. Части 001. Multithreading.
 * 10.5.1. Неблокирующий кеш.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 09.01.2019
 * @version 1
 */
public class NonBlocking {
    private ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap<>();
    /**
     * Метод size. Размер коллекции.
     * @return model Элемент.
     */
    public int size() {
        return this.cache.size();
    }
    /**
     * Метод get. Получение элемента коллекции.
     * @return Элемент.
     */
    public Base get(int id) {
        Base res = null;
        if (this.cache.containsKey(id)) {
            res = this.cache.get(id);
        }
        return res;
    }
    /**
     * Метод add. Добавление элемента в коллекцию.
     * @param model Элемент.
     */
    public void add(Base model) {
        cache.putIfAbsent(model.id, new Base(model.id, ++model.version));
    }
    /**
     * Метод update. Добавление элемента в коллекцию.
     * @param model Элемент.
     */
    public void update(Base model) {
        if (this.cache.computeIfPresent(model.id, (Integer k, Base v) -> {
               Base res = null;
               if (this.cache.get(model.id).version == model.version) {
                   res = new Base(model.id, ++model.version);
                   this.cache.put(model.id, res);
               }
               System.out.println("update");
               return res;
            }) == null) {
            throw new OptimisticException("updateOptimisticException");
        }
    }
    /**
     * Метод delete. Добавление элемента в коллекцию.
     * @param model Элемент.
     */
    public void delete(Base model) {
        if (this.cache.computeIfPresent(model.id, (Integer k, Base v) -> {
            Base res = null;
            if (this.cache.get(model.id).version == model.version) {
                res = new Base(model.id, ++model.version);
                this.cache.put(model.id, res);
                this.cache.remove(model.id);
            }
            System.out.println("delete");
            return res;
        }) == null) {
            throw new OptimisticException("deleteOptimisticException");
        }
    }
    /**
     * Класс - элемент кеша
     */
    public static class Base {
        int id;
        int version;
        public Base(int id) {
            this.id = id;
            this.version = 0;
        }
        public Base(int id, int version) {
            this.id = id;
            this.version = version;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Base base = (Base) o;
            return id == base.id && version == base.version;
        }
        @Override
        public int hashCode() {
            return Objects.hash(id, version);
        }
        @Override
        public String toString() {
            return "Base{" + "id=" + id + ", version=" + version + '}';
        }
    }
}
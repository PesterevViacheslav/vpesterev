package ru.job4j.nonblocking;
import java.util.Objects;
import java.util.Optional;
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
    private final ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap<>();
    /**
     * Метод size. Размер коллекции.
     * @return model Элемент.
     */
    public int size() {
        System.out.println("array=" + cache.toString());
        return this.cache.size();
    }
    /**
     * Метод get. Получение элемента коллекции.
     * @return Элемент.
     */
    public Base get(int id) {
        System.out.println("get id=" + id);
        Optional<Base> res = Optional.of(this.cache.get(id));
        return res.orElseGet(null);
    }
    /**
     *
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
            Base res = model;
            if (model.equals(v)) {
                res = new Base(model.id, ++model.version);
                this.cache.put(model.id, res);
            }
            System.out.println("update " + v.id + " " + Thread.currentThread().getName());
            return res;
        }).equals(model)) {
            throw new OptimisticException("updateOptimisticException");
        }
    }
    /**
     * Метод delete. Добавление элемента в коллекцию.
     * @param model Элемент.
     */
    public void delete(Base model) {
        if (this.cache.computeIfPresent(model.id, (Integer k, Base v) -> {
            Base res = model;
            if (model.equals(v)) {
                res = new Base(model.id, ++model.version);
                this.cache.remove(model.id);
            }
            System.out.println("delete " + v.id + " " + Thread.currentThread().getName());
            return res;
        }) != null) {
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
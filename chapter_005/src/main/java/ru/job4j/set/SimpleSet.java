package ru.job4j.set;
import ru.job4j.list.SimpleList;
import java.util.Iterator;

/**
 * Class SimpleSet - Множество. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.4.1. Реализовать коллекцию Set на массиве.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.11.2018
 * @version 1
 */
public class SimpleSet<E> implements Iterable<E> {
    private SimpleList<E> set;
    public SimpleSet() {
        this.set = new SimpleList<>();
    }
    void add(E date) {
        if (this.set.getNodeByData(date) == null) {
            this.set.add(date);
        }
    }
    /**
     * Method getSize. Получение размера коллекции.
     */
    public int getSize() {
        return this.set.getSize();
    }
    /**
     * Method iterator. Итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return this.set.iterator();
    }
}
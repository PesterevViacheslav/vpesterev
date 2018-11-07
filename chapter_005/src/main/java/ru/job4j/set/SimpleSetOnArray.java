package ru.job4j.set;
import ru.job4j.generic.SimpleArray;
import java.util.Iterator;
/**
 * Class SimpleSet - Множество. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.4.1. Реализовать коллекцию Set на массиве.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 07.11.2018
 * @version 1
 */
public class SimpleSetOnArray<E> implements Iterable<E> {
    private SimpleArray<E> set;
    /**
     * Method SimpleSetOnArray. Конструктор.
     * @param size Элемент.
     */
    public SimpleSetOnArray(int size) {
        this.set = new SimpleArray<>(size);
    }
    /**
     * Method add. Метод добавления в коллекцию.
     * @param data Элемент.
     */
    public void add(E data) {
        if (this.set.getPositionByData(data) == -1) {
            this.set.add(data);
        }
    }
    /**
     * Method getSize. Получение размера коллекции.
     * @return Размер коллекции.
     */
    public int getSize() {
        return this.set.getIndex();
    }
    /**
     * Method iterator. Итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return this.set.iterator();
    }
}
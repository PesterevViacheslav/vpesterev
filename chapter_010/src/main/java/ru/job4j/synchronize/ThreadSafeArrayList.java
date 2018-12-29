package ru.job4j.synchronize;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.SimpleArrayList;
import ru.job4j.list.SimpleContainer;
import java.util.Iterator;
/**
 * Class ThreadSafeArrayList - Потокобезопасный список. Решение задач уровня Middle. Части 001. Multithreading.
 * 10.3.3 ThreadSafe динамический список.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 28.12.2018
 * @version 1
 */
@ThreadSafe
public class ThreadSafeArrayList<E> implements SimpleContainer<E> {
    @GuardedBy("this")
    private SimpleArrayList<E> array;
    /**
     * Method ThreadSafeArrayList. Конструктор.
     * @param size Размер.
     */
    public ThreadSafeArrayList(int size) {
        array = new SimpleArrayList<>(size);
    }
    /**
     * Method add. Добавление в контейнер.
     * @param e Элемент.
     */
    @Override
    public synchronized void add(E e) {
        this.array.add(e);
    }
    /**
     * Method get. Поиск по индексу.
     * @param index Индекс.
     * @return Объект.
     */
    @Override
    public synchronized E get(int index) {
        return this.array.get(index);
    }
    /**
     * Method copy. Копирование контейнера.
     * @param list Контейнер.
     * @return Копия.
     */
    private synchronized SimpleArrayList<E> copy(SimpleArrayList<E> list) {
        SimpleArrayList<E> tmp = new SimpleArrayList<>(this.array.getSize());
        for (E e : list) {
            tmp.add(e);
        }
        return tmp;
    }
    /**
     * Method iterator. Итератор.
     * @return Итератор.
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return copy(this.array).iterator();
    }
}
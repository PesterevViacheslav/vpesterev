package ru.job4j.generic;
import java.util.Iterator;
import java.util.Objects;
/**
 * Class AbstractStore - Абстрактный контейнер. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.2.2. Реализовать Store<T extends Base>.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.10.2018
 * @version 1
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> array;
    /**
     * Method AbstractStore. Конструктор.
     * @param size Размер контейнера.
     */
    public AbstractStore(int size) {
        this.array = new SimpleArray<>(size);
    }
    /**
     * Method add. Добавление элемента в контейнер.
     * @param model Добавляемый объект.
     */
    @Override
    public void add(T model) {
        this.array.add(model);
    }
    /**
     * Method replace. Замена элемента в контейнере.
     * @param id ID объекта.
     * @param model Добавляемый объект.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean res = false;
        int pos = findPosition(id);
        if (pos != -1) {
            res = this.array.set(pos, model);
        }
        return res;
    }
    /**
     * Method delete. Удаление элемента в контейнере.
     * @param id Добавляемый объект.
     */
    @Override
    public boolean delete(String id) {
        boolean res = false;
        int pos = findPosition(id);
        if (pos != -1) {
            this.array.delete(findPosition(id));
        }
        return res;
    }
    /**
     * Method iterator. Итератор.
     * @return Итератор
     */
    public Iterator<T> iterator() {
        return this.array.iterator();
    }
    /**
     * Method findById. Поиск элемента по ID.
     * @param id ID.
     * @return ID
     */
    @Override
    public T findById(String id) {
        T result = null;
        for (int i = 0; i < this.array.getIndex(); i++) {
            if (id.equals((this.array.get(i).getId()))) {
                result = this.array.get(i);
                break;
            }
        }
        return result;
    }
    /**
     * Method findPosition. Поиск позиции элемента по ID.
     * @param id ID .
     * @return Позиция элемента
     */
    public int findPosition(String id) {
        int result = -1;
        for (int i = 0; i < this.array.getIndex(); i++) {
            if (id.equals(this.array.get(i).getId())) {
                result = i;
                break;
            }
        }
        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractStore<?> that = (AbstractStore<?>) o;
        return Objects.equals(array, that.array);
    }
    @Override
    public int hashCode() {
        return Objects.hash(array);
    }
    @Override
    public String toString() {
        return "AbstractStore{" + "array=" + array + '}';
    }
}
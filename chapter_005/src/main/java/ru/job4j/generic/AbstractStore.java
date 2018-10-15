package ru.job4j.generic;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class AbstractStore - Абстрактный контейнер. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.2.2. Реализовать Store<T extends Base>.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.10.2018
 * @version 1
 */
public abstract class AbstractStore implements Store {
    /**
     * Method replace. Замена элемента в контейнере.
     * @param id ID объекта.
     * @param model Добавляемый объект.
     * @param array Исходный массив
     */
    public <T extends Base> boolean replace(String id, T model, SimpleArray<T> array) {
        return array.set(findPosition(id, array), model);
    }
    /**
     * Method delete. Удаление элемента в контейнере.
     * @param id Добавляемый объект.
     * @param array Исходный массив
     */
    public <T extends Base> boolean delete(String id,  SimpleArray<T> array) {
        return array.delete(findPosition(id, array));
    }
    /**
     * Method get. Получение значения элемента из структуры.
     * @param id Индекс.
     * @param array Исходный массив
     */
    public <T extends Base> T get(String id, SimpleArray<T> array) {
        return array.get(findPosition(id, array));
    }
    /**
     * Method iterator. Итератор.
     * @param array Исходный массив
     * @return Итератор
     */
    public <T extends Base> Iterator<T> iterator(SimpleArray<T> array) {
        return array.iterator();
    }
    /**
     * Method findById. Поиск элемента по ID.
     * @param id ID.
     * @param array Исходный массив
     * @return ID
     */
    public <T extends Base> T findById(String id, SimpleArray<T> array) {
        T result = null;
        for (int i = 0; i < array.getIndex(); i++) {
            if (id.equals((array.get(i).getId()))) {
                result = array.get(i);
                break;
            }
        }
        return result;
    }
    /**
     * Method findPosition. Поиск позиции элемента по ID.
     * @param id ID .
     * @return Позиция элемента
     * @param array Исходный массив
     */
    public <T extends Base> int findPosition(String id, SimpleArray<T> array) {
        int result = -1;
        for (int i = 0; i < array.getIndex(); i++) {
            if (id.equals(array.get(i).getId())) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new NoSuchElementException();
        }
        return result;
    }
}
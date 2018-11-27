package ru.job4j.tree;
import java.util.Optional;
/**
 * Interface SimpleTreeContainer - Контейнер дерева. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.6.1. Создать элементарную структуру дерева.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.11.2018
 * @version 1
 */
public interface SimpleTreeContainer<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Метод add. Добавление элемента child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return
     */
    boolean add(E parent, E child);
    /**
     * Метод findBy. Поиск элемента в дереве по значению.
     * @param value Значение.
     * @return Элемент.
     */
    Optional<Node<E>> findBy(E value);
}
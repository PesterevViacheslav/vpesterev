package ru.job4j.tree;
import java.util.*;
/**
 * Class SimpleTree - Дерево. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.6.1. Создать элементарную структуру дерева.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.11.2018
 * @version 1
 */
public class SimpleTree<E extends Comparable<E>> implements SimpleTreeContainer<E> {
    private Node<E> root;
    private int modCount = 0;
    /**
     * Метод SimpleTree. Конструктор.
     * @param root Корневой элемент.
     */
    public SimpleTree(Node<E> root) {
        this.root = root;
    }
    /**
     * Метод add. Добавление элемента child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean res = false;
        Optional<Node<E>> op;
        Optional<Node<E>> ch;
        op = findBy(parent);
        ch = findBy(child);
        if (op.isPresent() && !ch.isPresent()) {
            Node<E> node = new Node<>(child);
            if (op.get().add(node)) {
                res = true;
                modCount++;
            }
        }
        return res;
    }
    /**
     * Метод findBy. Поиск элемента в дереве по значению.
     * @param value Значение.
     * @return Элемент.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }
    /**
     * Метод getRoot. Получение корневого элемента.
     * @return Элемент.
     */
    public Node<E> getRoot() {
        return this.root;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Queue<Node<E>> queue = new LinkedList<>(Collections.singletonList(root));
            private int size = queue.size();
            private int nextIndex = 0;
            int expectedModCount = modCount;
            /**
             * Method hasNext. Проверка наличия следующего элемента.
             * @return Наличие элемента.
             */
            @Override
            public boolean hasNext() {
                return this.nextIndex < this.size;
            }
            /**
             * Method next. Получение следующего элемента массива.
             * @return Элемент.
             */
            @Override
            public E next() {
                if (modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.nextIndex++;
                this.size += this.queue.element().leaves().size();
                this.queue.addAll(this.queue.element().leaves());
                return this.queue.poll().getValue();
            }
        };
    }
}
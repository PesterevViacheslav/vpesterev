package ru.job4j.tree;

import java.util.Iterator;

/**
 * Class Tree - Дерево. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.6.2. Добавить метод boolean isBinary().
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.11.2018
 * @version 1
 */
public class Tree<E extends Comparable<E>> extends SimpleTree<E> {
    /**
     * Метод SimpleTree. Конструктор.
     * @param root Корневой элемент.
     */
    public Tree(Node<E> root) {
        super(root);
    }
    /**
     * Метод isBinary. Проверка дерева на бинарность.
     * @return root Корневой элемент.
     */
    public boolean isBinary() {
        boolean res = true;
        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            E value = it.next();
            if (this.findBy(value).get().leaves().size() > 2) {
                res = false;
                break;
            }
        }
        return res;
    }
}
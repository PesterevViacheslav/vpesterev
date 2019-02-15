package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

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
     * Метод isBinary. Проверка дерева на бинарность (поиск в ширину).
     * @return root Корневой элемент.
     */
    public boolean isBinary() {
        boolean res = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.getRoot());
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                res = false;
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return res;
    }
}
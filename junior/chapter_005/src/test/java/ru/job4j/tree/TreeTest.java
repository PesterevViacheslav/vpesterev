package ru.job4j.tree;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Class TreTest - Отображения. Автотесты для решения задач уровня Junior. Части 001. Collections. Pro.
 * 5.6.2. Добавить метод boolean isBinary().
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.11.2018
 * @version 1
 */
public class TreeTest {
    /**
     * Тест проверки дерева на бинарность (в дереве нет узлов с более чем двумя потомками).
     */
    @Test
    public void whenHaveNotMoreThenTwoChildThenBinary() {
        Tree<Integer> tree = new Tree(new Node(1));
        assertTrue(tree.add(1, 2));
        assertTrue(tree.add(1, 3));
        assertTrue(tree.add(2, 4));
        assertTrue(tree.add(4, 5));
        assertTrue(tree.add(4, 6));
        assertTrue(tree.isBinary());
    }
    /**
     * Тест проверки дерева на бинарность (в дереве есть узлы с более чем двумя потомками).
     */
    @Test
    public void whenHaveMoreThenTwoChildThenBinary() {
        Tree<Integer> tree = new Tree(new Node(1));
        assertTrue(tree.add(1, 2));
        assertTrue(tree.add(1, 3));
        assertTrue(tree.add(1, 4));
        assertTrue(tree.add(4, 5));
        assertTrue(tree.add(4, 6));
        assertFalse(tree.isBinary());
    }
}
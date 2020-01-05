package ru.job4j.isp;
import java.util.TreeMap;
/**
 * Class Tree - Дерево меню. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.01.2019
 * @version 1
 */
public class Tree {
    private TreeMap<String, Node> tree;

    /**
     * Method Tree. Конструктор
     */
    public Tree() {
        this.tree = new TreeMap<>();
    }
    /**
     * Method add. Добавление узла
     * @param node Узел
     */
    public void add(Node node) {
        if (this.tree.containsKey(node.getParentId())) {
            this.tree.get(node.getParentId()).getChildList().put(node.getId(), node);
        }
        this.tree.put(node.getId(), node);
    }
    /**
     * Metod getTree Получение дерева
     * @return Дерево меню
     */
    public TreeMap<String, Node> getTree() {
        return this.tree;
    }
}
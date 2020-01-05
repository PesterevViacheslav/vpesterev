package ru.job4j.isp;
import java.util.HashMap;
import java.util.Objects;
/**
 * Class Node - Узел меню. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.01.2019
 * @version 1
 */
public class Node {
    private String id;
    private String parentId;
    private String title;
    private int level;
    private HashMap<String, Node> childList;

    /**
     * Method Node. Конструктор
     * @param id Id
     * @param parentId Id родителя
     * @param title Название пункта
     * @param level Уровень
     */
    public Node(String id, String parentId, String title, int level) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
        this.childList = new HashMap<>();
        this.level = level;
    }
    /**
     * Method getId. Метод получения ID
     * @return ID
     */
    public String getId() {
        return id;
    }
    /**
     * Method getParentId. Метод получения ID родителя
     * @return ID родителя
     */
    public String getParentId() {
        return parentId;
    }
    /**
     * Method getTitle. Метод получения названия
     * @return название
     */
    public String getTitle() {
        return title;
    }
    /**
     * Method getLevel. Метод получения уровня
     * @return уровень
     */
    public int getLevel() {
        return level;
    }
    /**
     * Method getChildList. Метод получения списка дочерних узлов
     * @return Список дочерних узлов
     */
    public HashMap<String, Node> getChildList() {
        return childList;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return level == node.level
            && Objects.equals(id, node.id)
            && parentId.equals(node.parentId)
            && Objects.equals(title, node.title);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, title, level);
    }
    @Override
    public String toString() {
        return "Node{"
               + "id='" + id + '\''
               + ", parentId='" + parentId + '\''
               + ", title='" + title + '\''
               + ", level=" + level
               + ", childList=" + childList
               + '}';
    }
}
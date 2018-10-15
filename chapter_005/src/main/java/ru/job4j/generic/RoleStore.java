package ru.job4j.generic;

import java.util.Iterator;
import java.util.Objects;

/**
 * Class UserStore - Контейнер для User. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.2.2. Реализовать Store<T extends Base>.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.10.2018
 * @version 1
 */
public class RoleStore extends AbstractStore {
    private SimpleArray<Role> roles;
    /**
     * Method RoleStore. Конструктор.
     * @param size Размер контейнера.
     */
    public RoleStore(int size) {
        this.roles = new SimpleArray<>(size);
    }
    /**
     * Method add. Добавление в контейнер.
     * @param model Добавляемый объект.
     */
    public void add(Base model) {
        this.roles.add((Role) model);
    }
    /**
     * Method replace. Замена элемента в контейнере.
     * @param id ID объекта.
     * @param model Добавляемый объект.
     */
    public boolean replace(String id, Base model) {
        return super.replace(id, (Role) model, this.roles);
    }
    /**
     * Method delete. Удаление элемента в контейнере.
     * @param id Добавляемый объект.
     */
    public boolean delete(String id) {
        return super.delete(id, this.roles);
    }
    /**
     * Method get. Получение элемента контейнера.
     * @param id ID объекта.
     */
    public Role get(String id) {
        return super.get(id, this.roles);
    }
    /**
     * Method iterator. Итератор.
     * @return Итератор
     */
    public Iterator<Role> iterator() {
        return super.iterator(this.roles);
    }
    /**
     * Method findById. Поиск элемента по ID.
     * @param id ID.
     * @return ID
     */
    public Role findById(String id) {
        return (Role) super.findById(id, this.roles);
    }
    /**
     * Method getRoles. Получение массива ролей.
     * @return Массив
     */
    public SimpleArray<Role> getRoles() {
        return roles;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleStore roleStore = (RoleStore) o;
        return Objects.equals(roles, roleStore.roles);
    }
    @Override
    public int hashCode() {
        return Objects.hash(roles);
    }
    @Override
    public String toString() {
        return "RoleStore{" + "roles=" + roles + '}';
    }
}
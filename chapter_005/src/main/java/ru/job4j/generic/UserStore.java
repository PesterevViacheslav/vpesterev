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
public class UserStore extends AbstractStore {
    private SimpleArray<User> users;
    /**
     * Method UserStore. Конструктор.
     * @param size Размер контейнера.
     */
    public UserStore(int size) {
        this.users = new SimpleArray<>(size);
    }
    /**
     * Method add. Добавление в контейнер.
     * @param model Добавляемый объект.
     */
    public void add(Base model) {
        this.users.add((User) model);
    }
    /**
     * Method replace. Замена элемента в контейнере.
     * @param id ID объекта.
     * @param model Добавляемый объект.
     */
    public boolean replace(String id, Base model) {
        return super.replace(id, (User) model, this.users);
    }
    /**
     * Method delete. Удаление элемента в контейнере.
     * @param id Добавляемый объект.
     */
    public boolean delete(String id) {
        return super.delete(id, this.users);
    }
    /**
     * Method get. Получение элемента контейнера.
     * @param id ID объекта.
     */
    public User get(String id) {
        return super.get(id, this.users);
    }
    /**
     * Method iterator. Итератор.
     * @return Итератор
     */
    public Iterator<User> iterator() {
        return super.iterator(this.users);
    }
    /**
     * Method findById. Поиск элемента по ID.
     * @param id ID.
     * @return ID
     */
    public User findById(String id) {
        return (User) super.findById(id, this.users);
    }
    /**
     * Method getUsers. Получение массива пользователей.
     * @return Массив
     */
    public SimpleArray<User> getUsers() {
        return users;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserStore userStore = (UserStore) o;
        return Objects.equals(users, userStore.users);
    }
    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
    @Override
    public String toString() {
        return "UserStore{" + "users=" + users + '}';
    }
}

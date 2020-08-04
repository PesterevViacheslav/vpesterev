package ru.job4j.synchronize;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
/**
 * Class UserStorage - Хранилище пользователей. Автотесты для решение задач уровня Middle. Части 011. Multithreading.
 * Синхронизация. 3. Класс хранилища пользователей UserStorage[#283085]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 01.08.2020
 * @version 1
 */
@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private HashMap<Integer, User> userHashMap;
    @GuardedBy("this")
    private int count = 0;
    /**
     * Метод UserStorage. Конструктор.
     */
    public UserStorage(int size) {
        this.userHashMap = new HashMap<>();
    }
    /**
     * Метод add. Добавление пользователя.
     * @param user Пользователь.
     */
    public synchronized boolean add(User user) {
        boolean res = false;
        if (this.userHashMap.put(user.id, user) == null) {
            res = true;
        }
        return res;
    }
    /**
     * Метод getSize. Получение размера коллеции.
     * @return Размер.
     */
    public synchronized int getSize() {
        return this.userHashMap.size();
    }
    /**
     * Метод update. Изменение пользователя.
     * @param user Пользователь.
     */
    public synchronized boolean update(User user) {
        this.userHashMap.put(user.id, user);
        return true;
    }
    /**
     * Метод delete. Удаление пользователя.
     * @param user Пользователь.
     */
    public synchronized boolean delete(User user) {
        boolean res = false;
        if (this.userHashMap.remove(user.id) != null) {
            res = true;
        }
        return res;
    }
    /**
     * Метод getTotalBalance. Получает сумму остатков на всех счетах
     * @return Возвращает общий баланс
     */
    public synchronized int getTotalBalance() throws InterruptedException {
        int sum = 0;
        this.count++;
        for (User u : this.userHashMap.values()) {
            sum += u.amount;
        }
        System.out.println("Total=" + sum + " " + Thread.currentThread() + " count=" + this.count);
        if (this.count >= 1000 || sum != 1000) {
            throw new InterruptedException();
        }
        return sum;
    }
    /**
     * Метод transfer. Перевод средств.
     * @param fromId Пользователь с которого переводят средства.
     * @param toId Пользователь на которого переводят средства.
     * @param amount Сумма.
     */
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean res = false;
        if (this.userHashMap.get(fromId).amount >= amount) {
            this.userHashMap.get(fromId).amount -= amount;
            System.out.println(Thread.currentThread() + " Перевод суммы " + amount + " со счета " + fromId + " на счет " + toId);
            this.userHashMap.get(toId).amount += amount;
            res = true;
        }
        return res;
    }
    /**
     * Class User. Пользователь.
     */
    public static class User {
        int id;
        int amount;
        User(int id, int amount) {
            this.id = id;
            this.amount = amount;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }
        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
        @Override
        public String toString() {
            return "User{" + "id=" + id + ", amount=" + amount + '}';
        }
    }
}
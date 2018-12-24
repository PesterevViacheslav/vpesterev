package ru.job4j.synchronize;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.Objects;
/**
 * Class UserStorage - Хранилище пользователей. Решение задач уровня Junior. Части 002. Multithreading.
 * 6.3.2 Класс хранилища пользователей UserStorage.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 20.12.2018
 * @version 1
 */
@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private User[] array;
    @GuardedBy("this")
    private int size = 0;
    @GuardedBy("this")
    private int count = 0;
    /**
     * Метод UserStorage. Конструктор.
     */
    public UserStorage(int size) {
        this.array = new User[size];
    }
    /**
     * Метод add. Добавление пользователя.
     * @param user Пользователь.
     */
    public boolean add(User user) {
        boolean res = false;
        int id = getIDByUser(user);
        if (id < 0) {
            synchronized (this) {
                this.array[this.size] = user;
            res = true;
            size++;
            }
        }
        return res;
    }
    /**
     * Метод getSize. Получение размера коллеции.
     * @return Размер.
     */
    public synchronized int getSize() {
        return this.size;
    }
    /**
     * Метод update. Изменение пользователя.
     * @param user Пользователь.
     */
    public boolean update(User user) {
        boolean res = false;
        int id = getIDByUser(user);
        if (id >= 0) {
            synchronized (this) {
                this.array[id] = user;
            }
            res = true;
        }
        return res;
    }
    /**
     * Метод delete. Удаление пользователя.
     * @param user Пользователь.
     */
    public synchronized boolean delete(User user) {
        boolean res = false;
        int id = getIDByUser(user);
        if (this.size > 0 && id >= 0) {
            int positionTmp = 0;
            for (int i = 0; i < this.size; i++) {
                positionTmp++;
                if (this.array[i].equals(user)) {
                    res = true;
                    break;
                }
            }
            if (res) {
                this.size--;
                synchronized (this) {
                    System.arraycopy(this.array, positionTmp, this.array, positionTmp - 1, this.size - positionTmp + 1);
                }
            }
        }
        return res;
    }
    /**
     * Метод getIDByUser. Получение ID пользователя.
     * @return Пользователь.
     */
    public synchronized int getIDByUser(User user) {
        int id = -1;
        for (User u : this.array) {
            if (u != null && u.equals(user)) {
                id = u.id;
            }
        }
        return id;
    }
    /**
     * Метод getTotalBalance. Получает сумму остатков на всех счетах
     * @return Возвращает общий баланс
     */
    public synchronized int getTotalBalance() throws InterruptedException {
        int sum = 0;
        this.count++;
        for (User u : this.array) {
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
        if (this.array[fromId].amount >= amount) {
            this.array[fromId].amount -= amount;
            System.out.println(Thread.currentThread() + " Перевод суммы " + amount + " со счета " + fromId + " на счет " + toId);
            this.array[toId].amount += amount;
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
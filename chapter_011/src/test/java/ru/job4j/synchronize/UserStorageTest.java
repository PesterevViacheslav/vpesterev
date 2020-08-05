package ru.job4j.synchronize;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Class UserStorageTest - Хранилище пользователей. Автотесты для решение задач уровня Middle. Части 011. Multithreading.
 * Синхронизация. 3. Класс хранилища пользователей UserStorage[#283085]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 01.08.2020
 * @version 1
 */
public class UserStorageTest {
    /**
     * Тест добавления пользователя.
     */
    @Test
    public void testAddUpdateDeleteUser() {
        UserStorage storage = new UserStorage(10);
        assertThat(storage.add(new UserStorage.User(0, 101)), is(true));
        assertThat(storage.add(new UserStorage.User(0, 101)), is(false));
        assertThat(storage.add(new UserStorage.User(1, 102)), is(true));
        assertThat(storage.getSize(), is(2));
        assertThat(storage.update(new UserStorage.User(1, 1022)), is(true));
        assertThat(storage.getSize(), is(2));
        assertThat(storage.delete(new UserStorage.User(1, 1022)), is(true));
        assertThat(storage.delete(new UserStorage.User(1, 1022)), is(false));
        assertThat(storage.getSize(), is(1));
    }
    /**
     * Тест перевода средств.
     */
    @Test
    public void testTransfer() throws InterruptedException {
        UserStorage storage = new UserStorage(10);
        assertThat(storage.add(new UserStorage.User(0, 100)), is(true));
        assertThat(storage.add(new UserStorage.User(1, 100)), is(true));
        assertThat(storage.add(new UserStorage.User(2, 100)), is(true));
        assertThat(storage.add(new UserStorage.User(3, 100)), is(true));
        assertThat(storage.add(new UserStorage.User(4, 100)), is(true));
        assertThat(storage.add(new UserStorage.User(5, 100)), is(true));
        assertThat(storage.add(new UserStorage.User(6, 100)), is(true));
        assertThat(storage.add(new UserStorage.User(7, 100)), is(true));
        assertThat(storage.add(new UserStorage.User(8, 100)), is(true));
        assertThat(storage.add(new UserStorage.User(9, 100)), is(true));
        for (int i = 0; i < storage.getSize(); i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (storage.getTotalBalance() == 1000) {
                        int toAccount = (int) (storage.getSize() * Math.random());
                        storage.transfer(fromAccount, toAccount, 10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interrupt " + Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                }
            };
            Thread t = new Thread(r);
            t.setName("#" + i);
            t.start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
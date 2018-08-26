package ru.job4j.bank;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {
    @Test
    /**
     * Тест добавления новых пользователей
     */
    public void testAddNewUsers() {
        Bank bank = new Bank();
        User user = new User("User1", "0101 234567");
        bank.addUser(user);
        assertThat(user, is(bank.getUsers().get(0)));
        User user2 = new User("User2", "0102 234567");
        bank.addUser(user2);
        assertThat(user2, is(bank.getUsers().get(1)));
    }
    @Test
    /**
     * Тест добавления двух одинаковых пользователей
     */
    public void whenAddTwoSameUsersThenException() {
        boolean result = false;
        try {
            Bank bank = new Bank();
            User user = new User("User1", "0101 234567");
            bank.addUser(user);
            User user2 = new User("User1", "0101 234567");
            bank.addUser(user2);
        } catch (AlreadyExistsException aee) {
            result = true;
        }
        assertTrue(result);
    }
    @Test
    /**
     * Тест удаления пользователя
     */
    public void testDeleteUser() {
        Bank bank = new Bank();
        User user = new User("User1", "0101 234567");
        bank.addUser(user);
        assertThat(user, is(bank.getUsers().get(0)));
        bank.deleteUser(user);
        assertThat(0, is(bank.getUsers().size()));
    }
    @Test
    /**
     * Тест добавления лицевых счетов
     */
    public void testAddUserAccounts() {
        Bank bank = new Bank();
        User user = new User("User1", "0101 234567");
        Account account = new Account(32, "Req1");
        Account account2 = new Account(32, "Req2");
        bank.addUser(user);
        assertThat(user, is(bank.getUsers().get(0)));
        bank.addAccountToUser(user, account);
        assertThat(account, is(bank.getUserAccount(user, "Req1")));
        bank.addAccountToUser(user, account2);
        assertThat(account2, is(bank.getUserAccount(user, "Req2")));
        assertThat(2, is(bank.getUserAccounts(user).size()));
    }
    @Test
    /**
     * Тест добавления одинаковых лицевых счетов
     */
    public void whenAddTwoSameUserAccountsThenException() {
        boolean result = false;
        try {
            Bank bank = new Bank();
            User user = new User("User1", "0101 234567");
            Account account = new Account(32, "Req1");
            Account account2 = new Account(32, "Req1");
            bank.addUser(user);
            assertThat(user, is(bank.getUsers().get(0)));
            bank.addAccountToUser(user, account);
            assertThat(account, is(bank.getUserAccount(user, "Req1")));
            bank.addAccountToUser(user, account2);
        } catch (AlreadyExistsException aee) {
            result = true;
        }
        assertTrue(result);
    }
    @Test
    /**
     * Тест удаления лицевых счетов
     */
    public void testDeleteUserAccounts() {
        Bank bank = new Bank();
        User user = new User("User1", "0101 234567");
        Account account = new Account(32, "Req1");
        Account account2 = new Account(32, "Req2");
        bank.addUser(user);
        assertThat(user, is(bank.getUsers().get(0)));
        bank.addAccountToUser(user, account);
        assertThat(account, is(bank.getUserAccount(user, "Req1")));
        bank.addAccountToUser(user, account2);
        assertThat(account2, is(bank.getUserAccount(user, "Req2")));
        assertThat(2, is(bank.getUserAccounts(user).size()));
        bank.deleteAccountFromUser(user, account2);
        assertNull(bank.getUserAccount(user, "Req2"));
        assertThat(1, is(bank.getUserAccounts(user).size()));
        bank.deleteAccountFromUser(user, account);
        assertNull(bank.getUserAccount(user, "Req1"));
        assertThat(0, is(bank.getUserAccounts(user).size()));
    }
    @Test
    /**
     * Тест перевода средств с одного пользователя на другого, баланс достаточен
     */
    public void testTransferFromUserToAnotherUser() {
        Bank bank = new Bank();
        User user = new User("User1", "0101 234567");
        User user2 = new User("User2", "0202 234567");
        Account account = new Account(100, "Req1");
        Account account2 = new Account(50, "Req2");
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user2, account2);
        assertTrue(bank.transferMoney(user, "Req1", user2, "Req2", 20));
        assertThat(80D, is(bank.getUserAccount(user, "Req1").getBalance()));
        assertThat(70D, is(bank.getUserAccount(user2, "Req2").getBalance()));
    }
    @Test
    /**
     * Тест перевода средств с одного пользователя на другого, баланс не достаточен
     */
    public void testTransferFromUserToAnotherUserLowBalance() {
        Bank bank = new Bank();
        User user = new User("User1", "0101 234567");
        User user2 = new User("User2", "0202 234567");
        Account account = new Account(10, "Req1");
        Account account2 = new Account(50, "Req2");
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user2, account2);
        assertFalse(bank.transferMoney(user, "Req1", user2, "Req2", 20));
        assertThat(10D, is(bank.getUserAccount(user, "Req1").getBalance()));
        assertThat(50D, is(bank.getUserAccount(user2, "Req2").getBalance()));
    }
    @Test
    /**
     * Тест перевода средств с пользователя на того же пользователя, баланс достаточен
     */
    public void testTransferFromUserToSameUser() {
        Bank bank = new Bank();
        User user = new User("User1", "0101 234567");
        Account account = new Account(100, "Req1");
        Account account2 = new Account(50, "Req2");
        bank.addUser(user);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user, account2);
        assertTrue(bank.transferMoney(user, "Req1", user, "Req2", 20));
        assertThat(80D, is(bank.getUserAccount(user, "Req1").getBalance()));
        assertThat(70D, is(bank.getUserAccount(user, "Req2").getBalance()));
    }
    @Test
    /**
     * Тест перевода средств с пользователя на того же пользователя, баланс не достаточен
     */
    public void testTransferFromUserToSameUserLowBalance() {
        Bank bank = new Bank();
        User user = new User("User1", "0101 234567");
        Account account = new Account(10, "Req1");
        Account account2 = new Account(50, "Req2");
        bank.addUser(user);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user, account2);
        assertFalse(bank.transferMoney(user, "Req1", user, "Req2", 20));
        assertThat(10D, is(bank.getUserAccount(user, "Req1").getBalance()));
        assertThat(50D, is(bank.getUserAccount(user, "Req2").getBalance()));
    }
}

package ru.job4j.bank;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Class Bank - Банк. Решение задачи Части 003. Collections. Lite.
 * Задача 5.2  Банковские переводы.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.08.2018
 * @version 1
 */
public class Bank {
    private HashMap<User, ArrayList<Account>> userAccounts = new HashMap<>();
    /**
     * Method addUser. Добавление пользователя.
     * @param user Пользователь.
     */
    public void addUser(User user) throws AlreadyExistsException {
        if (this.userAccounts.putIfAbsent(user, new ArrayList<>()) != null) {
            throw new AlreadyExistsException("Raise AlreadyExistsException");
        }
    }
    /**
     * Method getUsers. Получение списка пользователей.
     * @return Пользователи.
     */
    public ArrayList<User> getUsers() {
        ArrayList<User> result = new ArrayList<>();
        result.addAll(this.userAccounts.keySet());
        return result;
    }
    /**
     * Method deleteUser. Удаление пользователя.
     * @param user Пользователь.
     */
    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }
    /**
     * Method addAccountToUser. Добавление счета пользователю.
     * @param user Пользователь.
     * @param account ЛС
     */
    public void addAccountToUser(User user, Account account) throws AlreadyExistsException {
        if (this.userAccounts.get(user).indexOf(account) < 0) {
            this.userAccounts.get(user).add(account);
        } else {
            throw new AlreadyExistsException("Raise AlreadyExistsException");
        }
    }
    /**
     * Method deleteAccountFromUser. Удаление счета пользователю.
     * @param user Пользователь.
     * @param account ЛС
     */
    public void deleteAccountFromUser(User user, Account account) {
        this.userAccounts.get(user).remove(account);
    }
    /**
     * Method getUserAccounts. Получение лицевых счетов пользователю.
     * @param user Пользователь.
     * @return  Лицевые счета пользователя
     */
    public ArrayList<Account> getUserAccounts(User user) {
        return this.userAccounts.get(user);
    }
    /**
     * Method getUserAccount. Получение лицевого счета пользователю.
     * @param user Пользователь.
     * @param requisites Реквизиты ЛС.
     * @return  Лицевой счет пользователя
     */
    public Account getUserAccount(User user, String requisites) {
        Account result = null;
        int idx = this.userAccounts.get(user).indexOf(new Account(0, requisites));
        if (idx >= 0) {
            result = this.userAccounts.get(user).get(idx);
        }
        return result;
    }
    /**
     * Method transferMoney. Перевод средств.
     * @param srcUser С кого.
     * @param srcRequisite Реквизиты ЛС отправителя
     * @param dstUser На кого
     * @param dstRequisite Реквизиты ЛС получателя
     * @return  Успешность транзакции
     */
    public boolean transferMoney(User srcUser, String srcRequisite, User dstUser,  String dstRequisite, double amount) {
        boolean result = false;
        Account srcAccount = getUserAccount(srcUser, srcRequisite);
        Account dstAccount = getUserAccount(dstUser, dstRequisite);
        if (srcAccount != null && dstAccount != null) {
            result = srcAccount.transfer(dstAccount, amount);
        }
        return result;
    }
    @Override
    public String toString() {
        return "Bank{" + "accounts=" + this.userAccounts + "}";
    }
}
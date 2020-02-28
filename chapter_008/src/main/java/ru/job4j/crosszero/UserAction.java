package ru.job4j.crosszero;
/**
 * Class UserAction - Действия пунктов меню. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.02.2019
 * @version 1
 */
public abstract class UserAction implements MenuAction {
    private final String key;
    /**
     * Method UserAction Конструктор
     * @param key Ключ меню
     */
    public UserAction(final String key) {
        this.key = key;
    }
    /**
     * Method key Пункт меню
     * @return Ключ к пункту меню
     */
    @Override
    public String key() {
        return this.key;
    }
}
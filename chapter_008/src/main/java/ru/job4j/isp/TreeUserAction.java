package ru.job4j.isp;
/**
 * Class TreeUserAction - Действия пунктов меню. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 05.01.2019
 * @version 1
 */
public abstract class TreeUserAction implements MenuAction {
    private final String key;
    /**
     * Method TreeUserAction Конструктор
     * @param key Ключ меню
     */
    public TreeUserAction(final String key) {
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
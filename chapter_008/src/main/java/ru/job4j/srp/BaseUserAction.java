package ru.job4j.srp;
/**
 * Class BaseUserAction - Интерфейс с базовыми функциями калькулятора. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.10.2019
 * @version 1
 */
public abstract class BaseUserAction implements UserAction {
    private final String key;
    public BaseUserAction(final String key) {
        this.key = key;
    }
    @Override
    public String key() {
        return this.key;
    }
}
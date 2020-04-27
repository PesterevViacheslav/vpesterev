package ru.job4j.gc;
/**
 * Class BaseUserAction - Интерфейс с базовыми функциями калькулятора. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.10.2019
 * @version 1
 */
public abstract class BaseCacheAction implements CacheActions {
    private final String key;
    public BaseCacheAction(final String key) {
        this.key = key;
    }
    @Override
    public String key() {
        return this.key;
    }
}
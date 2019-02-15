package ru.job4j.generic;
import java.util.Objects;
/**
 * Class Base - Базовый класс. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.2.2. Реализовать Store<T extends Base>.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.10.2018
 * @version 1
 */
public abstract class Base {
    private final String id;
    /**
     * Method Base. Конструктор.
     * @param id ID.
     */
    protected Base(final String id) {
        this.id = id;
    }
    /**
     * Method getId. Получение ID объекта.
     * @return id.
     */
    public String getId() {
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return Objects.equals(id, base.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return "Base{" + "id='" + id + '\'' + '}';
    }
}
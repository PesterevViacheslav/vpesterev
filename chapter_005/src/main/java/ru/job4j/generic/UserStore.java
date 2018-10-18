package ru.job4j.generic;
/**
 * Class UserStore - Контейнер для User. Решение задач уровня Junior. Части 001. Collections. Pro.
 * 5.2.2. Реализовать Store<T extends Base>.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.10.2018
 * @version 1
 */
public class UserStore extends AbstractStore<User> {
    /**
     * Method UserStore. Конструктор.
     * @param size Размер контейнера.
     */
    public UserStore(int size) {
         super(size);
    }
}

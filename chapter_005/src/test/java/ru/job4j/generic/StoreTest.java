package ru.job4j.generic;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * Class StoreTest. Автотесты для задач уровня Junior. Части 001. Collections. Pro.
 * 5.2.2. Реализовать Store<T extends Base>.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.10.2018
 * @version 1
 */
public class StoreTest {
    /**
     * Тест наполнения контейнера значениями User.
     */
    @Test
    public void whenCreateUserReturnUser() {
        UserStore array = new UserStore(10);
        User user = new User("User0");
        array.add(user);
        assertThat(array.findById("User0"), is(user));
    }
    /**
     * Тест наполнения контейнера значениями Role.
     */
    @Test
    public void whenCreateRoleReturnRole() {
        RoleStore array = new RoleStore(10);
        Role role = new Role("Role0");
        array.add(role);
        assertThat(array.findById("Role0"), is(role));
    }
    /**
     * Тест переполнения контейнера User.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenOutOfBoundsThenThrowExceptionUser() {
        UserStore array = new UserStore(3);
        array.add(new User("User0"));
        array.add(new User("User1"));
        array.add(new User("User2"));
        array.add(new User("User3"));
    }
    /**
     * Тест переполнения контейнера Role.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenOutOfBoundsThenThrowExceptionRole() {
        RoleStore array = new RoleStore(3);
        array.add(new Role("Role0"));
        array.add(new Role("Role1"));
        array.add(new Role("Role2"));
        array.add(new Role("Role3"));
    }
    /**
     * Тест изменения элемента контейнера User.
     */
    @Test
    public void whenSetNewValueThenReturnNewValueUser() {
        UserStore array = new UserStore(3);
        array.add(new User("User0"));
        User user = new User("User2");
        assertFalse(array.replace("-1", user));
        assertTrue(array.replace("User0", user));
        assertThat(array.findById("User2"), is(user));
    }
    /**
     * Тест изменения элемента контейнера Role.
     */
    @Test
    public void whenSetNewValueThenReturnNewValueRole() {
        RoleStore array = new RoleStore(3);
        array.add(new Role("Role0"));
        Role role = new Role("Role2");
        assertFalse(array.replace("-1", role));
        assertTrue(array.replace("Role0", role));
        assertThat(array.findById("Role2"), is(role));
    }
    /**
     * Тест удаления элемента контейнера User.
     */
    @Test
    public void testDeleteElementUser() {
        UserStore expect = new UserStore(3);
        expect.add(new User("User0"));
        expect.add(new User("User2"));
        expect.add(new User("User2"));
        UserStore array = new UserStore(3);
        array.add(new User("User0"));
        array.add(new User("User1"));
        array.add(new User("User2"));
        assertFalse(array.delete("-1"));
        assertTrue(array.delete("User1"));
        assertThat(array, is(expect));
    }
    /**
     * Тест удаления элемента контейнера Role.
     */
    @Test
    public void testDeleteElementRole() {
        RoleStore expect = new RoleStore(3);
        expect.add(new Role("Role0"));
        expect.add(new Role("Role2"));
        expect.add(new Role("Role2"));
        RoleStore array = new RoleStore(3);
        array.add(new Role("Role0"));
        array.add(new Role("Role1"));
        array.add(new Role("Role2"));
        assertFalse(array.delete("-1"));
        assertTrue(array.delete("Role1"));
        assertThat(array, is(expect));
    }
    /**
     * Тест итератора контейнера User.
     */
    @Test(expected = NoSuchElementException.class)
    public void testUserIterator() {
        UserStore expect = new UserStore(3);
        User user0 = new User("User0");
        User user1 = new User("User1");
        User user2 = new User("User2");
        expect.add(user0);
        expect.add(user1);
        expect.add(user2);
        Iterator<User> it = expect.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(user0));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(user1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(user2));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
    /**
     * Тест итератора контейнера Role.
     */
    @Test(expected = NoSuchElementException.class)
    public void testRoleIterator() {
        RoleStore expect = new RoleStore(3);
        Role role0 = new Role("Role0");
        Role role1 = new Role("Role1");
        Role role2 = new Role("Role2");
        expect.add(role0);
        expect.add(role1);
        expect.add(role2);
        Iterator<Role> it = expect.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(role0));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(role1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(role2));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
    /**
     * Тест итератора контейнера со значением null.
     */
    @Test(expected = NoSuchElementException.class)
    public void testIntegerIteratorWithNull() {
        UserStore expect = new UserStore(3);
        User user0 = null;
        User user1 = new User("User1");
        User user2 = new User("User2");
        expect.add(user0);
        expect.add(user1);
        expect.add(user2);
        Iterator<User> it = expect.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(user0));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(user1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(user2));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
/**
 * Class ArrayDuplicateTest Автотесты для задач Части 001. Базовый синтаксис урок 6.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 07.04.2018
 * @version 1
 */
public class ArrayDuplicateTest {
    /**
     * Тест операции устранения дубликатов в массиве.
     */
    @Test
    public void checkRemoveDuplicateArray() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] p = {"One", "Two", "One", "Three", "Four", "Two", "One", "Four"};
        String[] result = {"One", "Two", "Three", "Four"};
        assertThat(result, is(arrayContainingInAnyOrder(array.remove(p))));
    }

    /**
     * Тест операции устранения дубликатов в массиве (одинаковые значения).
     */
    @Test
    public void checkRemoveDuplicateArraySameValues() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] p = {"One", "One", "One", "One", "One"};
        String[] result = {"One"};
        assertThat(result, is(arrayContainingInAnyOrder(array.remove(p))));
    }

    /**
     * Тест операции устранения дубликатов в массиве (одно значение).
     */
    @Test
    public void checkRemoveDuplicateArrayOneValues() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] p = {"One"};
        String[] result = {"One"};
        assertThat(result, is(arrayContainingInAnyOrder(array.remove(p))));
    }
    /**
     * Тест операции устранения дубликатов в массиве (дубликаты в начале).
     */
    @Test
    public void checkRemoveDuplicateArrayStart() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] p = {"One", "One", "Two"};
        String[] result = {"One", "Two"};
        assertThat(result, is(arrayContainingInAnyOrder(array.remove(p))));
    }
    /**
     * Тест операции устранения дубликатов в массиве (дубликаты в конце).
     */
    @Test
    public void checkRemoveDuplicateArrayEnd() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] p = {"One", "Three", "Two", "Two"};
        String[] result = {"One", "Three", "Two"};
        assertThat(result, is(arrayContainingInAnyOrder(array.remove(p))));
    }

    /**
     * Тест операции устранения дубликатов в массиве (дубликаты в середине).
     */
    @Test
    public void checkRemoveDuplicateArrayMiddle() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] p = {"One", "Three", "Three", "Two"};
        String[] result = {"One", "Three", "Two"};
        assertThat(result, is(arrayContainingInAnyOrder(array.remove(p))));
    }
}

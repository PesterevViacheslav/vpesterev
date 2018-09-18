package ru.job4j.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter. Решение задач уровня Junior. Части 001. Collections. Pro.
 * Задача 5.1.4. Создать convert(Iterator<Iterator>).
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 17.09.2018
 * @version 1
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> currentIterator = null;
            /**
             * Method hasNext. Проверка наличия следующего элемента.
             * @return Наличие элемента.
             */
            @Override
            public boolean hasNext() {
                getCurrentIterator();
                return (this.currentIterator != null && this.currentIterator.hasNext());
            }
            /**
             * Method next. Получение следующего элемента массива.
             * @return Элемент.
             */
            @Override
            public Integer next() {
                getCurrentIterator();
                if (this.currentIterator == null) {
                    throw new NoSuchElementException("NoSuchElementException");
                }
                return this.currentIterator.next();
            }
            /**
             * Method getCurrentIterator. Получение текущего итератора.
             */
            private void getCurrentIterator() {
                if (this.currentIterator != null && this.currentIterator.hasNext()) {
                    return;
                }
                currentIterator = null;
                while (it.hasNext()) {
                    Iterator<Integer> nextIterator = it.next();
                    if (nextIterator.hasNext()) {
                        this.currentIterator = nextIterator;
                        break;
                    }
                }
            }
        };
    }
}
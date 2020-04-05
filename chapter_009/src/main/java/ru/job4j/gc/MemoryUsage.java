package ru.job4j.gc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Class MemoryUsage - Тест GC. Решение задач уровня Junior. Части 005. Garbage Collection.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.03.2020
 * @version 1
 */
public class MemoryUsage {
    private static final Logger LOG = LogManager.getLogger(MemoryUsage.class.getName());
    public static class EmptyUser {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize EmptyUser");
        }
    }
    public static class User {
        private int aInt;
        private String name;
        public User(int aInt, String name) {
            this.aInt = aInt;
            this.name = name;
        }
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize User");
        }
    }
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.freeMemory();
        LOG.info(memory);
        User user = new User(12, "name");
        LOG.info(memory - runtime.freeMemory());
        user = null;
        System.gc();
        memory = runtime.freeMemory();
        LOG.info(memory);
        EmptyUser emptyUser = new EmptyUser();
        emptyUser = new EmptyUser();
        LOG.info(memory - runtime.freeMemory());
        System.gc();
        LOG.info(runtime.freeMemory());
    }
}
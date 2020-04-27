package ru.job4j;
import static org.junit.Assert.assertThat;
import com.google.common.base.Joiner;
import org.apache.commons.io.FileUtils;
import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.gc.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
/**
 * Class CacheManagerTest - Автотест Менеджера кеша. Решение задач уровня Junior. Части 009. Garbage Collection.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.04.2020
 * @version 1
 */
public class CacheManagerTest {
    private static final String SEPARATOR = System.getProperty("line.separator");
    /**
     * Тест менеджера кеша
     */
    @Test
    public void testCacheManager() {
        String[] in = new String[] {"+", "1", "+", "2", "+", "2", "+", "3", "+", "4", "+", "5", "-", "1", "-", "2", "-", "2", "exit"};
        String inList = Joiner.on(SEPARATOR).join(in);
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(inList.getBytes()))) {
            Cache cache = new Cache();
            CacheManager cacheManager = new CacheManager(cache, scanner);
            CacheMenu menu = new CacheMenu(cacheManager.getIn(), cache);
            menu.addActions(new CacheActions() {
                @Override
                public String key() {
                    return "+";
                }
                @Override
                public void execute(Scanner in, Cache cache) {
                    System.out.println("Add file to cache, number from 1 to 5");
                    int oper = in.nextInt();
                    String name = String.format("test%s.txt", Integer.toString(oper));
                    cache.put(name, new Document(Integer.toString(oper), new File(getClass().getClassLoader().getResource(name).getFile())));
                    System.out.println(cache.get(name));
                    try {
                        System.out.println(FileUtils.readFileToString(cache.get(name).getFile(), StandardCharsets.UTF_8));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public String info() {
                    return String.format("%s%s", this.key(), " => Add");
                }
            });
            menu.addActions(new CacheActions() {
                @Override
                public String key() {
                    return "-";
                }
                @Override
                public void execute(Scanner in, Cache cache) {
                    System.out.println("Delete file from cache, number from 1 to 5");
                    int oper = in.nextInt();
                    System.out.println(cache.remove(String.format("test%s.txt", Integer.toString(oper))));
                }
                @Override
                public String info() {
                    return String.format("%s%s", this.key(), " => Delete");
                }
            });
            menu.addActions(new Exit("exit", cacheManager));
            cacheManager.start(menu);
            assertThat(cache.size(), Is.is(3));
        }
    }
    /**
     * Class Exit - Выход из программы.
     */
    private static class Exit extends BaseCacheAction {
        private final CacheManager cacheManager;
        /**
         * Method Exit. Конструктор.
         * @param key Значение ключа меню.
         */
        public Exit(String key, CacheManager cache) {
            super(key);
            this.cacheManager = cache;
        }
        /**
         * Method execute. Выполнение действия.
         * @param in Ввод-вывод.
         * @param cache Калькулятор.
         */
        @Override
        public void execute(Scanner in, Cache cache) {
            System.out.println("EXIT");
            this.cacheManager.stop();
        }
        @Override
        public String info() {
            return String.format("%s%s", this.key(), " => Exit");
        }
    }
}
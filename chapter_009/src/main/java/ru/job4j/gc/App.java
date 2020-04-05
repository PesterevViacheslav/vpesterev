package ru.job4j.gc;
import java.io.*;
import java.util.*;
/**
 * Class App - Виды сборщиков мусора. Решение задач уровня Junior. Части 005. Garbage Collection.
 * -Xms512m -Xmx512m -XX:NewRatio=3 -XX:+UseSerialGC
 * -Xms512m -Xmx512m -XX:NewRatio=3 -XX:+UseParallelGC
 * -Xms512m -Xmx512m -XX:NewRatio=3 -XX:+UseConcMarkSweepGC
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 26.03.2020
 * @version 1
 */
public class App {
    private static List objects = new ArrayList<Byte>();
    private static boolean cont = true;
    private static String input;
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Method createObjects. Создание объектов
     */
    private static void createObjects() {
        System.out.println("Creating objects...");
        for (int i = 0; i < 100; i++) {
            objects.add(new Byte[10 * 1024]);
        }
    }
    /**
     * Method removeObjects. Удаление объектов
     */
    private static void removeObjects() {
        System.out.println("Removing objects...");
        int start = objects.size() - 1;
        int end = start - 100;
        for (int i = start; ((i >= 0) && (i > end)); i--) {
            objects.remove(i);
        }
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }
    public static void main(String[] args) throws Exception {
        while (cont) {
            System.out.println(objects.size() + " objects in use. What would you like me to do?\n"
                            + "1. Create some objects\n"
                            + "2. Remove some objects\n"
                            + "3. Run GC\n"
                            + "0. Quit");
            input = in.readLine();
            if ((input != null) && (input.length() >= 1)) {
                if (input.startsWith("0")) {
                    cont = false;
                } else if (input.startsWith("1")) {
                    createObjects();
                } else if (input.startsWith("2")) {
                    removeObjects();
                } else if (input.startsWith("3")) {
                    System.gc();
                }
            }
        }
    }
}
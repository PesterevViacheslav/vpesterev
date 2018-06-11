package ru.job4j.tracker;
import java.util.Scanner;
/**
 * Class ConsoleInput - Консольный ввод. Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.05.2018
 * @version 1
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    /**
     * Method ask. Получение ответа на вопрос из консоли.
     * @param question Вопрос.
     * @return Ответ
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    /**
     * Method ask. Получение ответа на вопрос из консоли.
     * @param question Вопрос.
     * @return Ответ
     */
    public int ask(String question, int[] range) {
        int key = MenuTracker.checkKeyInAvailableRangeList(Integer.valueOf(this.ask(question)), range);
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Menu out of range");
        }
    }
}
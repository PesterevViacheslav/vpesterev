package ru.job4j.tracker;
import java.util.List;

/**
 * Class StubInput - Эмуляция ввода данных. Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.05.2018
 * @version 1
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;
    /**
     * Method StubInput. Конструктор.
     * @param answers Ответы.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    /**
     * Method ask. Получение ответа на вопрос.
     * @param question Вопрос.
     * @return Ответ
     */
    public String ask(String question) {
        return answers[this.position++];
    }
    /**
     * Method ask. Получение ответа на вопрос.
     * @param question Вопрос.
     * @param range Допустимый диапазон вопросов.
     * @return Ответ
     */
    public int ask(String question, List<Integer> range) {
        int res = 6;
        if (this.answers.length > this.position) {
            try {
                res = Integer.parseInt(answers[this.position++]);
                    if (!range.contains(res)) {
                        System.out.println("Wrong menu key");
                        res = 6;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong format menu key");
                }
            }
        return res;
    }
}

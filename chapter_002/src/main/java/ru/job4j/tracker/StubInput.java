package ru.job4j.tracker;
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
     * Method StubInput. Конструктор.
     * @param question Вопрос.
     * @return Ответ
     */
    @Override
    public String ask(String question) {
        return answers[this.position++];
    }
}

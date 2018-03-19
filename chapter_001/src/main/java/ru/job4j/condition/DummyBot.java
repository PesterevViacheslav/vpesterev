package ru.job4j.condition;

/**
 * Class DummyBot решение задач Части 001. Базовый синтаксис урок 4.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 19.03.2018
 * @version 1
 */
public class DummyBot {

    /**
     * Method answer. Предоставление ответа на заданный вопрос.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String result = "Это ставит меня в тупик. Спросите другой вопрос.";
        if (question.equals("Привет, Бот.")) {
            result = "Привет, умник.";
        } else if (question.equals("Пока.")) {
            result = "До скорой встречи.";
        }
        return result;
    }
}




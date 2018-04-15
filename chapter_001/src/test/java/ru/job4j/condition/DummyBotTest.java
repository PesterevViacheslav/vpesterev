package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class DummyBotTest Автотесты для задач Части 001. Базовый синтаксис урок 4.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 19.03.2018
 * @version 1
 */
public class DummyBotTest {
    /**
     * Тест операции приветствия бота.
     */
    @Test
    public void whenGreetBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Привет, Бот."),
                is("Привет, умник.")
        );
    }
    /**
     * Тест операции прощания с ботом.
     */
    @Test
    public void whenByuBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Пока."),
                is("До скорой встречи.")
        );
    }
    /**
     * Тест операции задания неизвестного для бота вопроса.
     */
    @Test
    public void whenUnknownBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Сколько будет 2 + 2?"),
                is("Это ставит меня в тупик. Спросите другой вопрос.")
        );
    }
}
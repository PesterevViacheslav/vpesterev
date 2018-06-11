package ru.job4j.tracker;
/**
 * Class ValidateInput - Валидация ввода. Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 04.06.2018
 * @version 1
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Wrong menu key entered, try again...");
            } catch (NumberFormatException nfe) {
                System.out.println("Wrong data format entered, try again...");
            }
        } while (invalid);
        return value;
    }
}
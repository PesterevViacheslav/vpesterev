package ru.job4j.profession;
/**
 * Class Diagnose решение задачи Части 002. ООП урок 2.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 18.04.2018
 * @version 1
 */
public class Diagnose {
    private String description;
    private String prescription;

    /**
     * Method Diagnose. Конструктор.
     * @param description Диагноз;
     * @param prescription Рецепт.
     */
    public Diagnose(String description, String prescription) {
        this.description = description;
        this.prescription = prescription;
    };
    /**
     * Method getDescription. Получить значение диагноза.
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Method getPrescription. Получить значение рецепта.
     */
    public String getPrescription() {
        return this.prescription;
    }
}

package ru.job4j.calculator;
/**
 * Class Fit решение задачи Части 001. Базовый синтаксис урок 3.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 16.03.2018
 * @version 1
 */
public class Fit {
    /**
     * Коэффициент корректировки веса
     */
    private static final double WEIGHT_CORRECTION_COEFFICIENT = 1.15;
    /**
     * Коэффициент корректировки роста для мужчин
     */
    private static final int MAN_CM_COEFFICIENT = 100;
    /**
     * Коэффициент корректировки роста для женщин
     */
    private static final int WOMAN_CM_COEFFICIENT = 110;
    /**
     * Method manWeight. Идеальный вес для мужщины.
     * @param height Рост в сантиметрах.
     * @return Идеальный вес в кг.
     */
    public double manWeight(double height) {
        return (height - MAN_CM_COEFFICIENT) * WEIGHT_CORRECTION_COEFFICIENT;
    }
    /**
     * Method womanWeight. Идеальный вес для женщин.
     * @param height Рост в сантиметрах.
     * @return Идеальный вес в кг.
     */
    public double womanWeight(double height) {
        return (height - WOMAN_CM_COEFFICIENT) * WEIGHT_CORRECTION_COEFFICIENT;
    }
}
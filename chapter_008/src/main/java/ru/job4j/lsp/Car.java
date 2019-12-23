package ru.job4j.lsp;
/**
 * Class Car - Легковой автомобиль. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.12.2019
 * @version 1
 */
public class Car implements Vehicle {
    private String number;
    private float length;
    /**
     * Method Car. Конструктор
     */
    public Car() {
    }
    /**
     * Method Car. Конструктор
     * @param number Номер
     * @param length Длина
     */
    public Car(String number, float length) {
        this.number = number;
        this.length = length;
    }
    /**
     * Method getNumber. Получение номера машины.
     * @return Номер
     */
    @Override
    public String getNumber() {
        return this.number;
    }
    /**
     * Method drive. Движение.
     */
    @Override
    public float getLength() {
        return this.length;
    }
    @Override
    public String toString() {
        return "Car{" + "number='" + number + '\'' + '}';
    }
}
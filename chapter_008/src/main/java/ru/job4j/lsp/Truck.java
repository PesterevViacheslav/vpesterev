package ru.job4j.lsp;
/**
 * Class Truck - Грузовой автомобиль. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.12.2019
 * @version 1
 */
public class Truck implements Vehicle {
    private String number;
    private int tonnage;
    private float length;
    /**
     * Method Truck. Конструктор
    */
    public Truck() {
    }
    /**
     * Method Truck. Конструктор
     * @param number Номер
     * @param tonnage Грузоподъемность
     * @param length Длина
     */
    public Truck(String number, int tonnage, float length) {
        this.number = number;
        this.tonnage = tonnage;
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
        return "Truck{" + "number='" + number + '\'' + ", tonnage=" + tonnage + '}';
    }
}
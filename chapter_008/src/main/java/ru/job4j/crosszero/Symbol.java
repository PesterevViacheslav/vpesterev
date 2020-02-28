package ru.job4j.crosszero;
/**
 * Class Symbol - Символ. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.02.2019
 * @version 1
 */
public class Symbol {
    private String type; //X, O, _
    /**
     * Method Symbol. Конструктор
     * @param type
     */
    public Symbol(String type) {
        this.type = type;
    }
    /**
     * Method getType. Получение типа
     * @return Тип
     */
    public String getType() {
        return type;
    }

    /**
     * Method setType. Установка типа
     * @param type Тип
     */
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return type;
    }
}
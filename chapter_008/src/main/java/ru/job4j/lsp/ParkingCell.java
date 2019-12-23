package ru.job4j.lsp;
import java.util.Objects;
/**
 * Class ParkingCell - Ячейка парковки. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.12.2019
 * @version 1
 */
public class ParkingCell {
    private String cellType;
    private int cellRow;
    private int cellNumber;
    private String number;
    /**
     * Method ParkingCell. Конструктор
     * @param cellType Тип ячейки
     * @param cellRow Ряд
     * @param cellNumber Номер в ряду
     */
    public ParkingCell(String cellType, int cellRow, int cellNumber, String number) {
        this.cellType = cellType;
        this.cellRow = cellRow;
        this.cellNumber = cellNumber;
        this.number = number;
    }
    /**
     * Method getCellRow. Получение номера ряда ячейки
     * @return Номер ряда
     */
    public int getCellRow() {
        return this.cellRow;
    }
    /**
     * Method getCellNumber. Получение номера ячейки
     * @return Номер
     */
    public int getCellNumber() {
        return this.cellNumber;
    }
    /**
     * Method getNumber. Получение номера машины
     * @return number Номер авто
     */
    public String getNumber() {
        return number;
    }
    /**
     * Method setNumber. Установка номера машины
     * @param number Номер авто
     */
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingCell that = (ParkingCell) o;
        return cellRow == that.cellRow && cellNumber == that.cellNumber;
    }
    @Override
    public int hashCode() {
        return Objects.hash(cellRow, cellNumber);
    }
    @Override
    public String toString() {
        return "ParkingCell{" + "cellType='" + cellType + '\'' + ", cellRow=" + cellRow + ", cellNumber=" + cellNumber + ", number=" + number + '}';
    }
}
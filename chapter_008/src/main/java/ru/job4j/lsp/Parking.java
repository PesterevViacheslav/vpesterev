package ru.job4j.lsp;
import java.util.ArrayList;
/**
 * Class ParkingCell - Парковка. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 12.12.2019
 * @version 1
 */
public class Parking {
    private int rowsNumber;
    private int rowSize;
    private ArrayList<ParkingCell> cellList;
    /**
     * Method Parking. Конструктор
     * @param rowsNumber
     * @param rowSize
     */
    public Parking(int rowsNumber, int rowSize) {
        this.rowsNumber = rowsNumber;
        this.rowSize = rowSize;
        this.cellList = new ArrayList<>();
    }
    /**
     * Method init. Построение парковки
     */
    public void init() {
        ParkingCell parkingCell;
        for (int i = 0; i < this.rowsNumber; i++) {
            for (int j = 0; j < this.rowSize; j++) {
                parkingCell = new ParkingCell(i, j, "");
                if (j >= 0) {
                    parkingCell.setRightCellsCount(this.rowSize - j - 1);
                }
                if (j <= this.rowSize - 1) {
                    parkingCell.setLeftCellsCount(j);
                }
                this.cellList.add(parkingCell);
            }
        }
    }
    /**
     * Method doPark. Припарковать авто
     * @param vehicle Авто
     * @return Успех
     */
    private boolean doPark(Vehicle vehicle) {
        boolean res = false;
        int length = 0;
        for (ParkingCell cell : this.cellList) {
            if ("".equals(cell.getNumber()) && cell.getLeftCellsCount() + cell.getRightCellsCount() == vehicle.getSizeForCell() - 1
                || "".equals(cell.getNumber()) && cell.getLeftCellsCount() + cell.getRightCellsCount() >= vehicle.getSizeForCell() - 1) {
                for (int i = cell.getCellNumber() - 1; i >= 0; i--) {
                    if ("".equals(this.cellList.get(this.cellList.indexOf(new ParkingCell(cell.getCellRow(), i, ""))).getNumber())) {
                        this.cellList.get(this.cellList.indexOf(new ParkingCell(cell.getCellRow(), i, ""))).setRightCellsCount(-1);
                    }
                }
                for (int i = cell.getCellNumber(); i < this.rowSize; i++) {
                    if ("".equals(this.cellList.get(this.cellList.indexOf(new ParkingCell(cell.getCellRow(), i, ""))).getNumber())) {
                        if (length < vehicle.getSizeForCell()) {
                            this.cellList.get(this.cellList.indexOf(new ParkingCell(cell.getCellRow(), i, ""))).setLeftCellsCount(0);
                            this.cellList.get(this.cellList.indexOf(new ParkingCell(cell.getCellRow(), i, ""))).setRightCellsCount(0);
                            this.cellList.get(this.cellList.indexOf(new ParkingCell(cell.getCellRow(), i, ""))).setNumber(vehicle.getNumber());
                        } else {
                            this.cellList.get(this.cellList.indexOf(new ParkingCell(cell.getCellRow(), i, ""))).setLeftCellsCount(-1);
                        }
                    }
                    length++;
                }
                res = true;
                break;
            }
        }
        return res;
    }
    /**
     * Method parkAll. Припарковать очередь авто
     * @param vehicleList Очередь авто
     * @return Успех
     */
    public boolean parkAll(ArrayList<Vehicle> vehicleList) {
        boolean res = true;
        for (Vehicle v : vehicleList) {
            if (!doPark(v)) {
                res = false;
                break;
            }
        }
        return res;
    }
    /**
     * Method park. Получение состояния парковки
     * @return Список ячеек
     */
    public ArrayList<ParkingCell> getCellList() {
        for (ParkingCell cell : this.cellList) {
            System.out.println(cell);
        }
        return this.cellList;
    }
}
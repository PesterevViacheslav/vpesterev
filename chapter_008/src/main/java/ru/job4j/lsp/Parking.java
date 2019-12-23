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
    private int truckCellsNumber;
    private int allCellsNumber;
    private ArrayList<ParkingCell> cellList;
    private ArrayList<ParkingCell> freeCarCellList;
    private ArrayList<ParkingCell> freeTruckCellList;
    /**
     * Method Parking. Конструктор
     * @param rowsNumber
     * @param rowSize
     * @param truckCellsNumber
     */
    public Parking(int rowsNumber, int rowSize, int truckCellsNumber) {
        this.rowsNumber = rowsNumber;
        this.rowSize = rowSize;
        this.truckCellsNumber = truckCellsNumber;
        this.allCellsNumber = rowsNumber * rowSize;
        this.cellList = new ArrayList<>();
        this.freeCarCellList = new ArrayList<>();
        this.freeTruckCellList = new ArrayList<>();
    }
    /**
     * Method init. Построение парковки
     */
    public void init() {
        int truckCellCount = 0;
        int count = 0;
        ParkingCell parkingCell;
        for (int i = 0; i < this.rowsNumber; i++) {
            for (int j = 0; j < this.rowSize; j++) {
                if (Math.random() > 0.5 && truckCellCount < this.truckCellsNumber || this.allCellsNumber - count <= this.truckCellsNumber - truckCellCount) {
                    parkingCell = new ParkingCell( "Truck", i, j, null);
                    this.freeTruckCellList.add(parkingCell);
                    truckCellCount++;
                } else {
                    parkingCell = new ParkingCell("Car", i, j,null);
                    this.freeCarCellList.add(parkingCell);
                }
                this.cellList.add(parkingCell);
                count++;
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
        if (vehicle.getLength() < 5 && (!this.freeCarCellList.isEmpty())) {
            int id = this.cellList.indexOf(this.freeCarCellList.get(this.freeCarCellList.size() - 1));
            ParkingCell cell = this.cellList.get(id);
            cell.setNumber(vehicle.getNumber());
            this.cellList.set(id, cell);
            this.freeCarCellList.remove(this.freeCarCellList.size() - 1);
            res = true;
        } else if ((!this.freeTruckCellList.isEmpty() || this.freeCarCellList.size() > 1)) {
            if (!this.freeTruckCellList.isEmpty()) {
                int id = this.cellList.indexOf(this.freeTruckCellList.get(this.freeTruckCellList.size() - 1));
                ParkingCell cell = this.cellList.get(id);
                cell.setNumber(vehicle.getNumber());
                this.cellList.set(id, cell);
                this.freeTruckCellList.remove(this.freeTruckCellList.size() - 1);
                res = true;
            } else {
                for (int id = 0; id < this.freeCarCellList.size(); id++) {
                    if (id + 1 < this.freeCarCellList.size() && this.freeCarCellList.get(id).getNumber() == null && this.freeCarCellList.get(id + 1).getNumber() == null &&
                        this.freeCarCellList.get(id + 1).getCellRow() == this.freeCarCellList.get(id).getCellRow() &&
                        this.freeCarCellList.get(id + 1).getCellNumber() - this.freeCarCellList.get(id).getCellNumber() == 1) {
                        ParkingCell cell = this.freeCarCellList.get(id);
                        cell.setNumber(vehicle.getNumber());
                        int cellId1 = this.cellList.indexOf(this.freeCarCellList.get(id));
                        int cellId2 = this.cellList.indexOf(this.freeCarCellList.get(id + 1));
                        this.cellList.set(cellId1, cell);
                        this.cellList.set(cellId2, cell);
                        this.freeCarCellList.remove(id);
                        this.freeCarCellList.remove(id);
                        res = true;
                        break;
                    }
                }
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
        for(ParkingCell cell : this.cellList) {
            System.out.println(cell);
        }
        return this.cellList;
    }
}
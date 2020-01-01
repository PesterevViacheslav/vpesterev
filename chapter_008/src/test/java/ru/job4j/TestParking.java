package ru.job4j;
import org.junit.Test;
import ru.job4j.lsp.Car;
import ru.job4j.lsp.Parking;
import ru.job4j.lsp.Truck;
import ru.job4j.lsp.Vehicle;
import java.util.ArrayList;
import static org.junit.Assert.*;
/**
 * Class TestParking - Автотест Контроль качества продуктов. Решение задач уровня Junior. Части 004. ООД.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 02.11.2019
 * @version 1
 */
public class TestParking {
    /**
     * Тест размещения грузовых на местах грузовых и легковых.
     */
    @Test
    public void testParkAllTrucks() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Truck("truck_1_2", 5, 2));
        vehicles.add(new Truck("truck_2_3", 7, 3));
        vehicles.add(new Truck("truck_3_2", 8, 2));
        vehicles.add(new Truck("truck_4_4", 8, 4));
        vehicles.add(new Truck("truck_5_2", 9, 2));
        Parking parking = new Parking(2, 10);
        parking.init();
        assertTrue(parking.parkAll(vehicles));
    }
    /**
     * Тест размещения легковых на местах грузовых и легковых.
     */
    @Test
    public void testParkAllCars() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("car_1"));
        vehicles.add(new Car("car_2"));
        vehicles.add(new Car("car_3"));
        vehicles.add(new Car("car_4"));
        vehicles.add(new Car("car_5"));
        vehicles.add(new Car("car_6"));
        Parking parking = new Parking(2, 3);
        parking.init();
        assertTrue(parking.parkAll(vehicles));
    }
    /**
     * Тест размещения грузовых и легковых на местах грузовых и легковых.
     */
    @Test
    public void testParkAllTrucksAndCars() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Truck("truck_1_2", 5, 2));
        vehicles.add(new Truck("truck_2_3", 7, 3));
        vehicles.add(new Truck("truck_3_2", 8, 2));
        vehicles.add(new Truck("truck_4_4", 8, 4));
        vehicles.add(new Car("car_1"));
        vehicles.add(new Car("car_2"));
        vehicles.add(new Car("car_3"));
        vehicles.add(new Car("car_4"));
        Parking parking = new Parking(3, 10);
        parking.init();
        assertTrue(parking.parkAll(vehicles));
    }
    /**
     * Тест размещения грузовых на местах грузовых и легковых качества.
     */
    @Test
    public void testParkNotAllTrucksAndCars() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("car_1"));
        vehicles.add(new Truck("truck_1_2", 5, 2));
        vehicles.add(new Truck("truck_2_3", 7, 3));
        vehicles.add(new Car("car_2"));
        vehicles.add(new Truck("truck_3_5", 8, 5));
        vehicles.add(new Truck("truck_4_5", 8, 5));
        Parking parking = new Parking(2, 3);
        parking.init();
        assertFalse(parking.parkAll(vehicles));
    }
}
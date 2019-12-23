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
        vehicles.add(new Truck("г555гг99", 5, (float) 5.5));
        vehicles.add(new Truck("г555гг100", 7, (float) 7.5));
        vehicles.add(new Truck("г555гг101", 8, (float) 8.5));
        vehicles.add(new Truck("г555гг102", 8, (float) 8.5));
        vehicles.add(new Truck("г555гг103", 9, (float) 9.5));
        Parking parking = new Parking(2, 5, 3);
        parking.init();
        assertTrue(parking.parkAll(vehicles));
    }
    /**
     * Тест размещения легковых на местах грузовых и легковых.
     */
    @Test
    public void testParkAllCars() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("л555лл99", (float) 3.5));
        vehicles.add(new Car("л555лл100", (float) 4.5));
        vehicles.add(new Car("л555лл101", (float) 3.5));
        vehicles.add(new Car("л555лл102", (float) 4.2));
        vehicles.add(new Car("л555лл103", (float) 4.3));
        vehicles.add(new Car("л555лл104", (float) 4.0));
        Parking parking = new Parking(2, 3, 3);
        parking.init();
        assertTrue(parking.parkAll(vehicles));
    }
    /**
     * Тест размещения грузовых и легковых на местах грузовых и легковых.
     */
    @Test
    public void testParkAllTrucksAndCars() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Truck("г555гг99", 5, (float) 5.5));
        vehicles.add(new Truck("г555гг100", 7, (float) 7.5));
        vehicles.add(new Truck("г555гг101", 8, (float) 8.5));
        vehicles.add(new Truck("г555гг102", 8, (float) 8.5));
        vehicles.add(new Car("л555лл99", (float) 3.5));
        vehicles.add(new Car("л555лл100", (float) 4.5));
        vehicles.add(new Car("л555лл101", (float) 3.5));
        vehicles.add(new Car("л555лл102", (float) 4.5));
        Parking parking = new Parking(2, 7, 3);
        parking.init();
        assertTrue(parking.parkAll(vehicles));
    }
    /**
     * Тест размещения грузовых на местах грузовых и легковых качества.
     */
    @Test
    public void testParkNotAllTrucksAndCars() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("л555лл99", (float) 3.5));
        vehicles.add(new Truck("г555гг99", 5, (float) 5.5));
        vehicles.add(new Truck("г555гг100", 7, (float) 7.5));
        vehicles.add(new Car("л555лл102", (float) 3.5));
        vehicles.add(new Truck("г555гг101", 8, (float) 8.5));
        vehicles.add(new Truck("г555гг102", 8, (float) 8.5));
        Parking parking = new Parking(2, 3, 3);
        parking.init();
        assertFalse(parking.parkAll(vehicles));
    }
}
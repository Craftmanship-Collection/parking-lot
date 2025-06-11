package parkinglot.src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parkinglot.src.FareStrategyPattern.ConcreteStrategies.BasicHourlyRateStrategy;
import parkinglot.src.FareStrategyPattern.ConcreteStrategies.PremiumRateStrategy;
import parkinglot.src.ParkingLotController.ParkingLot;
import parkinglot.src.ParkingSpots.ConcreteParkingSpots.BikeParkingSpot;
import parkinglot.src.ParkingSpots.ConcreteParkingSpots.CarParkingSpot;
import parkinglot.src.ParkingSpots.ParkingSpot;
import parkinglot.src.VehicleFactoryPattern.Vehicle;
import parkinglot.src.VehicleFactoryPattern.VehicleFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class ParkingLotTest {

    private ParkingLot parkingLot;
    private Vehicle car;
    private Vehicle bike;

    @BeforeEach
    public void setUp() {
        ParkingSpot carSpot = new CarParkingSpot(1, "Car");
        ParkingSpot bikeSpot = new BikeParkingSpot(2, "Bike");
        List<ParkingSpot> spots = Arrays.asList(carSpot, bikeSpot);
        parkingLot = new ParkingLot(spots);

        car = VehicleFactory.createVehicle("Car", "CAR123", new BasicHourlyRateStrategy());
        bike = VehicleFactory.createVehicle("Bike", "BIKE123", new PremiumRateStrategy());
    }

    @Test
    public void testParkVehicleSuccess() {
        ParkingSpot spot = parkingLot.parkVehicle(car);
        assertNotNull(spot);
        assertTrue(spot.isOccupied());
        assertEquals(car, spot.getVehicle());
    }

    @Test
    public void testVacateVehicle() {
        ParkingSpot spot = parkingLot.parkVehicle(car);
        parkingLot.vacateSpot(spot, car);
        assertFalse(spot.isOccupied());
    }

    @Test
    public void testGetSpotByNumber() {
        ParkingSpot spot = parkingLot.getSpotByNumber(1);
        assertNotNull(spot);
        assertEquals(1, spot.getSpotNumber());
    }

    @Test
    public void testNoSpotAvailable() {
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(VehicleFactory.createVehicle("Car", "CAR456", new BasicHourlyRateStrategy()));
        ParkingSpot spot = parkingLot.parkVehicle(car); // No spot left
        assertNull(spot);
    }
}


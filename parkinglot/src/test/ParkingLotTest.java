package parkinglot.src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parkinglot.src.FareStrategyPattern.ConcreteStrategies.BasicHourlyRateStrategy;
import parkinglot.src.FareStrategyPattern.ConcreteStrategies.PremiumRateStrategy;
import parkinglot.src.ParkingLotController.ParkingLot;
import parkinglot.src.ParkingLotController.ParkingFloor;
import parkinglot.src.ParkingSpots.ParkingSpot;
import parkinglot.src.VehicleFactoryPattern.Vehicle;
import parkinglot.src.VehicleFactoryPattern.VehicleFactory;
import parkinglot.src.builder.ParkingLotBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    private ParkingLot parkingLot;
    private Vehicle car;
    private Vehicle bike;

    @BeforeEach
    public void setUp() {
        // Build a parking lot with 2 floors
        ParkingLotBuilder builder = new ParkingLotBuilder();
        builder.createFloor(1, 1, 1);
        builder.createFloor(2, 1, 1);
        parkingLot = builder.build();

        car = VehicleFactory.createVehicle("Car", "CAR123", new BasicHourlyRateStrategy());
        bike = VehicleFactory.createVehicle("Bike", "BIKE123", new PremiumRateStrategy());
    }

    @Test
    public void testParkVehicleSuccess() {
        ParkingSpot carSpot = parkingLot.parkVehicle(car);
        assertNotNull(carSpot);
        assertTrue(carSpot.isOccupied());
        assertEquals(car, carSpot.getVehicle());

        ParkingSpot bikeSpot = parkingLot.parkVehicle(bike);
        assertNotNull(bikeSpot);
        assertTrue(bikeSpot.isOccupied());
        assertEquals(bike, bikeSpot.getVehicle());
    }

    @Test
    public void testVacateVehicle() {
        ParkingSpot carSpot = parkingLot.parkVehicle(car);
        assertNotNull(carSpot);
        parkingLot.vacateSpot(carSpot, car);
        assertFalse(carSpot.isOccupied());
        assertNull(carSpot.getVehicle());
    }

    @Test
    public void testGetSpotByNumberFromFloors() {
        List<ParkingFloor> floors = parkingLot.getFloors();
        ParkingFloor firstFloor = floors.get(0);
        ParkingSpot targetSpot = firstFloor.getParkingSpots().get(0);

        ParkingSpot retrievedSpot = parkingLot.findAvailableSpot(targetSpot.getSpotType());
        assertEquals(targetSpot, retrievedSpot);
    }

    @Test
    public void testNoSpotAvailable() {
        // Fill all car spots
        parkingLot.parkVehicle(VehicleFactory.createVehicle("Car", "C1", new BasicHourlyRateStrategy()));
        parkingLot.parkVehicle(VehicleFactory.createVehicle("Car", "C2", new BasicHourlyRateStrategy()));
        // This third car should not find a spot
        ParkingSpot noSpot = parkingLot.parkVehicle(car);
        assertNull(noSpot);
    }
}

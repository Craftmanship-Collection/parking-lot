package parkinglot.src.test;

import org.junit.jupiter.api.Test;
import parkinglot.src.FareStrategyPattern.ConcreteStrategies.BasicHourlyRateStrategy;
import parkinglot.src.FareStrategyPattern.ConcreteStrategies.PremiumRateStrategy;
import parkinglot.src.VehicleFactoryPattern.Vehicle;
import parkinglot.src.VehicleFactoryPattern.VehicleFactory;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleFactoryTest {

    @Test
    public void testCreateCarVehicle() {
        Vehicle car = VehicleFactory.createVehicle("Car", "CAR123", new BasicHourlyRateStrategy());
        assertEquals("Car", car.getVehicleType());
        assertEquals("CAR123", car.getLicensePlate());
    }

    @Test
    public void testCreateBikeVehicle() {
        Vehicle bike = VehicleFactory.createVehicle("Bike", "BIKE123", new PremiumRateStrategy());
        assertEquals("Bike", bike.getVehicleType());
        assertEquals("BIKE123", bike.getLicensePlate());
    }
}


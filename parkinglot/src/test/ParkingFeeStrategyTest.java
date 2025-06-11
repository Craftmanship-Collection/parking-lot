package parkinglot.src.test;

import org.junit.jupiter.api.Test;
import parkinglot.src.CommonEnum.DurationType;
import parkinglot.src.FareStrategyPattern.ConcreteStrategies.BasicHourlyRateStrategy;
import parkinglot.src.FareStrategyPattern.ConcreteStrategies.PremiumRateStrategy;
import parkinglot.src.FareStrategyPattern.ParkingFeeStrategy;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingFeeStrategyTest {

    @Test
    public void testBasicHourlyRateStrategy() {
        ParkingFeeStrategy strategy = new BasicHourlyRateStrategy();
        assertEquals(20.0, strategy.calculateFee("Car", 2, DurationType.HOURS));
    }

    @Test
    public void testPremiumRateStrategy() {
        ParkingFeeStrategy strategy = new PremiumRateStrategy();
        assertEquals(24.0, strategy.calculateFee("Bike", 3, DurationType.HOURS));
    }
}


package parkinglot.src.VehicleFactoryPattern.ConcreteVehicles;


import parkinglot.src.FareStrategyPattern.ParkingFeeStrategy;
import parkinglot.src.VehicleFactoryPattern.Vehicle;

public class OtherVehicle extends Vehicle {
    public OtherVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy feeStrategy) {
        super(licensePlate, vehicleType, feeStrategy);
    }
}

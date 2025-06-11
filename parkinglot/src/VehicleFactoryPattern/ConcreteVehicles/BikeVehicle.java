package parkinglot.src.VehicleFactoryPattern.ConcreteVehicles;


import parkinglot.src.FareStrategyPattern.ParkingFeeStrategy;
import parkinglot.src.VehicleFactoryPattern.Vehicle;

public class BikeVehicle extends Vehicle {
    public BikeVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy feeStrategy) {
        super(licensePlate, vehicleType, feeStrategy);
    }
}

package parkinglot.src.VehicleFactoryPattern.ConcreteVehicles;


import parkinglot.src.FareStrategyPattern.ParkingFeeStrategy;
import parkinglot.src.VehicleFactoryPattern.Vehicle;

public class CarVehicle extends Vehicle {
    public CarVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy feeStrategy) {
        super(licensePlate, vehicleType, feeStrategy);
    }
}

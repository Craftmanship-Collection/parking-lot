package parkinglot.src.ParkingSpots.ConcreteParkingSpots;


import parkinglot.src.ParkingSpots.ParkingSpot;
import parkinglot.src.VehicleFactoryPattern.Vehicle;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Car".equalsIgnoreCase(vehicle.getVehicleType());
    }
}

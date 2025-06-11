package parkinglot.src.ParkingSpots.ConcreteParkingSpots;


import parkinglot.src.ParkingSpots.ParkingSpot;
import parkinglot.src.VehicleFactoryPattern.Vehicle;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Bike".equalsIgnoreCase(vehicle.getVehicleType());
    }
}

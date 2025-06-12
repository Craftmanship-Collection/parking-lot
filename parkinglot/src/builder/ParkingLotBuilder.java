package parkinglot.src.builder;

import parkinglot.src.ParkingLotController.ParkingFloor;
import parkinglot.src.ParkingLotController.ParkingLot;
import parkinglot.src.ParkingSpots.ConcreteParkingSpots.BikeParkingSpot;
import parkinglot.src.ParkingSpots.ConcreteParkingSpots.CarParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotBuilder {
    private final List<ParkingFloor> floors = new ArrayList<>();

    public ParkingLotBuilder createFloor(int floorNumber, int numCarSpots, int numBikeSpots) {
        ParkingFloor floor = new ParkingFloor(floorNumber);
        for (int i = 1; i <= numCarSpots; i++) {
            floor.addParkingSpot(new CarParkingSpot(i, "Car"));
        }
        for (int i = 1; i <= numBikeSpots; i++) {
            floor.addParkingSpot(new BikeParkingSpot(numCarSpots + i, "Bike"));
        }
        floors.add(floor);
        return this;
    }

    public ParkingLot build() {
        return new ParkingLot(floors);
    }
}

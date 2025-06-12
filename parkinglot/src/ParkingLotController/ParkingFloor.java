package parkinglot.src.ParkingLotController;

import parkinglot.src.ParkingSpots.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSpots = new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public ParkingSpot findAvailableSpot(String vehicleType) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isOccupied() && spot.getSpotType().equalsIgnoreCase(vehicleType)) {
                return spot;
            }
        }
        return null;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}


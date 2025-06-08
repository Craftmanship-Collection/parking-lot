package parkinglot.enums;

public enum VehicleType {
    TWO_WHEELER(100.00),
    FOUR_WHEELER(200.00);

    private final Double costPerHour;

    VehicleType(Double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public Double getCostPerHour() {
        return costPerHour;
    }
}

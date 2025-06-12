package parkinglot.src;



import parkinglot.src.CommonEnum.DurationType;
import parkinglot.src.FareStrategyPattern.ConcreteStrategies.BasicHourlyRateStrategy;
import parkinglot.src.FareStrategyPattern.ConcreteStrategies.PremiumRateStrategy;
import parkinglot.src.FareStrategyPattern.ParkingFeeStrategy;
import parkinglot.src.ParkingLotController.ParkingLot;
import parkinglot.src.ParkingSpots.ConcreteParkingSpots.BikeParkingSpot;
import parkinglot.src.ParkingSpots.ConcreteParkingSpots.CarParkingSpot;
import parkinglot.src.ParkingSpots.ParkingSpot;
import parkinglot.src.PaymentStrategyPattern.ConcretePaymentStrategies.CashPayment;
import parkinglot.src.PaymentStrategyPattern.ConcretePaymentStrategies.CreditCardPayment;
import parkinglot.src.PaymentStrategyPattern.PaymentStrategy;
import parkinglot.src.VehicleFactoryPattern.Vehicle;
import parkinglot.src.VehicleFactoryPattern.VehicleFactory;
import parkinglot.src.builder.ParkingLotBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLotBuilder()
                .createFloor(1, 2, 2)
                .createFloor(2, 3, 1)
                .build();

        Vehicle car1 = VehicleFactory.createVehicle("Car", "CAR123", new BasicHourlyRateStrategy());
        Vehicle bike1 = VehicleFactory.createVehicle("Bike", "BIKE456", new PremiumRateStrategy());

        ParkingSpot carSpot = parkingLot.parkVehicle(car1);
        ParkingSpot bikeSpot = parkingLot.parkVehicle(bike1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose payment method: 1) Credit Card  2) Cash");
        int paymentChoice = scanner.nextInt();

        if (carSpot != null) {
            double carFee = car1.calculateFee(2, DurationType.HOURS);
            getPaymentStrategy(paymentChoice, carFee).processPayment(carFee);
            parkingLot.vacateSpot(carSpot, car1);
        }

        if (bikeSpot != null) {
            double bikeFee = bike1.calculateFee(3, DurationType.HOURS);
            getPaymentStrategy(paymentChoice, bikeFee).processPayment(bikeFee);
            parkingLot.vacateSpot(bikeSpot, bike1);
        }

        scanner.close();
    }

    private static PaymentStrategy getPaymentStrategy(int method, double fee) {
        return method == 2 ? new CashPayment(fee) : new CreditCardPayment(fee);
    }
}


    /*

Output :

Vehicle parked successfully in spot: 1
Vehicle parked successfully in spot: 3
Vehicle parked successfully in spot: 2
Vehicle parked successfully in spot: 4
Select payment method for your vehicle:
1. Credit Card
2. Cash
1
Processing credit card payment of $20.0
Car vacated the spot: 1
Processing credit card payment of $24.0
Bike vacated the spot: 3

Process finished with exit code 0

     */
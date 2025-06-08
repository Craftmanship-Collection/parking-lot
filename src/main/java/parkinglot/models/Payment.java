package parkinglot.models;

import java.util.Scanner;

import parkinglot.ParkingLot;
import parkinglot.strategy.paymentstrategy.CashPaymentStrategy;
import parkinglot.strategy.paymentstrategy.PaymentStrategy;

public class Payment {
    private PaymentStrategy strategy;
    private Vehicle vehicle;

    public Payment(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void chooseStrategy() {
        printStrategy();

        Integer choice = ParkingLot.interaction.readInt();

        strategy = new CashPaymentStrategy();
    }

    public void printStrategy() {
        ParkingLot.interaction.write("choose one of the following strategies to pay the amount");
        ParkingLot.interaction.write("1. Cash");
    }

    public Token computePayment() {
        Double cost = calculateCost();
        ParkingLot.interaction.write("cost for your parking: " + cost);
        chooseStrategy();

        Token completePayment = strategy.completePayment(vehicle, cost);
        strategy.printToken(completePayment);
        return completePayment;
    }

    public Double calculateCost() {
        Long timeSpentInHours = (vehicle.getOutTime().getTime() - vehicle.getInTime().getTime())
                / (1000 * 60 * 60);

        return timeSpentInHours * vehicle.getVehicleType().getCostPerHour();
    }
}

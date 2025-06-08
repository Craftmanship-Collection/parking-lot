package parkinglot.strategy.paymentstrategy;

import java.util.Scanner;

import parkinglot.ParkingLot;
import parkinglot.enums.PaymentType;
import parkinglot.models.Token;
import parkinglot.models.Vehicle;

public class CashPaymentStrategy implements PaymentStrategy {

    @Override
    public Token completePayment(Vehicle vehicle, Double cost) {
        // wait for api to respond
        // try (Scanner sc = new Scanner(System.in)) {
        // System.out.println("Did the payment done? ");
        // sc.nextInt();
        // do some thing for negative issue
        ParkingLot.interaction.write("Did the payment done? ");
        ParkingLot.interaction.readInt();

        Token token = new Token.TokenBuilder()
                .vehicle(vehicle)
                .paymentType(PaymentType.CASH)
                .cost(cost).build();

        return token;
    }

    @Override
    public void printToken(Token token) {

    }

}

package parkinglot.strategy.paymentstrategy;

import parkinglot.ParkingLot;
import parkinglot.enums.PaymentType;
import parkinglot.models.Token;
import parkinglot.models.Vehicle;

public class CashPaymentStrategy implements PaymentStrategy {

    @Override
    public Token completePayment(Vehicle vehicle, Double cost) {
        // do something for negative issue
        // This comformation should come from the payment api or the Cashier
        ParkingLot.interaction.write("Did the payment done? ");
        ParkingLot.interaction.read();

        Token token = new Token.TokenBuilder()
                .vehicle(vehicle)
                .paymentType(PaymentType.CASH)
                .cost(cost).build();

        return token;
    }

    @Override
    public void printToken(Token token) {
        System.out.println(token);
    }

}

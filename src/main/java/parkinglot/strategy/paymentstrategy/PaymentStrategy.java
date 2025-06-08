package parkinglot.strategy.paymentstrategy;

import parkinglot.models.Token;
import parkinglot.models.Vehicle;

public interface PaymentStrategy {
    Token completePayment(Vehicle vehicle, Double cost);

    void printToken(Token token);
}

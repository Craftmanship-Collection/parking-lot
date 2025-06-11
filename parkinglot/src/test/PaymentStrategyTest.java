package parkinglot.src.test;

import org.junit.jupiter.api.Test;
import parkinglot.src.PaymentStrategyPattern.ConcretePaymentStrategies.CashPayment;
import parkinglot.src.PaymentStrategyPattern.ConcretePaymentStrategies.CreditCardPayment;
import parkinglot.src.PaymentStrategyPattern.PaymentStrategy;

public class PaymentStrategyTest {

    @Test
    public void testCreditCardPayment() {
        PaymentStrategy payment = new CreditCardPayment(100);
        payment.processPayment(100); // You can validate using logs or a mock in real-world test
    }

    @Test
    public void testCashPayment() {
        PaymentStrategy payment = new CashPayment(100);
        payment.processPayment(100); // You can validate using logs or a mock in real-world test
    }
}


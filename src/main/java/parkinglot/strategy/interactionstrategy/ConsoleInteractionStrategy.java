package parkinglot.strategy.interactionstrategy;

import java.util.Scanner;

public class ConsoleInteractionStrategy implements InteractionStrategy {
    private static Scanner sc = new Scanner(System.in);

    @Override
    public String read() {
        return sc.nextLine();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public Integer readInt() {
        return sc.nextInt();
    }

    @Override
    public void close() {
        sc.close();
    }
}

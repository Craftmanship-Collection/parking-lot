package parkinglot.strategy.interactionstrategy;

public interface InteractionStrategy {
    String read();

    void write(String message);

    void close();

    Integer readInt();

}

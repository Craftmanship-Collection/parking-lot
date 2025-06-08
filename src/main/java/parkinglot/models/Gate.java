package parkinglot.models;

import parkinglot.enums.GateType;

public class Gate {
    private String name;
    private GateType gateType;

    public Gate() {

    }

    public Gate(String name, GateType gateType) {
        this.name = name;
        this.gateType = gateType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

}

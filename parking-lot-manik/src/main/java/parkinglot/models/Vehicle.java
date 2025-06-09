package parkinglot.models;

import java.util.Date;

import parkinglot.enums.VehicleType;

public class Vehicle {
    private String licenseNo;
    private VehicleType vehicleType;

    private Date inTime;
    private Date outTime;

    public Vehicle(String licenseNo, VehicleType vehicleType) {
        this.licenseNo = licenseNo;
        this.vehicleType = vehicleType;
        inTime = new Date();
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    @Override
    public String toString() {
        return "Vehicle [licenseNo=" + licenseNo + ", vehicleType=" + vehicleType + ", inTime=" + inTime + ", outTime="
                + outTime + "]";
    }

}

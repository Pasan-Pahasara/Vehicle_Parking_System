package model;

public abstract class Vehicle implements Vehicles{
    private String vehicleNo;
    private String vehicleType;
    private Integer maxWeight;
    private Integer noOfPassengers;

    public Vehicle() {
    }

    public Vehicle(String vehicleNo, String vehicleType, Integer maxWeight, Integer noOfPassengers) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.maxWeight = maxWeight;
        this.noOfPassengers = noOfPassengers;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(Integer noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", maxWeight=" + maxWeight +
                ", noOfPassengers=" + noOfPassengers +
                '}';
    }
//    abstract public int park(String vehicleNo,String vehicleType)throws IOException;
}

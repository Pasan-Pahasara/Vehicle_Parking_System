package model;

import java.io.IOException;

import static controller.InParkingFormController.parkVehicleTMObservableList;

public class CargoLorry extends Vehicle {
    int[] cargoLorrySlot = new int[]{5, 6, 7, 8, 9, 10, 11};

    public CargoLorry() {
        super();
    }

    public CargoLorry(String vehicleNo, String vehicleType, Integer maxWeight, Integer noOfPassengers) {
        super(vehicleNo, vehicleType, maxWeight, noOfPassengers);
    }

    @Override
    public int park(String vehicleNo, String vehicleType) throws IOException {
        L1:
        for (int i : cargoLorrySlot) {
            if (parkVehicleTMObservableList.size() == 0) {
                return i;
            } else {
                L2:
                for (int j = 0; j < parkVehicleTMObservableList.size(); j++) {
                    if (parkVehicleTMObservableList.get(j).getParkingSlot() == i) {
                        continue L1;
                    } else {
                        if (j != parkVehicleTMObservableList.size() - 1) {
                            continue L2;
                        } else {
                            return i;
                        }
                    }
                }
            }
        }
        return 0;
    }
}

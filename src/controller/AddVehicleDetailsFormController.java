package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Vehicle;
import view.TM.VehiclesTM;

import java.util.Optional;

import static controller.AddDriverFormController.driversArrayList;
import static controller.AddVehicleFormController.vehicleArrayList;

public class AddVehicleDetailsFormController {
    public TableView tblAddVehicleDetails;
    public TableColumn colNo;
    public TableColumn colType;
    public TableColumn colWeight;
    public TableColumn colNoOfPassengers;
    public TableColumn colDelete;

    public void initialize() {

        colNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colWeight.setCellValueFactory(new PropertyValueFactory<>("maxWeight"));
        colNoOfPassengers.setCellValueFactory(new PropertyValueFactory<>("noOfPassengers"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));

        loadAllVehicleDetails();
    }

    private void loadAllVehicleDetails() {
        ObservableList<VehiclesTM> observableList = FXCollections.observableArrayList();
        for (Vehicle temp : vehicleArrayList) {
            Button btn=new Button("Delete");
            observableList.add(new VehiclesTM(temp.getVehicleNo(), temp.getVehicleType(), temp.getMaxWeight(), temp.getNoOfPassengers(),btn));

            btn.setOnAction(event -> {
                ButtonType yes=new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no=new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are you want to delete Vehicle?",yes,no);
                alert.setHeaderText(null);
                Optional<ButtonType> result=alert.showAndWait();

                if(result.orElse(no)==yes){
                    vehicleArrayList.remove(temp);
                    loadAllVehicleDetails();
                }
            });
        }
        tblAddVehicleDetails.setItems(observableList);
    }
}

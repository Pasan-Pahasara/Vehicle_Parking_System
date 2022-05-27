package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Drivers;
import view.TM.DriversTM;

import java.util.Optional;

import static controller.AddDriverFormController.driversArrayList;

public class AddDriverDetailsFormController {
    public TableView tblAddDriverDetails;
    public TableColumn colName;
    public TableColumn colNic;
    public TableColumn colLicense;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDelete;
    public VBox addDriverContext;

    public void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colLicense.setCellValueFactory(new PropertyValueFactory<>("licenseNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));

        loadAllDriversDetails();
    }

    private void loadAllDriversDetails() {
        ObservableList<DriversTM> observableList = FXCollections.observableArrayList();
        for (Drivers temp : driversArrayList) {
            Button btn=new Button("Delete");
            observableList.add(new DriversTM(temp.getName(),temp.getNIC(),temp.getLicenseNo(),temp.getAddress(),temp.getContact(),btn));

            btn.setOnAction(event -> {
                ButtonType yes=new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no=new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are you want to delete Driver?",yes,no);
                alert.setHeaderText(null);
                Optional<ButtonType> result=alert.showAndWait();

                if(result.orElse(no)==yes){
                    driversArrayList.remove(temp);
                    loadAllDriversDetails();
               }
            });
        }
        tblAddDriverDetails.setItems(observableList);
    }

}

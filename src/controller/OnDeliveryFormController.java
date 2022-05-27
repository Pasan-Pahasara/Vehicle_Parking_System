package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.TM.OnDeliveryVehicleTM;

public class OnDeliveryFormController {
    public static ObservableList<OnDeliveryVehicleTM> onDeliveryVehicleTMObservableList = FXCollections.observableArrayList();
    public TableView tblOnDelivery;
    public TableColumn colNo;
    public TableColumn colType;
    public TableColumn colName;
    public TableColumn colLeftTime;

    public void initialize() {
        colNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));
        tblOnDelivery.setItems(onDeliveryVehicleTMObservableList);
    }
}

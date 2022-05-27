package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class HomePageFormController {
    public JFXComboBox cmbOptions;
    public AnchorPane windowNavigateContext;
    public AnchorPane homePageContext;
    public AnchorPane anchorPane;

    public void initialize() throws IOException {
        //=-------------------------------------------------------------------
        AddVehicleFormController.windowNavigateContext = windowNavigateContext;
        AddDriverFormController.windowNavigateContext = windowNavigateContext;
        //--------------------------------------------------------------------


        cmbOptions.getItems().addAll("In Parking", "On Delivery");

        cmbOptions.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue.equals("On Delivery")) {
                URL resource = getClass().getResource("../view/OnDeliveryForm.fxml");
                Parent load = null;
                try {
                    load = FXMLLoader.load(resource);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                windowNavigateContext.getChildren().clear();
                windowNavigateContext.getChildren().add(load);
            }
            if (newValue.equals("In Parking")) {
                URL resource = getClass().getResource("../view/InParkingForm.fxml");
                Parent load = null;
                try {
                    load = FXMLLoader.load(resource);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                windowNavigateContext.getChildren().clear();
                windowNavigateContext.getChildren().add(load);
            }
        });
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ParkingHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) homePageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void addVehiclesOnAction(ActionEvent actionEvent) throws IOException {
        URL resource2 = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load2 = FXMLLoader.load(resource2);
        Scene scene = new Scene(load2);
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UTILITY);
        stage1.setY(250);
        stage1.setX(635);
        stage1.setTitle("Add Vehicle");
        stage1.setScene(scene);
        stage1.show();
    }

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage2 = new Stage();
        stage2.initStyle(StageStyle.UTILITY);
        stage2.setY(250);
        stage2.setX(635);
        stage2.setTitle("Add Driver");
        stage2.setScene(scene);
        stage2.show();
    }
}

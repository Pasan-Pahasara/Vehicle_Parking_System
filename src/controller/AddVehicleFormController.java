package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Bus;
import model.CargoLorry;
import model.Van;
import model.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddVehicleFormController extends Loader {


    public static JFXButton btnViewDetails;
    public static AnchorPane windowNavigateContext;
    static ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();
    public JFXComboBox vehicleCmb;
    public JFXTextField txtVehicleNo;
    public JFXTextField txtNoOfPassengers;
    public JFXTextField txtMaxWeight;
    public Label vehicleLabel1;
    public Label vehicleLabel2;
    public Label vehicleLabel3;
    public JFXButton btnAddVehicle;
    public AnchorPane addVehicleContext;

    public void initialize() {
        vehicleCmb.getItems().addAll("Van", "Bus", "Cargo Lorry");
    }

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        addVehicles();
    }

    private void addVehicles() throws IOException {
        if (vehicleArrayList.size() == 14) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "You Cannot Add Vehicles!...", ButtonType.CLOSE);
            alert.setHeaderText(null);
            alert.show();
        } else {
            try {

                if (vehicleCmb.getSelectionModel().getSelectedItem().toString().equals("Van")) {
                    Van van = new Van(txtVehicleNo.getText(), vehicleCmb.getValue().toString(), Integer.parseInt(txtMaxWeight.getText()), Integer.parseInt(txtNoOfPassengers.getText()));
                    txtVehicleNo.clear();
                    txtMaxWeight.clear();
                    txtNoOfPassengers.clear();

                    if (vehicleArrayList.add(van)) {
                        vehicleCmb.getSelectionModel().clearSelection();
                        alert();
                    } else {
                        Alert alert4 = new Alert(Alert.AlertType.WARNING, "Try Again...", ButtonType.CLOSE);
                        alert4.setHeaderText(null);
                        alert4.show();
                    }
                }

                if (vehicleCmb.getSelectionModel().getSelectedItem().toString().equals("Bus")) {
                    Bus bus = new Bus(txtVehicleNo.getText(), vehicleCmb.getValue().toString(), Integer.parseInt(txtMaxWeight.getText()), Integer.parseInt(txtNoOfPassengers.getText()));
                    txtVehicleNo.clear();
                    vehicleCmb.getItems().clear();
                    txtMaxWeight.clear();
                    txtNoOfPassengers.clear();

                    if (vehicleArrayList.add(bus)) {
                        vehicleCmb.getSelectionModel().clearSelection();
                        alert();
                    } else {
                        Alert alert4 = new Alert(Alert.AlertType.WARNING, "Try Again...", ButtonType.CLOSE);
                        alert4.setHeaderText(null);
                        alert4.show();
                    }
                }
                if (vehicleCmb.getSelectionModel().getSelectedItem().toString().equals("Cargo Lorry")) {
                    CargoLorry cargoLorry = new CargoLorry(txtVehicleNo.getText(), vehicleCmb.getValue().toString(), Integer.parseInt(txtMaxWeight.getText()), Integer.parseInt(txtNoOfPassengers.getText()));
                    txtVehicleNo.clear();
                    txtMaxWeight.clear();
                    txtNoOfPassengers.clear();

                    if (vehicleArrayList.add(cargoLorry)) {
                        vehicleCmb.getSelectionModel().clearSelection();
                        alert();
                    } else {
                        Alert alert6 = new Alert(Alert.AlertType.WARNING, "Try Again...", ButtonType.CLOSE);
                        alert6.setHeaderText(null);
                        alert6.show();
                    }
                }
            } catch (NullPointerException e) {

            }
        }
    }

    private void alert() {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Saved Successfully...", ButtonType.CLOSE, ButtonType.OK);
        alert1.setHeaderText(null);
        Optional<ButtonType> buttonType = alert1.showAndWait();
        if (buttonType.get().equals(ButtonType.OK)) {

        } else {
            Stage stage = (Stage) addVehicleContext.getScene().getWindow();
            stage.close();
        }
    }

    public void checkingVehicleNo(KeyEvent keyEvent) {
        String value = "^([A-Z0-9 ]{1,3}[-]([0-9]{4}))$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtVehicleNo.getText());
        if (!match.matches()) {
            vehicleLabel1.setText("Invalid No!");
        } else {
            vehicleLabel1.setText("");
        }
    }

    public void checkingWeight(KeyEvent keyEvent) {
        String value = "^([0-9]{1,4})$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtMaxWeight.getText());
        if (!match.matches()) {
            vehicleLabel2.setText("Invalid Weight!");
        } else {
            vehicleLabel2.setText("");
        }
    }

    public void checkingPassengers(KeyEvent keyEvent) {
        String value = "^([0-9]{1,2})$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtNoOfPassengers.getText());
        if (!match.matches()) {
            vehicleLabel3.setText("Invalid Passengers!");
        } else {
            vehicleLabel3.setText("");
        }
    }

    public void moveToTypeOnAction(ActionEvent actionEvent) {
        vehicleCmb.requestFocus();
    }

    public void moveToWeightOnAction(ActionEvent actionEvent) {
        txtMaxWeight.requestFocus();
    }

    public void moveToPassengerOnAction(ActionEvent keyEvent) {
        txtNoOfPassengers.requestFocus();
    }

    public void enterAddVehicle(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) addVehicles();
    }

    public void viewDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) addVehicleContext.getScene().getWindow();
        stage1.close();
        URL resource = getClass().getResource("../view/AddVehicleDetailsForm.fxml");
        Parent load = null;
        try {
            load = FXMLLoader.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            windowNavigateContext.getChildren().clear();
            windowNavigateContext.getChildren().add(load);
        } catch (NullPointerException e) {
        }
    }

}

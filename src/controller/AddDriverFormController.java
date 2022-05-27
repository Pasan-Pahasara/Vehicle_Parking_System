package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Drivers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddDriverFormController {

    public static AnchorPane windowNavigateContext;
    static ArrayList<Drivers> driversArrayList = new ArrayList<>();
    public JFXTextField txtDriverName;
    public JFXTextField txtNic;
    public JFXTextField txtLicenseNo;
    public JFXTextArea txtAddress;
    public JFXTextField txtContact;
    public Label driverLabel1;
    public Label driverLabel2;
    public Label driverLabel3;
    public Label driverLabel4;
    public JFXButton btnAddDriver;
    public AnchorPane addDriverContext;
    public JFXButton btnViewDetails;

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        addDriver();
    }

    private void addDriver() throws IOException {
        try {
            Drivers drivers = new Drivers(txtDriverName.getText(), txtNic.getText(), txtLicenseNo.getText(), txtAddress.getText(), Integer.parseInt(txtContact.getText()));

            txtDriverName.clear();
            txtNic.clear();
            txtLicenseNo.clear();
            txtAddress.clear();
            txtContact.clear();

            if (driversArrayList.add(drivers)) {
                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Saved Successfully...", ButtonType.CLOSE, ButtonType.OK);
                alert1.setHeaderText(null);
                Optional<ButtonType> buttonType = alert1.showAndWait();
                if (buttonType.get().equals(ButtonType.OK)) {

                } else {
                    Stage stage = (Stage) addDriverContext.getScene().getWindow();
                    stage.close();
                }
            } else {
                Alert alert2 = new Alert(Alert.AlertType.WARNING, "Try Again...", ButtonType.CLOSE);
                alert2.setHeaderText(null);
                alert2.show();
            }
        } catch (NumberFormatException e) {
        }
    }

    private void enableAddDriverButton() {
        try {
            if (!txtDriverName.getText().equals("") && !txtNic.getText().equals("") && !txtLicenseNo.getText().equals("") && !txtAddress.getText().equals("") && !txtContact.getText().equals("")) {
                btnAddDriver.setDisable(false);
            }
        } catch (NullPointerException e) {

        }
    }

    public void checkingDriverName(KeyEvent keyEvent) {
        String value = "^([A-Za-z]{1,30})$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtDriverName.getText());
        if (!match.matches()) {
            driverLabel1.setText("Invalid Name!");
        } else {
            driverLabel1.setText("");
        }
    }

    public void checkingNIC(KeyEvent keyEvent) {
        String value = "^([0-9]{9}.([V]{1}))$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtNic.getText());
        if (!match.matches()) {
            driverLabel2.setText("Invalid NIC");
        } else {
            driverLabel2.setText("");
        }
    }

    public void checkingDrivingLicense(KeyEvent keyEvent) {
        String value = "^([B]{1}.([0-9]{6}))$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtLicenseNo.getText());
        if (!match.matches()) {
            driverLabel3.setText("Invalid Licence No");
        } else {
            driverLabel3.setText("");
        }
    }

    public void checkingContactNo(KeyEvent keyEvent) {
        String value = "^([0-9]{10})$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtContact.getText());
        if (!match.matches()) {
            driverLabel4.setText("Invalid Contact");
        } else {
            driverLabel4.setText("");
        }
    }

    public void moveToNicOnAction(ActionEvent actionEvent) {
        txtNic.requestFocus();
    }

    public void moveToLicenseNoOnAction(ActionEvent actionEvent) {
        txtLicenseNo.requestFocus();
    }

    public void moveToAddressOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void moveToContactOnAction(MouseEvent mouseEvent) {
        txtContact.requestFocus();

    }

    public void enterKeyAddDriver(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) addDriver();
    }

    public void viewDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) addDriverContext.getScene().getWindow();
        stage1.close();
        URL resource = getClass().getResource("../view/AddDriverDetailsForm.fxml");
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

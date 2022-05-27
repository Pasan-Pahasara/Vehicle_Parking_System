package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;
import view.TM.OnDeliveryVehicleTM;
import view.TM.ParkVehicleTM;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static controller.AddDriverFormController.driversArrayList;
import static controller.AddVehicleFormController.vehicleArrayList;
import static controller.InParkingFormController.parkVehicleTMObservableList;
import static controller.OnDeliveryFormController.onDeliveryVehicleTMObservableList;

public class ParkingHomeFormController {

    public AnchorPane ParkingHomeMoveContext;
    public AnchorPane ParkingHomeContext;
    public JFXTextField txtParkingSlot;
    public JFXTextField txtVehicleType;
    public Text label2;
    public Text label3;
    public JFXComboBox<String> cmbDriver;
    public JFXComboBox<String> cmbVehicle;
    public JFXButton btnPark;
    public JFXButton btnDelivery;


    public void initialize() {

        vehicles();
        drivers();
//        btnPark.setDisable(true);
//        btnDelivery.setDisable(true);

        for (Vehicle vehicle : vehicleArrayList) {
            cmbVehicle.getItems().add(vehicle.getVehicleNo());
        }
        cmbVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtParkingSlot.clear();
            cmbVehicle.setAccessibleText(newValue);
            for (Vehicle vehicle : vehicleArrayList) {
                if (newValue.equals(vehicle.getVehicleNo())) {
                    txtVehicleType.setText(vehicle.getVehicleType());
                    disableAndEnable(cmbVehicle.getValue());
                    if (!btnPark.isDisable()) {
                        try {
                            txtParkingSlot.setText(vehicle.park(vehicle.getVehicleNo(), vehicle.getVehicleType()) + "");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });

        for (Drivers drivers : driversArrayList) {
            cmbDriver.getItems().add(drivers.getName());
        }

        //-------------------------------------------RealTimeClock----------------------------------------------------------

        Thread clock = new Thread() {
            public void run() {
                for (; ; ) {
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm ");
                    Calendar cal = Calendar.getInstance();

                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR_OF_DAY);

                    try {
                        String state = null;
                        if (hour >= 12) {
                            state = "PM";
                        } else {
                            state = "AM";
                        }
                        label2.setText("" + String.format("%02d", hour) + ":" + String.format("%02d", minute) + " " + state);
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                }
            }
        };
        clock.start();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        label3.setText(formatter.format(date));
    }
    //-------------------------------------------------------------------------------------------------------------------------------------

    protected void vehicles() {
        vehicleArrayList.add(new Bus("NA-3434", "Bus", 3500, 60));
        vehicleArrayList.add(new Van("LM-6679", "Van", 1500, 4));
        vehicleArrayList.add(new Van("QA-3369", "Van", 1800, 6));
        vehicleArrayList.add(new Van("LM-6679", "Van", 1500, 4));
        vehicleArrayList.add(new Van("QA-3369", "Van", 1800, 6));
        vehicleArrayList.add(new CargoLorry("KB-3668", "Cargo Lorry", 2500, 2));
        vehicleArrayList.add(new CargoLorry("JJ-9878", "Cargo Lorry", 3000, 2));
        vehicleArrayList.add(new CargoLorry("GH-5772", "Cargo Lorry", 4000, 3));
        vehicleArrayList.add(new CargoLorry("XY-4456", "Cargo Lorry", 3500, 2));
        vehicleArrayList.add(new CargoLorry("YQ-3536", "Cargo Lorry", 2000, 2));
        vehicleArrayList.add(new CargoLorry("CBB-3566", "Cargo Lorry", 2500, 2));
        vehicleArrayList.add(new CargoLorry("QH-3444", "Cargo Lorry", 5000, 4));
    }

    protected void drivers() {
        driversArrayList.add(new Drivers("Sumith Kumara", "7835348345V", "B6474845", "Panadura", 0725637456));
        //       driversArrayList.add(new Drivers("Amila Pathirana","8826253734V","B3354674","Galle",0717573583));
        driversArrayList.add(new Drivers("Jthmal Perera", "9283289272V", "B3674589", "Horana", 0772452457));
        //       driversArrayList.add(new Drivers("Sumith Dissanayaka","9425245373V","B8366399","Kaluthara",0782686390));
        driversArrayList.add(new Drivers("Charith Sudara", "9573536833V", "B6835836", "Baththaramulla", 0771536662));
        driversArrayList.add(new Drivers("Prashan Dineth", "9362426738V", "B2683536", "Wadduwa", 0715353434));
        driversArrayList.add(new Drivers("Chethiya Dilan", "9162353436V", "B6836836", "Panadura", 0772436737));
        driversArrayList.add(new Drivers("Dushantha Perera ", "9255556343V", "B3334435", "Matara", 0777245343));
        //       driversArrayList.add(new Drivers("Dinesh Udara","9026344373V","B5343783","Hettimulla",0713456878));
        driversArrayList.add(new Drivers("Udana Chathuranga ", "9692653338V ", "B7888632", "Kottawa", 0772442444));
        driversArrayList.add(new Drivers("Mohommad Riaz", "9124537733V ", "B3638537", "Kaluthara", 0777544222));
        driversArrayList.add(new Drivers("Sandun Kumara ", "9563524267V ", "B2263333", "Panadura", 0772325544));
        driversArrayList.add(new Drivers("Priyanga Perera  ", "9135343537V  ", "B3853753 ", "Matara ", 0723344562));
    }

    public void disableAndEnable(String vehicleNo) {
        for (ParkVehicleTM tm : parkVehicleTMObservableList) {
            if (tm.getVehicleNo().equals(vehicleNo)) {
                btnDelivery.setDisable(false);
                btnPark.setDisable(true);
            }
        }
        if (!btnPark.isDisable()) {
            btnPark.setDisable(false);
            btnDelivery.setDisable(true);
        }
    }

    public void deliveryShiftOnAction(ActionEvent actionEvent) {
        try {
            refresh();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            parkVehicleTMObservableList.removeIf(temp -> temp.getVehicleNo().equals(cmbVehicle.getValue()));
            OnDeliveryVehicleTM onDeliveryVehicleTM = new OnDeliveryVehicleTM(cmbVehicle.getValue(),
                    txtVehicleType.getText(),
                    cmbDriver.getValue(),
                    LocalDateTime.now().format(dateTimeFormatter));
            onDeliveryVehicleTMObservableList.add(onDeliveryVehicleTM);
            refresh();
            btnDelivery.setDisable(true);
        } catch (NumberFormatException | IOException e) {

        }
    }

    public void managementLoginOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader =new FXMLLoader( getClass().getResource("../view/ManagementLoginForm.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        ManagementLoginFormController managementLoginFormController = fxmlLoader.getController();
        managementLoginFormController.setController(ParkingHomeMoveContext);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setOpacity(0.8);
        stage.setScene(scene);
        stage.show();
    }

    public void parkOnAction(ActionEvent actionEvent) {
        try {
            refresh();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            ParkVehicleTM parkedVehicleTM = new ParkVehicleTM(cmbVehicle.getValue(),
                    txtVehicleType.getText(),
                    Integer.parseInt(txtParkingSlot.getText()),
                    LocalDateTime.now().format(dateTimeFormatter));
            parkVehicleTMObservableList.add(parkedVehicleTM);
            txtParkingSlot.clear();
            refresh();
            btnPark.setDisable(true);
        } catch (NumberFormatException | IOException e) {

        }
    }

    private void refresh() throws IOException {
        URL resource = getClass().getResource("../view/ParkingHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        //ParkingHomeContext.getChildren().clear();
        ParkingHomeContext.getChildren().add(load);
    }

    public void refreshOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ParkingHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        ParkingHomeContext.getChildren().clear();
        ParkingHomeContext.getChildren().add(load);
    }
}
